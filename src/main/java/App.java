import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);
    static int user_id;
    public static void main(String[] args) throws Exception {
        DBConnection.connection();
        EncryptionDecryptionAES.prepareHash();
//        DBConnection.showProducts("     ","       ",0,0,0,"P");
//        DBConnection.addProduct(2,"frytkownica","Poland",1,59);
//        DBConnection.addProduct(2,"mandarynki","Poland",4,7);
//        DBConnection.addProduct(3,"frytki","Poland",6,7);
//        DBConnection.addProduct(2,"frytki","China",2,11);
        System.out.println("1. LOGIN");
        System.out.println("2. REGISTER");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> login();
            case 2 -> register();
        }
//        addProduct();
    }

    private static void register() throws Exception {
        System.out.print("PODAJ nick: ");
        String nick = scanner.nextLine();
        System.out.print("PODAJ LOGIN: ");
        String login = scanner.nextLine();
        System.out.print("PODAJ HASLO: ");
        String password = scanner.nextLine();
        System.out.print("PODAJ type: ");
        String type = scanner.nextLine();
        System.out.print("PODAJ name: ");
        String name = scanner.nextLine();
        System.out.print("PODAJ lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("PODAJ phone_number: ");
        int phone_number;
        try{
            phone_number = Integer.parseInt(scanner.nextLine());
        } catch(Exception e){
            System.out.println("wrong number");
            return;
        }
        System.out.print("PODAJ email: ");
        String email = scanner.nextLine();
        System.out.println(DBConnection.register(nick,login,password,type,name,lastname,phone_number,email));
    }

    private static void login() throws Exception {
        System.out.print("PODAJ LOGIN: ");
        String login = scanner.nextLine();
        System.out.print("PODAJ HASLO: ");
        String password = scanner.nextLine();
        user_id = DBConnection.login(login,password);
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
        DBConnection.addProduct(user_id, name, country, quantity, price);
    }

    private static void strikeSeller(){
        System.out.print("PODAJ NICK: ");
        String nick = scanner.nextLine();
        DBConnection.strikeSeller(nick);
    }
}