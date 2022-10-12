package backend;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class test {

    public static Object[][] getData(String dbname) {
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
            String Message = "select * from " + dbname + ";";
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


    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Helloa");
    }
}




