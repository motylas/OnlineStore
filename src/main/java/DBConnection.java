import com.mysql.cj.protocol.Resultset;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.ECField;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DBConnection {
    static Connection con = null;

    static public void connection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/online_shop", "root", "");
        System.out.println("Xampp Mysql Connected..");
    }

    static int login(String login, String password) throws Exception {
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
                            return -5;
                        }
                    }
                    System.out.println("logged in!");
                    return id;
                }
            }
        } catch (Exception e) {
            System.out.println("Error404!");
            return -1;
        }
        System.out.println("Wrong login or password");
        return -1;
    }

    static boolean register(String nick, String login, String password, String type, String name, String lastname, int phone_number, String email) throws Exception {
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
            System.out.println("Cos poszlo nie tak!");
            return false;
        }
        return true;
    }

    static boolean addProduct(int seller_id, String name, String country, int quantity, float price) {
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

    static boolean strikeSeller(String sellerNickname) {
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

    static boolean showProducts(String productName, String sellerNick, float maxPrice, float minPrice, int minQuantity, String country) {
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
            System.out.print("Prod: " + productName);
            System.out.print("  Seller Nicnkame: " + sellerNick);
            System.out.print("  Country: " + country);
            System.out.print("  PriceMin: " + minPrice);
            System.out.print("  PriceMax: " + maxPrice);
            System.out.print("  quantity: " + minQuantity);
            System.out.println();
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
            System.out.println("ys2");
            pstmt.setString(1, productName);
            pstmt.setString(2, country);
            pstmt.setString(3, sellerNick);
            pstmt.setInt(4, minQuantity);
            pstmt.setFloat(5, minPrice);
            pstmt.setFloat(6, maxPrice);
            System.out.println("ys3");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("ys4");
            while (rs.next()) {
                String prodName = rs.getString(1);
                String sellNick = rs.getString(2);
                String cName = rs.getString(3);
                int q = rs.getInt(4);
                float cost = rs.getFloat(5);
                System.out.print("Prod: " + prodName);
                System.out.print("  Seller Nicnkame: " + sellNick);
                System.out.print("  Country: " + cName);
                System.out.print("  Quantity: " + q);
                System.out.print("  cost: " + cost);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Cos poszlo nie tak!");
            return false;
        }
        return true;
    }

    static boolean addProductToOrder(String client_id, String seller_name, String product_name, String country, int quantity, float price) {
//        try {
//            PreparedStatement pstmt = con.prepareStatement
//                    ("SELECT ");
//            pstmt.setString(1, sellerNickname);
//            pstmt.execute();
//        } catch (Exception e) {
//            System.out.println("Cos poszlo nie tak!");
//            return false;
//        }
        return true;
    }
}