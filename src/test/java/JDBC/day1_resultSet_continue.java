package JDBC;

import java.sql.*;

public class day1_resultSet_continue {

        //statement
        //you need to create statement from connection
        //Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //this statement will give me abilty to move anywhere in table

        //----- other methods available under ResultSet class
        //
        //		rs.next()       // is used to move the cursor to the one row next from the current position.
        //		rs.previous()   // is used to move the cursor to the one row previous from the current position.
        //		rs.first() 		// is used to move the cursor to the first row in result set object.
        //		rs.last()		// is used to move the cursor to the last row in result set object.
        //		rs.beforeFirst()  // back to before first row location
        //		rs.afterLast() 	  // move to the after last row location
        //		rs.absolute(rowNum)   // is used to move the cursor to the specified row number in the ResultSet object.

        public static void main(String[] args) throws SQLException {
            //connection
            //url.,username,password

            String url = "jdbc:oracle:thin:@54.88.118.39:1521:XE";
            String userName = "hr";
            String password = "hr";

            Connection connection = DriverManager.getConnection(url, userName, password);

            //statement
            //you need to create statement from connection
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //this statement will give me abilty to move anywhere in table

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Regions");

            //cursor is on top of table which before first

            System.out.println(resultSet.isAfterLast()); // false
            System.out.println(resultSet.isBeforeFirst()); //true

            resultSet.afterLast();
            System.out.println(resultSet.isAfterLast()); // true

            resultSet.absolute(3);//asia row number 3
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));


            resultSet.next(); //4
            resultSet.previous(); //3
            resultSet.previous(); //2


            //print row number that you are in
            System.out.println("resultSet.getRow() = " + resultSet.getRow());

            resultSet.next();
            System.out.println("resultSet.getRow() = " + resultSet.getRow());

            resultSet.close();
            statement.close();
            connection.close();


        }
}
