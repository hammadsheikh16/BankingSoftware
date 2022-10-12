package backend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class ManagerPageLogin extends JDialog {


    public JPanel mainPanel;
    private JButton loginButton;
    private JTextField manager_ID;
    public JTextField userField;
    public JLabel passwordLabel;
    public JLabel usernameLabel;
    public JLabel managerLabel;
    private JTextField passwordField;
    public JPanel miscPanel;
    public JPanel buttonPanel;
    public JTextField usernameField;

    ManagerPageLogin() {
        setTitle("Manager Login");
        setLayout(new GridLayout(1, 2));
        this.add(miscPanel);
        this.add(buttonPanel);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (msql.checkLogin(usernameField.getText().trim(), passwordField.getText().trim(), Integer.parseInt(manager_ID.getText().trim()))) {
                        ManagerPage m = new ManagerPage();
                    }
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        ManagerPageLogin x = new ManagerPageLogin();
        x.setTitle("Manager Login Page");
        x.setVisible(true);
        System.out.println("Manager login page deployed");
    }

}
