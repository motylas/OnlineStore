import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;


public class DBConnection {
    Connection con = null;

    public void connection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/online_shop", "root", "");
        System.out.println("Xampp Mysql Connected as User...");
    }

    private void changeConnection(String type) throws SQLException {
        //con = DriverManager.getConnection("jdbc:mysql://localhost/online_shop", type, "");
        //System.out.println("Connected as " + type + "...");
    }


    String login(String login, String password) throws Exception {
        String type;
        String encPass = EncryptionDecryptionAES.encrypt(password);
        try {
            PreparedStatement pstmt = con.prepareStatement
                    ("SELECT * FROM online_shop.users WHERE login = ? AND user_password=?");
            pstmt.setString(1, login);
            pstmt.setString(2, encPass);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String log = rs.getString("login");
                String pass = rs.getString("user_password");
                type = rs.getString("type");
                int id = rs.getInt("id");
                if (login.equals(log) && encPass.equals(pass)) {
                    PreparedStatement ppst = con.prepareStatement
                            ("SELECT strike FROM online_shop.banned WHERE id = ?");
                    ppst.setInt(1, id);
                    ResultSet rss = ppst.executeQuery();
                    while (rss.next()) {
                        int strikes = rss.getInt("strike");
                        if (strikes >= 3) {
                            System.out.println("You got banned");
                            return "-5";
                        }
                    }
                    System.out.println("logged in!");
                    changeConnection(type);
                    return id+";"+type;
                }
            }
        } catch (Exception e) {
            System.out.println("Error404!");
            return "-1";
        }
        System.out.println("Wrong login or password");
        return "-1";
    }

    boolean register(String nick, String login, String password, String type, String name, String lastname, int phone_number, String email) throws Exception {
        String encPass = EncryptionDecryptionAES.encrypt(password);
        try {
            PreparedStatement pstmt = con.prepareStatement
                    ("CALL online_shop.register(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, nick);
            pstmt.setString(2, login);
            pstmt.setString(3, encPass);
            pstmt.setString(4, type);
            pstmt.setString(5, name);
            pstmt.setString(6, lastname);
            pstmt.setInt(7, phone_number);
            pstmt.setString(8, email);
            pstmt.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    boolean addProduct(int seller_id, String name, String country, int quantity, float price) {
        try {
            CallableStatement cstmt = con.prepareCall("{? = CALL checkCountry(?)}");
            cstmt.registerOutParameter(1, Types.BOOLEAN);
            cstmt.setString(2, country);
            cstmt.executeUpdate();
            boolean countryFound = cstmt.getBoolean(1);
            if (!countryFound) {
                System.out.println("COUNTRY NOT FOUND");
                return false;
            }
            PreparedStatement pstmt = con.prepareStatement
                    ("CALL online_shop.addProductToProducts(?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("Item already in products!");
        }
        try {
            PreparedStatement pstmt = con.prepareStatement
                    ("CALL online_shop.addProductToSeller_items(?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.setInt(3, quantity);
            pstmt.setFloat(4, price);
            pstmt.setInt(5, seller_id);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("COULDNT ADD PRODUCTS");
            return false;
        }
        return true;
    }

    boolean strikeSeller(String sellerNickname) {
        try {
            PreparedStatement pstmt = con.prepareStatement
                    ("CALL online_shop.strikeSeller(?)");
            pstmt.setString(1, sellerNickname);
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("Cos poszlo nie tak!");
            return false;
        }
        return true;
    }

    ArrayList<Product> showProducts(String productName, String sellerNick, float maxPrice, float minPrice, int minQuantity, String country) {
        ArrayList<Product> productsList = new ArrayList<>();
        try {
            if (productName == null || productName.isBlank()) {
                productName = "%";
            } else {
                productName += "%";
            }
            if (sellerNick == null || sellerNick.isBlank()) {
                sellerNick = "%";
            } else {
                sellerNick += "%";
            }
            if (maxPrice == 0) {
                maxPrice = 999999999;
            }
            if (country == null || country.isBlank()) {
                country = "%";
            } else {
                country += "%";
            }
            PreparedStatement pstmt = con.prepareStatement
                    ("SELECT p.name,u.nickname,c.name,quantity,price FROM online_shop.products as p " +
                            "JOIN online_shop.country c on c.id = p.country_id " +
                            "JOIN online_shop.seller_items si on p.id = si.product_id " +
                            "JOIN online_shop.users u on si.seller_id = u.id " +
                            "WHERE p.name LIKE ? AND " +
                            "c.name LIKE ? AND " +
                            "u.nickname LIKE ? AND " +
                            "quantity > ? AND " +
                            "price > ? AND " +
                            "price < ?");
            pstmt.setString(1, productName);
            pstmt.setString(2, country);
            pstmt.setString(3, sellerNick);
            pstmt.setInt(4, minQuantity);
            pstmt.setFloat(5, minPrice);
            pstmt.setFloat(6, maxPrice);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> titles = new ArrayList<>();
            titles.add("Description");
            titles.add("Seller");
            titles.add("Country");
            titles.add("Quantity");
            titles.add("Price per unit");
            //productsList.add(titles);
            while (rs.next()) {
                String prodName = rs.getString(1);
                String sellNick = rs.getString(2);
                String cName = rs.getString(3);
                int q = rs.getInt(4);
                float cost = rs.getFloat(5);
                Product productInfo = new Product(prodName,sellNick,cName,q,cost);
                productsList.add(productInfo);
            }
        } catch (Exception e) {
            System.out.println("Cos poszlo nie tak!");
            return null;
        }
        return productsList;
    }

    boolean addProductsToOrder(ArrayList<Product> basket, int user_id) {
        int order_id=-1;
        try {
            ArrayList<String> sellersName = new ArrayList<>();
            for (Product productInfo: basket) {
                if(!sellersName.contains(productInfo.seller)){
                    sellersName.add(productInfo.seller);
                    System.out.println("halo1");
                    CallableStatement cstmt = con.prepareCall
                            ("{CALL online_shop.addNewOrder(?,?,?)}");
                    System.out.println("halo2");
                    cstmt.setString(1,productInfo.seller);
                    cstmt.setInt(2,user_id);
                    cstmt.registerOutParameter(3, Types.INTEGER);
                    System.out.println("halo123");
                    System.out.println(productInfo.seller);
                    System.out.println(user_id);
                    cstmt.execute();
                    System.out.println("halo3");
                    order_id = cstmt.getInt(3);
                    System.out.println("halo4");
                }

                PreparedStatement pstmt = con.prepareStatement
                        ("CALL online_shop.addProductToOrder(?,?,?,?,?)");
                pstmt.setInt(1,order_id);
                pstmt.setString(2,productInfo.description);
                pstmt.setString(3,productInfo.country);
                pstmt.setInt(4,productInfo.quantity);
                pstmt.setFloat(5,productInfo.pricePerUnit);
                pstmt.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Cos poszlo nie tak!");
            return false;
        }
        return true;
    }

    boolean addAdmin(String nick, String login, String pass){
        try{
            String encPass = EncryptionDecryptionAES.encrypt(pass);
            PreparedStatement pstmt = con.prepareStatement
                    ("INSERT INTO online_shop.users(nickname, login, user_password, type) VALUES(?,?,?,'admin')");
            pstmt.setString(1,nick);
            pstmt.setString(2,login);
            pstmt.setString(3,encPass);
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("wrong");
            return false;
        }
        return true;
    }
}