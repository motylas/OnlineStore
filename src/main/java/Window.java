import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Window extends JFrame implements ActionListener {

  private int screenIndex = 0;


  /**
   * Main Panels
   */
  JPanel topPanel = new JPanel();
  JPanel bottomPanel = new JPanel();


  /**
   * Start Screen
   */
  JButton loginButton = new JButton("Login");
  JButton registerButton = new JButton("Register");
  JSplitPane splitPane1 = new  JSplitPane();

  /**
   * Created Panels/Screens
   */
  JPanel StartScreen = new JPanel();
  JPanel loginScreen = new JPanel();
  JPanel registerScreen = new JPanel();
  JPanel AdminScreen = new JPanel();
  JPanel banScreen = new JPanel();
  JPanel createAdminScreen = new JPanel();
  JPanel showProductsPA = new JPanel();
  JPanel showUsersPA = new JPanel();
  JPanel showPersonalDataPA = new JPanel();


  /**
   * Created Buttons
   */
  JButton registerNowButton = new JButton("Register Now");
  JButton logInButton = new JButton("Log In");
  JButton banOptionButton = new JButton("Ban User");
  JButton createAdminButton = new JButton("Add New Admin");
  JButton showUsers = new JButton("Show Users");
  JButton showPersonalData = new JButton("Show Personal data");
  JButton showProducts = new JButton("Show Products");

  /**
   * Register Screen
   */
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
  JLabel registerError = new JLabel("User with this username already exist.");

  JPanel usernameP = new JPanel();
  JPanel loginP = new JPanel();
  JPanel passwordP = new JPanel();
  JPanel nameP = new JPanel();
  JPanel lastnameP = new JPanel();
  JPanel phoneP = new JPanel();
  JPanel emailP = new JPanel();
  JPanel typeP = new JPanel();

  /**
   * Login Screen
   */

  JLabel loginLL = new JLabel("Login");
  JLabel passwordLL = new JLabel("Password");
  JLabel loginError = new JLabel("User with this login doesn't exist.");

  JPanel loginPP = new JPanel();
  JPanel passwordPP = new JPanel();

  JTextField loginField1 = new JTextField();
  JPasswordField passwordField1 = new JPasswordField();

  /**
   * Created Admin Screen
   */

  JPanel usernamePPP = new JPanel();
  JPanel loginPPP = new JPanel();
  JPanel passwordPPP = new JPanel();

  JLabel usernameLLL = new JLabel("Nickname");
  JLabel loginLLL = new JLabel("Login");
  JLabel passwordLLL = new JLabel("Password");

  JTextField usernameField2 = new JTextField();
  JTextField loginField2 = new JTextField();
  JPasswordField passwordField2 = new JPasswordField();

  JButton addAdmin = new JButton("Create Admin");

  /**
   * Ban Screen
   */

  JPanel banP = new JPanel();

  JLabel userToBan = new JLabel("Enter user nickname:");
  JTextField userToBanT = new JTextField();
  JButton banButton = new JButton("Ban User");

  /**
   * Show Products Screen
   */

  JPanel showProductsFilter = new JPanel();
  JPanel selleridFilterPanel = new JPanel();
  JPanel nameFilterPanel = new JPanel();
  JPanel countryFilterPanel = new JPanel();
  JPanel quantityFilterPanel = new JPanel();
  JPanel minpriceFilterPanel = new JPanel();
  JPanel maxpriceFilterPanel = new JPanel();

  JLabel sellerifFilterLabel = new JLabel("Seller Nickname");
  JLabel nameFilterLabel = new JLabel("Product Name");
  JLabel countryFilterLabel = new JLabel("Country");
  JLabel quantityFilterLabel = new JLabel("Min. quantity");
  JLabel minpriceFilterLabel = new JLabel("Min. Price");
  JLabel maxpriceFilterLabel = new JLabel("Max. Price");

  JTextField sellerifFilterText = new JTextField();
  JTextField nameFilterText = new JTextField();
  JTextField countryFilterText = new JTextField();
  JTextField quantityFilterText = new JTextField();
  JTextField minpriceFilterText = new JTextField();
  JTextField maxpriceFilterText = new JTextField();




  private void Prepare() {
//    bottomPanel.setBackground(Color.GREEN);
//    topPanel.setBackground(Color.RED);
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
    typeP.add(type);
    type.setMaximumSize(new Dimension(600,50));

    registerScreen.add(registerNowButton);
    registerNowButton.setMaximumSize(new Dimension(150,50));
    registerScreen.add(registerError);

    /**
     * Login screen
     */

    loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));
    loginScreen.add(loginPP);
    loginScreen.add(passwordPP);
    loginScreen.add(logInButton);

    loginPP.setLayout(new BoxLayout(loginPP, BoxLayout.X_AXIS));
    passwordPP.setLayout(new BoxLayout(passwordPP, BoxLayout.X_AXIS));

    loginPP.add(loginLL);
    loginLL.setMaximumSize(new Dimension(200,50));
    passwordPP.add(passwordLL);
    passwordLL.setMaximumSize(new Dimension(200,50));

    loginPP.add(loginField1);
    loginField1.setMaximumSize(new Dimension(600,50));
    passwordPP.add(passwordField1);
    passwordField1.setMaximumSize(new Dimension(600,50));
    loginScreen.add(loginError);


    /**
     * Admin screen
     */
    AdminScreen.setLayout(new BoxLayout(AdminScreen, BoxLayout.Y_AXIS));

    AdminScreen.add(banOptionButton);
    AdminScreen.add(createAdminButton);
    AdminScreen.add(showUsers);
    AdminScreen.add(showPersonalData);
    AdminScreen.add(showProducts);
    banOptionButton.setMaximumSize(new Dimension(200,50));
    createAdminButton.setMaximumSize(new Dimension(200,50));
    showUsers.setMaximumSize(new Dimension(200,50));
    showPersonalData.setMaximumSize(new Dimension(200,50));
    showProducts.setMaximumSize(new Dimension(200,50));

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

    /**
     * Show Users PA Screen
     */
    showUsersPA.setLayout(new BoxLayout(showUsersPA, BoxLayout.Y_AXIS));



    /**
     * Show Products Screen
     */
    showProductsFilter.setLayout(new BoxLayout(showProductsFilter, BoxLayout.X_AXIS));
    showProductsFilter.add(selleridFilterPanel);
    showProductsFilter.add(nameFilterPanel);
    showProductsFilter.add(countryFilterPanel);
    showProductsFilter.add(quantityFilterPanel);
    showProductsFilter.add(minpriceFilterPanel);
    showProductsFilter.add(maxpriceFilterPanel);


    selleridFilterPanel.setLayout(new BoxLayout(selleridFilterPanel, BoxLayout.Y_AXIS));
    nameFilterPanel.setLayout(new BoxLayout(nameFilterPanel, BoxLayout.Y_AXIS));
    countryFilterPanel.setLayout(new BoxLayout(countryFilterPanel, BoxLayout.Y_AXIS));
    quantityFilterPanel.setLayout(new BoxLayout(quantityFilterPanel, BoxLayout.Y_AXIS));
    minpriceFilterPanel.setLayout(new BoxLayout(minpriceFilterPanel, BoxLayout.Y_AXIS));
    maxpriceFilterPanel.setLayout(new BoxLayout(maxpriceFilterPanel, BoxLayout.Y_AXIS));

    selleridFilterPanel.add(sellerifFilterLabel);
    sellerifFilterLabel.setMaximumSize(new Dimension(200,30));
    selleridFilterPanel.add(sellerifFilterText);
    sellerifFilterText.setMaximumSize(new Dimension(200,50));
    nameFilterPanel.add(nameFilterLabel);
    nameFilterLabel.setMaximumSize(new Dimension(200,30));
    nameFilterPanel.add(nameFilterText);
    nameFilterText.setMaximumSize(new Dimension(200,50));
    countryFilterPanel.add(countryFilterLabel);
    countryFilterLabel.setMaximumSize(new Dimension(200,30));
    countryFilterPanel.add(countryFilterText);
    countryFilterText.setMaximumSize(new Dimension(200,50));
    quantityFilterPanel.add(quantityFilterLabel);
    quantityFilterLabel.setMaximumSize(new Dimension(200,30));
    quantityFilterPanel.add(quantityFilterText);
    quantityFilterText.setMaximumSize(new Dimension(200,50));
    minpriceFilterPanel.add(minpriceFilterLabel);
    minpriceFilterLabel.setMaximumSize(new Dimension(200,30));
    minpriceFilterPanel.add(minpriceFilterText);
    minpriceFilterText.setMaximumSize(new Dimension(200,50));
    maxpriceFilterPanel.add(maxpriceFilterLabel);
    maxpriceFilterLabel.setMaximumSize(new Dimension(200,30));
    maxpriceFilterPanel.add(maxpriceFilterText);
    maxpriceFilterText.setMaximumSize(new Dimension(200,50));



    splitPane1.setBottomComponent(loginScreen);
    splitPane1.setTopComponent(StartScreen);



  }


  private void Surface() {
    Prepare();

    loginButton.addActionListener(e -> {
      splitPane1.setBottomComponent(loginScreen);
      setBounds(100, 0, 1279, 960);
      setBounds(100, 0, 1280, 960);
    });

    registerButton.addActionListener(e -> {
      splitPane1.setBottomComponent(registerScreen);
    });

    logInButton.addActionListener(e ->{
      String login = loginField1.getText();
      String pass = String.valueOf(passwordField1.getPassword());
      try {
        App.login(login,pass);
        splitPane1.setTopComponent(AdminScreen);
      } catch (Exception ex) {
        loginError.setText("Wrong login or password");
      }
    });

    registerNowButton.addActionListener(e -> {
      try{String username = usernameField.getText();
      String login = loginField.getText();
      String pass = String.valueOf(passwordField.getPassword());
      String typeS = type.getSelectedItem();
      String name = nameField.getText();
      String lastname = lastnameField.getText();
      int phone = Integer.parseInt(phoneField.getText());
      String email = emailField.getText();
      if (!App.register(username,login,pass,typeS,name,lastname,phone,email)){
        registerError.setText("Taki uzytkownik istnieje lub za krotkie teksty!");
      }
        } catch (NumberFormatException exx){
        registerError.setText("Numer telefonu nie pasuje!");
      }
      catch (Exception ex) {
           registerError.setText("Taki uzytkownik istnieje!");
        }
    });

    createAdminButton.addActionListener(e -> {
      splitPane1.setBottomComponent(createAdminScreen);
    });

    banOptionButton.addActionListener(e -> {
      splitPane1.setBottomComponent(banScreen);
    });

    showProducts.addActionListener(e ->{
      splitPane1.setBottomComponent(showUsersPA);
      showUsersPA.setLayout(new BoxLayout(showUsersPA, BoxLayout.Y_AXIS));
      ArrayList<ArrayList<String>> listaProduktow = App.showProducts("","",0,0,0,"");
      ArrayList<String> columnNames = listaProduktow.remove(0);



      String[][] stringArray = listaProduktow.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

      String[] columns = columnNames.toArray(String[]::new);
      JTable j = new JTable(stringArray, columns);
      JScrollPane sp = new JScrollPane(j);

      DefaultTableModel tableModel = new DefaultTableModel(stringArray,columns) {

        @Override
        public boolean isCellEditable(int row, int column) {
          //all cells false
          return false;
       }
      };
     j.setModel(tableModel);
     j.setBounds(30, 40, 200, 10);
     showUsersPA.removeAll();
     showUsersPA.add(showProductsFilter);
     showUsersPA.add(sp);
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

    Surface();
//    add(this.surface);
    setBounds(100, 0, 1280, 960);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}