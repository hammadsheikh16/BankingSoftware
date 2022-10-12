package backend;

import javax.swing.*;

import java.awt.event.*;
import java.security.NoSuchAlgorithmException;


public class EmployeePageLogin extends JDialog {
    private JTextField Account_ID;
    private JTextField Account_Username;
    private JTextField Account_Password;
    private JButton loginButton;
    private JPanel Employee_Login_Page;

    public EmployeePageLogin() {

        setContentPane(Employee_Login_Page);
        setTitle("Employee Login Page");

        setVisible(true);
        pack();
        loginButton.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              int account_ID = Integer.parseInt(Account_ID.getText().trim());
                                              String account_username = Account_Username.getText().trim();
                                              String account_password = Account_Password.getText().trim();
                                              System.out.println("account_id: " + account_ID + "  account_username: " + account_username +
                                                      "  account_password: " + account_password);

                                              try {
                                                  if (msql.checkLogin(account_ID, account_username, account_password)) {
                                                  } else {
                                                      JOptionPane.showMessageDialog(null, "Employee Login Status: Failed");
                                                  }
                                              } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                                                  noSuchAlgorithmException.printStackTrace();
                                              }

                                          }
                                      }
        );
    }

    public static void main(String[] args) {
        EmployeePageLogin epl = new EmployeePageLogin();
        epl.setTitle("Employee Login");
        epl.setVisible(true);
        System.out.println("Employee login deployed");
    }

}
