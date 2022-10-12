package backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePage extends JDialog {
    private JButton deleteAccountButton;
    private JButton createAccountButton;
    private JTextField passwordInput;
    private JTextField balanceInput;
    private JTextField idInput;
    private JTable customer_accounts;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JScrollPane scrollpane;
    private JLabel balanceLabel;
    private JLabel passwordLabel;
    private JLabel idLabel;

    public EmployeePage() {

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(passwordInput.getText());
                System.out.println(balanceInput.getText());
                msql.insert(passwordInput.getText().trim(), Integer.parseInt(balanceInput.getText().trim()));
                Object[][] data = msql.getData("customer_accounts");
                Object[] cols = msql.getHeaders("customer_accounts");
                DefaultTableModel model = new DefaultTableModel(data, cols);
                customer_accounts.setModel(model);
            }
        });
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                msql.delete(Integer.parseInt(idInput.getText().trim()), passwordInput.getText().trim(), Integer.parseInt(balanceInput.getText().trim()));
                Object[][] data = msql.getData("customer_accounts");
                Object[] cols = msql.getHeaders("customer_accounts");
                DefaultTableModel model = new DefaultTableModel(data, cols);
                customer_accounts.setModel(model);
            }
        });
    }

    public static void main(String[] args) {
        EmployeePage frame = new EmployeePage();
        frame.setContentPane(new EmployeePage().buttonPanel);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Employee page deployed");
    }

}
