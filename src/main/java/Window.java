import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class Window extends JFrame implements ActionListener {

    private int screenIndex = 0;
    static JButton button = new JButton();
    static String description;
    static String seller;
    static String country;


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
    JSplitPane splitPane1 = new JSplitPane();

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
    JPanel SellerScreen = new JPanel();
    JPanel CustomerScreen = new JPanel();
    JPanel addProductScreen = new JPanel();



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
    JButton showOffersS = new JButton("Show Offers");
    JButton addProductS = new JButton("Add Product");
    JButton showProductS = new JButton("Show Products");
    JButton addProductButton = new JButton("Add Product");
    JButton showProductsFilterButton = new JButton("Apply");

    JButton customerButton1 = new JButton("cB1");
    JButton customerButton2 = new JButton("cB2");


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
    JLabel registerError = new JLabel("");

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
    JLabel loginError = new JLabel("");

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
    JLabel createAdminError = new JLabel("");

    /**
     * Ban Screen
     */

    JPanel banP = new JPanel();

    JLabel userToBan = new JLabel("Enter user nickname:");
    JTextField userToBanT = new JTextField();
    JButton banButton = new JButton("Ban User");
    JLabel banError = new JLabel("");

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

  /**
   * Customer add product Screen
   */

  JPanel addProductPanel = new JPanel();
  JPanel addNamePanel = new JPanel();
  JPanel addCountryPanel = new JPanel();
  JPanel addQuantityPanel = new JPanel();
  JPanel addPricePanel = new JPanel();

  JLabel addNameLabel = new JLabel("Enter Product Name");
  JLabel addCountryLabel = new JLabel("Enter Country");
  JLabel addQuantityLabel = new JLabel("Enter Quantity");
  JLabel addPriceLabel = new JLabel("Enter Price");

  JTextField addNameTextField = new JTextField();
  JTextField addCountryTextField = new JTextField();
  JTextField addQuantityTextField = new JTextField();
  JTextField addPriceTextField = new JTextField();


  private void Prepare() {
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
        usernameL.setMaximumSize(new Dimension(200, 50));
        loginP.add(loginL);
        loginL.setMaximumSize(new Dimension(200, 50));
        passwordP.add(passwordL);
        passwordL.setMaximumSize(new Dimension(200, 50));
        nameP.add(nameL);
        nameL.setMaximumSize(new Dimension(200, 50));
        lastnameP.add(lastnameL);
        lastnameL.setMaximumSize(new Dimension(200, 50));
        phoneP.add(phoneL);
        phoneL.setMaximumSize(new Dimension(200, 50));
        emailP.add(emailL);
        emailL.setMaximumSize(new Dimension(200, 50));
        typeP.add(typeL);
        typeL.setMaximumSize(new Dimension(200, 50));

        usernameP.add(usernameField);
        usernameField.setMaximumSize(new Dimension(600, 50));
        loginP.add(loginField);
        loginField.setMaximumSize(new Dimension(600, 50));
        passwordP.add(passwordField);
        passwordField.setMaximumSize(new Dimension(600, 50));
        nameP.add(nameField);
        nameField.setMaximumSize(new Dimension(600, 50));
        lastnameP.add(lastnameField);
        lastnameField.setMaximumSize(new Dimension(600, 50));
        phoneP.add(phoneField);
        phoneField.setMaximumSize(new Dimension(600, 50));
        emailP.add(emailField);
        emailField.setMaximumSize(new Dimension(600, 50));
        typeP.add(type);
        type.setMaximumSize(new Dimension(600, 50));

        registerScreen.add(registerNowButton);
        registerNowButton.setMaximumSize(new Dimension(150, 50));
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
        loginLL.setMaximumSize(new Dimension(200, 50));
        passwordPP.add(passwordLL);
        passwordLL.setMaximumSize(new Dimension(200, 50));

        loginPP.add(loginField1);
        loginField1.setMaximumSize(new Dimension(600, 50));
        passwordPP.add(passwordField1);
        passwordField1.setMaximumSize(new Dimension(600, 50));
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
        banOptionButton.setMaximumSize(new Dimension(200, 50));
        createAdminButton.setMaximumSize(new Dimension(200, 50));
        showUsers.setMaximumSize(new Dimension(200, 50));
        showPersonalData.setMaximumSize(new Dimension(200, 50));
        showProducts.setMaximumSize(new Dimension(200, 50));

        /**
         * ban Panel
         */
        banScreen.setLayout(new BoxLayout(banScreen, BoxLayout.Y_AXIS));
        banScreen.add(banP);
        banP.setLayout(new BoxLayout(banP, BoxLayout.X_AXIS));
        banP.add(userToBan);
        userToBan.setMaximumSize(new Dimension(200, 50));
        banP.add(userToBanT);
        userToBanT.setMaximumSize(new Dimension(200, 50));
        banScreen.add(banButton);
        banButton.setMaximumSize(new Dimension(150, 50));
        banScreen.add(banError);


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
        usernameLLL.setMaximumSize(new Dimension(200, 50));
        loginPPP.add(loginLLL);
        loginLLL.setMaximumSize(new Dimension(200, 50));
        passwordPPP.add(passwordLLL);
        passwordLLL.setMaximumSize(new Dimension(200, 50));

        usernamePPP.add(usernameField2);
        usernameField2.setMaximumSize(new Dimension(600, 50));
        loginPPP.add(loginField2);
        loginField2.setMaximumSize(new Dimension(600, 50));
        passwordPPP.add(passwordField2);
        passwordField2.setMaximumSize(new Dimension(600, 50));

        createAdminScreen.add(createAdminError);

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
    showProductsFilter.add(showProductsFilterButton);

    showProductsFilterButton.setMaximumSize(new Dimension(200, 50));

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

      /**
       * Seller screen
       */
      SellerScreen.setLayout(new BoxLayout(SellerScreen, BoxLayout.Y_AXIS));

      SellerScreen.add(showOffersS);
      SellerScreen.add(addProductS);
      SellerScreen.add(showProductS);
      showOffersS.setMaximumSize(new Dimension(200, 50));
      addProductS.setMaximumSize(new Dimension(200, 50));
      showProductS.setMaximumSize(new Dimension(200, 50));

      /**
       * Customer screen
       */
      CustomerScreen.setLayout(new BoxLayout(CustomerScreen, BoxLayout.Y_AXIS));

      CustomerScreen.add(customerButton1);
      CustomerScreen.add(customerButton2);
      customerButton1.setMaximumSize(new Dimension(200, 50));
      customerButton2.setMaximumSize(new Dimension(200, 50));

      /**
       * Seller add product Screen
       */

      addProductScreen.setLayout(new BoxLayout(addProductScreen, BoxLayout.Y_AXIS));
      addProductScreen.add(addProductPanel);
      addProductScreen.add(addProductButton);
      addProductButton.setMaximumSize(new Dimension(200, 50));

      addProductPanel.setLayout(new BoxLayout(addProductPanel, BoxLayout.X_AXIS));
      addProductPanel.add(addNamePanel);
      addProductPanel.add(addCountryPanel);
      addProductPanel.add(addQuantityPanel);
      addProductPanel.add(addPricePanel);
      addNamePanel.setLayout(new BoxLayout(addNamePanel, BoxLayout.Y_AXIS));
      addCountryPanel.setLayout(new BoxLayout(addCountryPanel, BoxLayout.Y_AXIS));
      addQuantityPanel.setLayout(new BoxLayout(addQuantityPanel, BoxLayout.Y_AXIS));
      addPricePanel.setLayout(new BoxLayout(addPricePanel, BoxLayout.Y_AXIS));
      addNamePanel.add(addNameLabel);
      addNameLabel.setMaximumSize(new Dimension(200,30));
      addNamePanel.add(addNameTextField);
      addNameTextField.setMaximumSize(new Dimension(200,50));
      addCountryPanel.add(addCountryLabel);
      addCountryLabel.setMaximumSize(new Dimension(200,30));
      addCountryPanel.add(addCountryTextField);
      addCountryTextField.setMaximumSize(new Dimension(200,50));
      addQuantityPanel.add(addQuantityLabel);
      addQuantityLabel.setMaximumSize(new Dimension(200,30));
      addQuantityPanel.add(addQuantityTextField);
      addQuantityTextField.setMaximumSize(new Dimension(200,50));
      addPricePanel.add(addPriceLabel);
      addPriceLabel.setMaximumSize(new Dimension(200,30));
      addPricePanel.add(addPriceTextField);
      addPriceTextField.setMaximumSize(new Dimension(200,50));







    splitPane1.setBottomComponent(loginScreen);
    splitPane1.setTopComponent(AdminScreen);

  }


    private void Surface() {
        Prepare();

        /**
         * Login Screen - User
         */
        loginButton.addActionListener(e -> {
            splitPane1.setBottomComponent(loginScreen);
            setBounds(100, 0, 1279, 960);
            setBounds(100, 0, 1280, 960);
        });

        registerButton.addActionListener(e -> {
            splitPane1.setBottomComponent(registerScreen);
        });

        logInButton.addActionListener(e -> {
            String login = loginField1.getText();
            String pass = String.valueOf(passwordField1.getPassword());
            try {
                String typeOfUser = App.login(login, pass);
                switch (typeOfUser) {
                  case "admin":
                    splitPane1.setTopComponent(AdminScreen);
                    splitPane1.setBottomComponent(banScreen);
                    break;
                  case "seller":
                    splitPane1.setTopComponent(SellerScreen);
                    splitPane1.setBottomComponent(addProductScreen);
                    break;
                  case "customer":
                    splitPane1.setTopComponent(CustomerScreen);
//                    splitPane1.setBottomComponent(customerButton1);
                    break;
                }

            } catch (Exception ex) {
                loginError.setText("Wrong login or password");
            }
        });

        registerNowButton.addActionListener(e -> {
            try {
                String username = usernameField.getText();
                String login = loginField.getText();
                String pass = String.valueOf(passwordField.getPassword());
                String typeS = type.getSelectedItem();
                String name = nameField.getText();
                String lastname = lastnameField.getText();
                int phone = Integer.parseInt(phoneField.getText());
                String email = emailField.getText();
                if (!App.register(username, login, pass, typeS, name, lastname, phone, email)) {
                    registerError.setText("Taki uzytkownik istnieje lub za krotkie teksty!");
                }
            } catch (NumberFormatException exx) {
                registerError.setText("Numer telefonu nie pasuje!");
            } catch (Exception ex) {
                registerError.setText("Taki uzytkownik istnieje!");
            }
        });

        /**
         * Admin buttons
         */

        createAdminButton.addActionListener(e -> {
            splitPane1.setBottomComponent(createAdminScreen);
        });

        addAdmin.addActionListener(e -> {
            String nick = usernameField2.getText();
            String login = loginField2.getText();
            String pass = String.valueOf(passwordField2.getPassword());
            if(App.addAdmin(nick,login,pass)){
                createAdminError.setText("Admin Added");
            }
            else{
                createAdminError.setText("Admin not added");
            }
        });

        banOptionButton.addActionListener(e -> {
            splitPane1.setBottomComponent(banScreen);
        });

        banButton.addActionListener(e -> {
            String userBan = userToBanT.getText();
            if(!App.strikeSeller(userBan)){
                banError.setText("Zla nazwa");
            }
        });

        showProducts.addActionListener(e -> {
            splitPane1.setBottomComponent(showUsersPA);
            ArrayList<Product> listaProduktow = App.showProducts("", "", 0, 0, 0, "");
            String[] columns = {
                    "Description", "Seller", "Country", "Quantity", "Price", "Add product"
            };

            Object[][] stringArray = new Object[listaProduktow.size()][6];
            int i=0;
            for (Product product : listaProduktow) {
                stringArray[i][0]=product.description;
                stringArray[i][1]=product.seller;
                stringArray[i][2]=product.country;
                stringArray[i][3]=String.valueOf(product.quantity);
                stringArray[i][4]=String.valueOf(product.pricePerUnit);
                i++;
            }

            JTable j = new JTable();
            JScrollPane sp = new JScrollPane(j);

            DefaultTableModel tableModel = new DefaultTableModel(stringArray, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 5;
                }
            };
            j.setModel(tableModel);
            j.getColumn("Add product").setCellRenderer(new ButtonRenderer());
            j.getColumn("Add product").setCellEditor(new ButtonEditor(new JCheckBox()));
            j.setBounds(30, 40, 200, 10);
            showUsersPA.removeAll();
            showUsersPA.add(showProductsFilter);
            showUsersPA.add(sp);
            for (ActionListener al:button.getActionListeners()) {
                button.removeActionListener(al);
            }
            button.addActionListener(
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent event)
                        {
                            description = String.valueOf(j.getValueAt(j.getEditingRow(),0));
                            seller = String.valueOf(j.getValueAt(j.getEditingRow(),1));
                            country = String.valueOf(j.getValueAt(j.getEditingRow(),2));
                            AddProductWindow apw = new AddProductWindow();
                            //App.addToBasket(new Product(description,seller,country,quantity,price));
//                            JOptionPane.showMessageDialog(null,"Do you want to modify "
//                                    + j.getValueAt(j.getEditingRow(),1) +" line?");
                        }
                    }
            );
        });

        showPersonalData.addActionListener(e -> {
            //App.addProductsToOrder();
        });

      showUsers.addActionListener(e -> {

      });

      addProductS.addActionListener(e -> {
        splitPane1.setBottomComponent(addProductScreen);
      });
    }

    public static void addProductToBasket(int quantity, float price){
        App.addToBasket(new Product(description,seller,country,quantity,price));
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
    class ButtonRenderer extends JButton implements TableCellRenderer
    {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    class ButtonEditor extends DefaultCellEditor
    {
        private String label;

        public ButtonEditor(JCheckBox checkBox)
        {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column)
        {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue()
        {
            return new String(label);
        }
    }
}
