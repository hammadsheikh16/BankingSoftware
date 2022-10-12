package backend;

import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

public class CustomerPage extends JDialog {
    private JPanel CustomerView;
    private JButton depositButton;
    private JButton withdrawButton;
    private JTextField AccountPasswordField;
    private JTextField AmountField;
    private JTextField Account_idField;

    public CustomerPage() {

        setContentPane(CustomerView);
        setTitle("Welcome to Customer Login!");
        pack();

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String AccountPassword = AccountPasswordField.getText().trim();
                double Amount = Double.parseDouble(AmountField.getText().trim());
                int Account_id = Integer.parseInt(Account_idField.getText().trim());

                bankAccount b1 = new bankAccount(Account_id, AccountPassword, Amount);
                try {
                    b1.deposit(AccountPassword, Amount, Account_id);
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }
            }


        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String AccountPassword = AccountPasswordField.getText().trim();
                double Amount = Double.parseDouble(AmountField.getText().trim());
                int Account_id = Integer.parseInt(Account_idField.getText().trim());

                bankAccount b1 = new bankAccount(Account_id, AccountPassword, Amount);
                try {
                    b1.withdraw(AccountPassword, Amount, Account_id);
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        CustomerView.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        System.out.println("Customer page deployed");
    }

}
