package backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPage extends JDialog{

    public JTextField employee_password;
    public JTextField employee_username;
    public JTable employee_accounts;
    public JTable customer_accounts;
    public JLabel Customer_accounts;
    public JLabel Employee_accounts;
    public JLabel Customer_password;
    public JLabel Balance;
    public JLabel Username;
    public JLabel Employee_password;
    public JTextField customer_password;
    public JTextField customer_balance;
    public JButton createCustomer;
    public JButton deleteCustomer;
    public JButton createEmployee;
    public JButton deleteEmployee;
    public JPanel mainPanel;

    public ManagerPage() {
        this.add(Customer_accounts);
        this.add(Employee_accounts);
        this.add(Customer_password);
        this.add(Balance);

        createCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(customer_password.getText());
                System.out.println(customer_balance.getText());
                msql.insert(customer_password.getText().trim(), Integer.parseInt(customer_balance.getText().trim()));
                Object[][] data = msql.getData("customer_accounts");
                Object[] cols = msql.getHeaders("customer_accounts");
                DefaultTableModel model = new DefaultTableModel(data, cols);
                customer_accounts.setModel(model);


            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        createEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String args[]){
        ManagerPage m = new ManagerPage();
        m.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        m.pack();
        m.setVisible(true);
        System.out.println("Manager page deployed");
    }

}
