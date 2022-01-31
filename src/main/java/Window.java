import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.*;


public class Window extends JFrame implements ActionListener {
//  private final Menu menu3;
//
//  private final MenuItem i7;
  private int screenIndex = 0;

  private MenuBar myMenu;

  private JPanel surface;

  JLabel label1 = new JLabel("Twoj kolor");

  JLabel label2 = new JLabel("Aktualny gracz");

  JPanel loginPanel = new JPanel();

  JPanel registerPanel = new JPanel();
  JPanel topPanel = new JPanel();
  JPanel bottomPanel = new JPanel();

  JButton loginButton = new JButton("Login");

  JButton registerButton = new JButton("Register");

  JSplitPane splitPane1 = new  JSplitPane();

  JPanel StartScreen = new JPanel();
  JPanel loginScreen = new JPanel();
  JPanel registerScreen = new JPanel();
  JPanel AdminScreen = new JPanel();
  JPanel banScreen = new JPanel();
  JPanel createAdminScreen = new JPanel();

  JButton registerNowButton = new JButton("Register Now");
  JButton logInButton = new JButton("Log In");
  JButton banOptionButton = new JButton("Ban User");
  JButton createAdminButton = new JButton("Add New Admin");

  JTextField usernameField = new JTextField();
  JTextField loginField = new JTextField();
  JPasswordField passwordField = new JPasswordField();
  JTextField nameField = new JTextField();
  JTextField lastnameField = new JTextField();
  JTextField phoneField = new JTextField();
  JTextField emailField = new JTextField();
  Choice type = new Choice();

  JLabel usernameL = new JLabel("Username");
  JLabel loginL = new JLabel("Login");
  JLabel passwordL = new JLabel("Password");
  JLabel nameL = new JLabel("Name");
  JLabel lastnameL = new JLabel("Lastname");
  JLabel phoneL = new JLabel("Phone");
  JLabel emailL = new JLabel("Email");
  JLabel typeL = new JLabel("Type");

  JLabel usernameLL = new JLabel("Username");
  JLabel loginLL = new JLabel("Login");
  JLabel passwordLL = new JLabel("Password");

  JPanel usernameP = new JPanel();
  JPanel loginP = new JPanel();
  JPanel passwordP = new JPanel();
  JPanel nameP = new JPanel();
  JPanel lastnameP = new JPanel();
  JPanel phoneP = new JPanel();
  JPanel emailP = new JPanel();
  JPanel typeP = new JPanel();

  JPanel usernamePP = new JPanel();
  JPanel loginPP = new JPanel();
  JPanel passwordPP = new JPanel();

  JPanel usernamePPP = new JPanel();
  JPanel loginPPP = new JPanel();
  JPanel passwordPPP = new JPanel();

  JPanel banP = new JPanel();

  JTextField usernameField1 = new JTextField();
  JTextField loginField1 = new JTextField();
  JPasswordField passwordField1 = new JPasswordField();

  JLabel userToBan = new JLabel("Enter user nickname:");
  JTextField userToBanT = new JTextField();
  JButton banButton = new JButton("Ban User");


  JLabel usernameLLL = new JLabel("Nickname");
  JLabel loginLLL = new JLabel("Login");
  JLabel passwordLLL = new JLabel("Password");

  JTextField usernameField2 = new JTextField();
  JTextField loginField2 = new JTextField();
  JPasswordField passwordField2 = new JPasswordField();

  JButton addAdmin = new JButton("Create Admin");












  private void Prepare() {
    bottomPanel.setBackground(Color.GREEN);
    topPanel.setBackground(Color.RED);
    type.add("customer");
    type.add("seller");


    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane1);

    splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
    splitPane1.setDividerLocation(400);
    splitPane1.setTopComponent(topPanel);
    splitPane1.setBottomComponent(bottomPanel);


    /**
     * Start screen
     */
    StartScreen.add(loginButton);
    StartScreen.add(registerButton);

