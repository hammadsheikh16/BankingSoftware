package backend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {
    private JButton Customer_Login;
    private JButton Employee_Login;
    private JButton managerLoginButton;
    private JButton Manager_Login;


    public Homepage() {
        super("Homepage");
        setLayout(new GridLayout());

        Customer_Login = new JButton("Customer Login");
        add(Customer_Login);

        Employee_Login = new JButton("Employee Login");
        add(Employee_Login);

        Manager_Login = new JButton("Manager Login");
        add(Manager_Login);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Customer_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerPage s = new CustomerPage();
                s.setVisible(true);
            }
        });
        Employee_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeePageLogin a = new EmployeePageLogin();
                a.setVisible(true);
            }
        });
        managerLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerPageLogin m = new ManagerPageLogin();
                m.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Homepage h = new Homepage();
        h.setSize(500, 500);
        h.setVisible(true);
        System.out.println("PROGRAM FLOW: ");
    }

}

