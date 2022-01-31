import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);
    static DBConnection db = new DBConnection();

    static int user_id;

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

    public static void register(String nick, String login, String password, String type, String name, String lastname, int phone_number, String email) throws Exception {
        System.out.println(db.register(nick,login,password,type,name,lastname,phone_number,email));
    }

    public static void login(String login, String password) throws Exception {
        user_id = db.login(login,password);
        if (user_id == -1){
            System.out.println("ERROR");
        }
    }

    private static void addProduct(){
        System.out.print("PODAJ NAZWE: ");
        String name = scanner.nextLine();
        System.out.print("PODAJ KRAJ POCHODZENIA(PO ANG): ");
        String country = scanner.nextLine();
        System.out.print("PODAJ CENE ZA SZTUKE: ");
        float price = 0;
        try{
            price = Float.parseFloat(scanner.nextLine());
        } catch (Exception e){
            System.out.println("wrong input!");
            return;
        }
        System.out.print("PODAJ ILOSC NA MAGAZYNIE: ");
        int quantity = 0;
        try{
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("wrong input");
            return;
        }
        db.addProduct(user_id, name, country, quantity, price);
    }

    private static void strikeSeller(){
        System.out.print("PODAJ NICK: ");
        String nick = scanner.nextLine();
        db.strikeSeller(nick);
    }
}