    /**
     * Register screen
     */
    registerScreen.setLayout(new BoxLayout(registerScreen, BoxLayout.Y_AXIS));
    registerScreen.add(usernameP);
    registerScreen.add(loginP);
    registerScreen.add(passwordP);
    registerScreen.add(nameP);
    registerScreen.add(lastnameP);
    registerScreen.add(phoneP);
    registerScreen.add(emailP);
    registerScreen.add(typeP);


    usernameP.setLayout(new BoxLayout(usernameP, BoxLayout.X_AXIS));
    loginP.setLayout(new BoxLayout(loginP, BoxLayout.X_AXIS));
    passwordP.setLayout(new BoxLayout(passwordP, BoxLayout.X_AXIS));
    nameP.setLayout(new BoxLayout(nameP, BoxLayout.X_AXIS));
    lastnameP.setLayout(new BoxLayout(lastnameP, BoxLayout.X_AXIS));
    phoneP.setLayout(new BoxLayout(phoneP, BoxLayout.X_AXIS));
    emailP.setLayout(new BoxLayout(emailP, BoxLayout.X_AXIS));
    typeP.setLayout(new BoxLayout(typeP, BoxLayout.X_AXIS));

    usernameP.add(usernameL);
    usernameL.setMaximumSize(new Dimension(200,50));
    loginP.add(loginL);
    loginL.setMaximumSize(new Dimension(200,50));
    passwordP.add(passwordL);
    passwordL.setMaximumSize(new Dimension(200,50));
    nameP.add(nameL);
    nameL.setMaximumSize(new Dimension(200,50));
    lastnameP.add(lastnameL);
    lastnameL.setMaximumSize(new Dimension(200,50));
    phoneP.add(phoneL);
    phoneL.setMaximumSize(new Dimension(200,50));
    emailP.add(emailL);
    emailL.setMaximumSize(new Dimension(200,50));
    typeP.add(typeL);
    typeL.setMaximumSize(new Dimension(200,50));

    usernameP.add(usernameField);
    usernameField.setMaximumSize(new Dimension(600,50));
    loginP.add(loginField);
    loginField.setMaximumSize(new Dimension(600,50));
    passwordP.add(passwordField);
    passwordField.setMaximumSize(new Dimension(600,50));
    nameP.add(nameField);
    nameField.setMaximumSize(new Dimension(600,50));
    lastnameP.add(lastnameField);
    lastnameField.setMaximumSize(new Dimension(600,50));
    phoneP.add(phoneField);
    phoneField.setMaximumSize(new Dimension(600,50));
    emailP.add(emailField);
    emailField.setMaximumSize(new Dimension(600,50));
//    typeP.add(typeField);
//    typeField.setMaximumSize(new Dimension(600,50));
    typeP.add(type);
    type.setMaximumSize(new Dimension(600,50));

    registerScreen.add(registerNowButton);
    registerNowButton.setMaximumSize(new Dimension(150,50));

    /**
     * Login screen
     */

    loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));
    loginScreen.add(usernamePP);
    loginScreen.add(loginPP);
    loginScreen.add(passwordPP);
    loginScreen.add(logInButton);

    usernamePP.setLayout(new BoxLayout(usernamePP, BoxLayout.X_AXIS));
    loginPP.setLayout(new BoxLayout(loginPP, BoxLayout.X_AXIS));
    passwordPP.setLayout(new BoxLayout(passwordPP, BoxLayout.X_AXIS));

    usernamePP.add(usernameLL);
    usernameLL.setMaximumSize(new Dimension(200,50));
    loginPP.add(loginLL);
    loginLL.setMaximumSize(new Dimension(200,50));
    passwordPP.add(passwordLL);
    passwordLL.setMaximumSize(new Dimension(200,50));

    usernamePP.add(usernameField1);
    usernameField1.setMaximumSize(new Dimension(600,50));
    loginPP.add(loginField1);
    loginField1.setMaximumSize(new Dimension(600,50));
    passwordPP.add(passwordField1);
    passwordField1.setMaximumSize(new Dimension(600,50));


    /**
     * Admin screen
     */
