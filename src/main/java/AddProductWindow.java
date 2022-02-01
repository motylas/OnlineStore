import javax.swing.*;
import java.awt.*;

public class AddProductWindow extends JFrame {
    JLabel quantity = new JLabel("Quantity:");
    JLabel price = new JLabel("Your price");
    JTextField clientQuantity = new JTextField();
    JTextField clientPrice = new JTextField();
    JButton button = new JButton("Add product to basket");
    JLabel error = new JLabel("");

    public AddProductWindow() {
        JPanel panel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add");
        setBounds(400, 200, 480, 360);
        panel.setLayout(new GridLayout(3, 2));
        add(panel);
        panel.add(quantity);
        quantity.setHorizontalAlignment(JLabel.CENTER);
        panel.add(clientQuantity);
        panel.add(price);
        price.setHorizontalAlignment(JLabel.CENTER);
        panel.add(clientPrice);
        panel.add(button);
        panel.add(error);
        setVisible(true);
        button.addActionListener(e -> {
            try {
                int qtty = Integer.parseInt(clientQuantity.getText());
                float cost = Float.parseFloat(clientPrice.getText());
                Window.addProductToBasket(qtty,cost);
                this.setVisible(false);
            } catch (Exception x) {
                error.setText("Bledne quantity lub price!");
            }
        });
    }

    public static void main(String[] args) {
        AddProductWindow w = new AddProductWindow();
    }
}
