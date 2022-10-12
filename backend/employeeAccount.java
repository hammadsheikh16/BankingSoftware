package backend;

public class employeeAccount {
    private static String username;
    private static String password;
    private static int account_ID;

    public employeeAccount(int account_ID, String username, String password)
    {
        this.account_ID = account_ID;
        this.username = username;
        this.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static int getAccount_ID() {
        return account_ID;
    }

}
