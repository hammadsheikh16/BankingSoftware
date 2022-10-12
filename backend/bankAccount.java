package backend;

import java.security.NoSuchAlgorithmException;

public class bankAccount{

    private static String password;
    private static double balance;
    private static final double OVERDRAWN_PENALTY = 20.0D;
    private static int account_id;

    public bankAccount() {

        this.password = "";
        this.balance = 0.0;
        this.account_id = 0;

    }

    public bankAccount(int acc_id, String acctPassword, double acctBalance)
    {
        this.password = acctPassword;
        this.balance = acctBalance;
        this.account_id = acc_id;
    }

    public static double getBalance()
    {
        return balance;
    }

    public static String getPassword()
    {
        return password;
    }

    public static int getAccount_id()
    {
        return account_id;
    }


    public void deposit(String acctPassword, double amount, int account_id) throws NoSuchAlgorithmException {
        if (msql.checkLogin(account_id, acctPassword)){
            msql.update(account_id, acctPassword, amount, false, true);
        }else {System.out.println("Deposit Failed");}
    }

    public void withdraw(String acctPassword, double amount, int account_id) throws NoSuchAlgorithmException {
        if(msql.checkLogin(account_id, acctPassword)){
            msql.update(account_id, acctPassword, amount, true, false);
        }else{System.out.println("Withdraw Failed");}
    }



}

