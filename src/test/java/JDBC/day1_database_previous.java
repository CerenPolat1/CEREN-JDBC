package JDBC;

import java.sql.*;

public class day1_database_previous {
    public static void main(String[] args) throws SQLException {

        //Statement statement=connection.create.createStatement();
        //default statement will be able to only move forward in resultset

        //this will be used created ResultSet that can move freely
       // Statement statement= conn.createStatement(ResultSet.TYPE.SCROLL_INTENSIVE, ResultSet.CONCUR_READ_ONLY);

        String connectionUrl="jdbc:oracle:thin:@3.91.68.37:1521:XE";
        String userName="hr";
        String password="hr";

        Connection connection= DriverManager.getConnection(connectionUrl, userName, password);

        //THIS STATEMENT WILL GIVE ME ABILITY TO MOVE ANYWHERE IN TABLE.
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );

      ResultSet resultSet=statement.executeQuery("SELECT *FROM locations Where country_id= 'US'");

     //move to cursor

        resultSet.next();//row1
        System.out.println(resultSet.getString(1)+ " "+resultSet.getString("city"));


        resultSet.next(); //row 2
        resultSet.next();//row 3
        resultSet.next();//row 4  ---table'da toplam 4 rows var
       // resultSet.next();//row 5  --bir sey gostermez cunku table'da 5.row yok,,eger print edersen exception verir

        //move back
        resultSet.previous(); //bu yolla 1 step back yaparsin ,, row 3
        System.out.println(resultSet.getString(1)+ " "+resultSet.getString("city"));

        resultSet.previous(); //row 2
        resultSet.previous(); //row 1
        // resultSet.previous(); //row 0 ,,, boyle bir index no yok, o yuzden run etmez, eger print edersen exception verir


        //this will move the cursor to last location we have
        resultSet.last();//1700 Seattle
        System.out.println(resultSet.getString(1)+ " "+ resultSet.getString("city"));

        //this will move the cursor to 1. data
        resultSet.first(); //1400 Southlake
        System.out.println(resultSet.getString(1)+ " "+ resultSet.getString("city"));

      //to move cursor to before 1. row which is top of table
        resultSet.beforeFirst();
       // System.out.println(resultSet.getString(1)+ " "+ resultSet.getString("city"));   ////exception verir yukaridakinden dolayi

       //this will move cursor after last data
        resultSet.afterLast();
        //System.out.println(resultSet.getString(1)+ " "+ resultSet.getString("city")); exception verir

       while(resultSet.previous()){
           System.out.println(resultSet.getString("location_id")+ " "
                   +resultSet.getString("state_province"));
       }

        //close connection
        resultSet.close();
        statement.close();
        connection.close();







    }
}