//    banOptionButton.setBounds(60,100,100,50);
//    createAdminButton.setBounds(60,200,100,50);
    AdminScreen.setLayout(new BoxLayout(AdminScreen, BoxLayout.Y_AXIS));

    AdminScreen.add(banOptionButton);
    AdminScreen.add(createAdminButton);
    banOptionButton.setMaximumSize(new Dimension(200,50));
    createAdminButton.setMaximumSize(new Dimension(200,50));

    /**
     * ban Panel
     */
    banScreen.setLayout(new BoxLayout(banScreen, BoxLayout.Y_AXIS));
    banScreen.add(banP);
    banP.setLayout(new BoxLayout(banP, BoxLayout.X_AXIS));
    banP.add(userToBan);
    userToBan.setMaximumSize(new Dimension(200,50));
    banP.add(userToBanT);
    userToBanT.setMaximumSize(new Dimension(200,50));
    banScreen.add(banButton);
    banButton.setMaximumSize(new Dimension(150,50));

    /**
     * create Admin Panel
     */
    createAdminScreen.setLayout(new BoxLayout(createAdminScreen, BoxLayout.Y_AXIS));
    createAdminScreen.add(usernamePPP);
    createAdminScreen.add(loginPPP);
    createAdminScreen.add(passwordPPP);
    createAdminScreen.add(addAdmin);

    usernamePPP.setLayout(new BoxLayout(usernamePPP, BoxLayout.X_AXIS));
    loginPPP.setLayout(new BoxLayout(loginPPP, BoxLayout.X_AXIS));
    passwordPPP.setLayout(new BoxLayout(passwordPPP, BoxLayout.X_AXIS));

    usernamePPP.add(usernameLLL);
    usernameLLL.setMaximumSize(new Dimension(200,50));
    loginPPP.add(loginLLL);
    loginLLL.setMaximumSize(new Dimension(200,50));
    passwordPPP.add(passwordLLL);
    passwordLLL.setMaximumSize(new Dimension(200,50));

    usernamePPP.add(usernameField2);
    usernameField2.setMaximumSize(new Dimension(600,50));
    loginPPP.add(loginField2);
    loginField2.setMaximumSize(new Dimension(600,50));
    passwordPPP.add(passwordField2);
    passwordField2.setMaximumSize(new Dimension(600,50));




    splitPane1.setBottomComponent(createAdminScreen);
    splitPane1.setTopComponent(AdminScreen);



  }

  private void screens(){
//    remove(surface);
    if(screenIndex == 0){
      splitPane1.setBottomComponent(loginScreen);
      System.out.println("1");
    }
    else if(screenIndex == 1){
      splitPane1.setBottomComponent(registerScreen);
      System.out.println("2");
    }
  }

  private void Surface() {
    Prepare();

    loginButton.addActionListener(e -> {
      screenIndex = 0;
      System.out.println("Hi");
      screens();
      setBounds(100, 0, 1279, 960);
      setBounds(100, 0, 1280, 960);
    });

    registerButton.addActionListener(e -> {
      screenIndex = 1;
      System.out.println("Hi");
      screens();
    });

    logInButton.addActionListener(e ->{
      String login = loginField1.getText();
      String pass = String.valueOf(passwordField1.getPassword());
      try {
        App.login(login,pass);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
    registerNowButton.addActionListener(e -> {
      String username = usernameField.getText();
      String login = loginField.getText();
      String pass = String.valueOf(passwordField.getPassword());
      String typeS = type.getSelectedItem();
      String name = nameField.getText();
      String lastname = lastnameField.getText();
      int phone = Integer.parseInt(phoneField.getText());
      String email = emailField.getText();
        try {
            App.register(username,login,pass,typeS,name,lastname,phone,email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    });

  }

  public static void main(String[] var0) {
    Window var1 = new Window();
    var1.setBounds(100, 0, 1280, 960);
    var1.setVisible(true);
  }

  public Window() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Online-shop");
    myMenu = new MenuBar();
//    setLayout(new GridLayout(1, 2));
    setMenuBar(this.myMenu);
    Surface();
//    add(this.surface);
    setBounds(100, 0, 1280, 960);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}