package backend;

import hash.SaltHash;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class msql
{
//---------------------------------------------GENERAL METHODS--------------------------------------------------------//
    public static int count(String tablename){
        int numRows = 0;
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement();
            String Message = "select count(*) from " + tablename + ";";
            ResultSet rs = Mystmt.executeQuery(Message);
            while(rs.next()){
                numRows = Integer.parseInt(rs.getString(1));
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
    return numRows;
    }

    public static Object[] getHeaders(String tablename){
        int counter = 0;
        Object[] headers = new Object[3];
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement();
            String Message = "select column_name from information_schema . columns where table_schema='bankgui' and table_name= '" + tablename + "';";
            ResultSet rs = Mystmt.executeQuery(Message);
            while(rs.next()){
                headers[counter] = rs.getString(1);
                counter++;
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
        System.out.println(Arrays.deepToString(headers));
        return headers;
    }



//-----------------------------------------------EMPLOYEE METHODS-----------------------------------------------------//
    public static void insert (String password, String username){
        try{
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" );


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            //Execute SQL query
            PreparedStatement datainsert = conn.prepareStatement("insert into employees(password, username) values(? , ?)");
            datainsert.setString(1, password);
            datainsert.setString(2, username);
            datainsert.executeUpdate();

            // SALT INSERT HERE NEKOOOOOOOOO!


            System.out.println("successful insert");
        }
        catch(  SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
            System.err.println() ;
        }

    }



    public static void delete(int employee_id ,String password , String username){
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }


            //Execute SQL query
            PreparedStatement Mystmt = conn.prepareStatement("delete from employees where id=? and password=? and username=?;");
            Mystmt.setInt(1,employee_id);
            Mystmt.setString(2,password);
            Mystmt.setString(3,username);
            Mystmt.executeQuery();
            System.out.println("successful deletion of employee account!");


        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.err.println() ;
        }

    }


    public static void update (int employee_id, String password, String username, boolean updatePassword, boolean updateUsername){
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            //Execute SQL query

            if (updatePassword)
             {
                String passwordSql = "update employees"
                        + " set " + "password=" + password
                        + " where account_id="+employee_id;
                Mystmt.executeUpdate(passwordSql);
                System.out.println("successful password update!");
             }
             if (updateUsername)
             {
                String usernameSql = "update employees"
                        + " set username ="+ username
                        + " where account_id="+employee_id;
                Mystmt.executeUpdate(username);
                System.out.println("successful username update!");
             }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.err.println() ;
        }
    }

    public static boolean checkLogin(int employee_id , String username, String password) throws NoSuchAlgorithmException {
        String hashedInput = SaltHash.currentEncrypt(password.concat(getSalt(employee_id, "employees_salts")), "SHA-256");
        boolean successfulLogin = false;
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            //Execute SQL query


                String sql = "SELECT * FROM employees WHERE id="+ employee_id + ";";
                ResultSet rs = Mystmt.executeQuery(sql);

                while(rs.next())
                {
                    String acctUserName = rs.getString(2);
                    String acctPassword = rs.getString(3);
                    System.out.println(acctPassword + " " + acctUserName);

                    if (username.equals(acctUserName) && password.equals(acctPassword)) {
                        System.out.println("check successful!");
                        successfulLogin = true;
                    }else{
                        System.out.println("incorrect password");
                        successfulLogin = false;
                    }
                }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.err.println() ;
        }
        return successfulLogin;
    }



