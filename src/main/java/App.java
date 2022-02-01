import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);
    static DBConnection db = new DBConnection();

    static int user_id;
    static ArrayList<Product> basket = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        db.connection();
        EncryptionDecryptionAES.prepareHash();
        Window window = new Window();
//        db.showProducts("f","       ",0,0,2,"P");
//        db.addProduct(2,"frytkownica","Poland",1,59);
//        db.addProduct(2,"mandarynki","Poland",4,7);
//        db.addProduct(3,"frytki","Poland",6,7);
//        db.addProduct(2,"frytki","China",2,11);
//        System.out.println("1. LOGIN");
//        System.out.println("2. REGISTER");
//        int choice = Integer.parseInt(scanner.nextLine());
//        switch (choice) {
//            case 1 -> login();
//            case 2 -> register();
//        }
//        addProduct();
    }

    public static boolean register(String nick, String login, String password, String type, String name, String lastname, int phone_number, String email) throws Exception {
        return db.register(nick,login,password,type,name,lastname,phone_number,email);
    }

    public static String login(String login, String password) throws Exception {
        String[] values = db.login(login,password).split(";");
        user_id = Integer.parseInt(values[0]);
        if (user_id == -1){
            throw new Exception("login exception");
        }
        return values[1];
    }

    public static void addProduct(String name, String country, int quantity, float price){
        db.addProduct(user_id, name, country, quantity, price);
    }

    public static boolean strikeSeller(String nick){
        return db.strikeSeller(nick);
    }

    public static ArrayList<Product> showProducts(String productName, String sellerNick, float maxPrice, float minPrice, int minQuantity, String country){
        return db.showProducts(productName, sellerNick, maxPrice, minPrice, minQuantity, country);
    }

    public static void addProductsToOrder(){
        db.addProductsToOrder(basket,user_id);
        basket = null;
    }

    public static void addToBasket(Product product){
        basket.add(product);
    }

    public static boolean addAdmin(String nick, String login, String pass){
        return db.addAdmin(nick,login,pass);
    }

}