//------------------------------------------------CUSTOMER METHODS----------------------------------------------------//

    public static void insert (String password , int balance) {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC", "root", "password");

            // Print all warnings
            for (SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning()) {
                System.out.println("SQL Warning:");
                System.out.println("State  : " + warn.getSQLState());
                System.out.println("Message: " + warn.getMessage());
                System.out.println("Error  : " + warn.getErrorCode());
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement();

            //Execute SQL query


            PreparedStatement pstmt = conn.prepareStatement("insert into customer_accounts(password, balance) values(?,?)");
            //Use the hashed password in the query
            System.out.println("Hashed password: " + password);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);

            //Execute Query
            pstmt.executeUpdate();

            System.out.println("successful insert");
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e)
        {
            System.err.println();
        }
    }

    public static void delete(int account_id,String password, int balance){
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            //Execute SQL query
            PreparedStatement Message = conn.prepareStatement("delete from customer_accounts where account_id=? and password=? and balance=?;");
            Message.setInt(1, account_id);
            Message.setString(2,password);
            Message.setInt(3,balance);
            int rows = Message.executeUpdate();
            System.out.println(rows);
            if (rows == 0){System.out.println("Unsuccessful deletion!");}
            if(rows == 1){System.out.println("Successful deletion!");;}
            else{System.out.println("Whoa, multiple entries have been deleted!");}
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.err.println() ;
        }
    }

    public static void update (int account_id, String account_password, double amount, boolean withdraw, boolean deposit){
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            //Execute SQL query

            if (withdraw == true)
            {

                String withdrawSql = "update customer_accounts"
                        + " set balance = balance - "+amount
                        + " where account_id="+account_id +
                        " and password = '"+ account_password + "'";
                Mystmt.executeUpdate(withdrawSql);
                System.out.println("sql withdraw request complete");

            }

            if (deposit == true)
            {
                String depositSql = "update customer_accounts"
                        + " set balance = balance + "+amount
                        + " where account_id="+account_id
                        + " and password = '"+ account_password + "'";
                Mystmt.executeUpdate(depositSql);
                System.out.println("sql deposit request complete");


            }


        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
    }


    // This method will concat salt to input and hash it, checking whether the hashes match with the hash on the database
    public static boolean checkLogin (int account_id, String account_password) throws NoSuchAlgorithmException
    {
        String hashedInput = SaltHash.currentEncrypt(account_password.concat(getSalt(account_id, "customer_salts")), "SHA-256");
        boolean successfulLog = false;
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            // Get salt of the corresponding accountID and concat to the input
            String Message = "select account_id, password from customer_accounts where account_id = " + account_id + ";";
            ResultSet rs = Mystmt.executeQuery(Message);
            while(rs.next()){
                if (Integer.parseInt(rs.getString(1)) == account_id && rs.getString(2).equals(hashedInput)){
                    successfulLog = true;
                    System.out.println("Login successful");
                }else{
                    successfulLog = false;
                    System.out.println("Login failed");
                }
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }

        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
        return successfulLog;
    }

    public static Object[][] getData(String tablename) {
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement Mystmt = conn.createStatement() ;

            //Execute SQL query
            String Message = "select * from " + tablename + ";";
            ResultSet rs = Mystmt.executeQuery(Message);

            while(rs.next()){
                ArrayList<Object> batch = new ArrayList<Object>();
                batch.add(rs.getInt(1));
                batch.add(rs.getString(2));
                batch.add(rs.getDouble(3));
                data.add(batch);
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }

        Object[][] dataArray = new Object[data.size()][data.get(0).size()];

        for(int i =0; i<data.size(); i++){
            for (int f = 0; f<data.get(i).size(); f++){
                dataArray[i][f] = data.get(i).get(f);
            }
        }

        return dataArray;
    }

//-----------------------------------------Supplementary Manager Methods----------------------------------------------//

    public static boolean checkLogin (String username, String password, int managerID) throws NoSuchAlgorithmException {

        String salt = getSalt(managerID, "manager_salt");
        String hashedInput = SaltHash.currentEncrypt(password.concat(salt), "SHA-256");
        System.out.println(hashedInput);
        boolean successfulLog = false;
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Selecting data where accountID matches
            PreparedStatement Message = conn.prepareStatement("select * from manager where accountID = ?;");
            Message.setInt(1, managerID);

            ResultSet rs = Message.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(2) + " " + rs.getString(3));
                System.out.println(rs.getString(3).equals(hashedInput));
                if (rs.getString(2).equals(username) && rs.getString(3).equals(hashedInput)){
                    successfulLog = true;
                    System.out.println("Login successful");
                }else{successfulLog = false;System.out.println("Login failed");}
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
        return successfulLog;
    }


//---------------------------------------------SALT METHODS-----------------------------------------------------------//



    // Creates a salt and encrypts the salted input, inserting the salt to the corresponding table and returns the hashed password
    public static String hashedPassword(String password, String salttable, String encryptAlgorithm) throws NoSuchAlgorithmException {

        // Create a salt
        String salt = SaltHash.saltGenerator(48, 127).toString() ;


        //Append salt onto password, then password is hashed

        String s = SaltHash.currentEncrypt(password.concat(salt), encryptAlgorithm) ;
        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage() )   ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            //Insert salt into salt table

            Statement Mystmt = conn.createStatement() ;

            String sql = ("insert into " + salttable + " (salt) values(\""+salt+"\");");
            Mystmt.executeUpdate(sql);

            System.out.println("Successful insert into " + salttable + "!");
            System.out.println("the salt: " + salt);


        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }

        // return the hashed password
        return s;
    }

    public static String getSalt(int accountID, String saltTable){

        String salt = null;

        try
        {
            // Load the database driver
            Class.forName( "com.mysql.cj.jdbc.Driver" ) ;


            // Get a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankgui?serverTimezone=UTC","root", "password");

            // Print all warnings
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn =
                    warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }


            // From the saltTable input we grab the salt with corresponding accountID

            PreparedStatement statement = conn.prepareStatement("select salt from " + saltTable + " where accountID=" + accountID + ";");
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                salt = rs.getString(1);
            }
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }


        return salt;


    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
//        insert(hashedPassword("good", "customer_salts", "SHA-256"), 400);
//        insert(hashedPassword("Percy", "customer_salts", "SHA-256"), 700);
//        insert(hashedPassword("banana", "customer_salts", "SHA-256"), 350);
//        insert(hashedPassword("rice", "customer_salts", "SHA-256"), 170);


        // salt input and hash it, then check for a match
        System.out.println(checkLogin("Percy", "cats", 1));

    }

}


// NOTES
// - Add

