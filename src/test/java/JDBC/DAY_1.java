package JDBC;

import java.sql.*;

//import java.sql.*;   //bunu yazarak da import edersin ve her sey direct olarak buradan gelmis olur
public class DAY_1 {

    public static void main(String[] args) throws SQLException {

//        JDBC HAS DRIVER MANAGER CLASS TO MANAGE CONNECTION ACCORTIONG TO THE URL, USERNAME, PASSWORD
//
//        URL|CONNECTION STRING (YOU WILL BE GIVE THIS INFORMATION)
//
//        jdbc:oracle:thin:@54.88.118.39:1521:XE
//        "jdbc:oracle:thin:@IP_ADDRESS:1521:XE";
//        JBDC-----CONNECTION USING JAVA
//        ORACLE-----DATABASE VENDOR, RDBMS
//        THIN------ONE TYPE ORACLE DRIVER
//        IP_ADDRESS------ HOSTNAME OR IP
//        1521-----THIS IS PORT NAME USED FOR ORACLE DATABASE
//        XE------SID NAME UNIQUE IDENTIFIER FOR YOUR ORACLE DATABASE


        String connectionUrl="jdbc:oracle:thin:@3.91.68.37:1521:XE";
        String userName="hr";
        String password="hr";



        //1.adim:
        //connection comes from library sql import java.sql.*;
        Connection connection= DriverManager.getConnection(connectionUrl, userName, password);
         // anytime you call sql methods, classes, interfaces you also need to handle sql exception

         //2. adim
        //to be able to create statement, you neeed to use connection
        Statement statement=connection.createStatement();

        //3.adim
        //3. step is being able to pass and execute query
        ResultSet resultSet=statement.executeQuery("SELECT * FROM COUNTRIES");


          //DATABASE CURSOR IS ON BEFORE EACH DATA
        //TO BE ABLE TO MOVE ON INSIDE COUNTRIES TABLE
        //WE NEED TO MOVE THE CURSOR

        //cursor was on top of the table
         resultSet.next(); //now cursor is  on row 1 in the sql table

       //to be able to print data from table:
        //you will need to use getString() method

       // rs.getString(1) ==>  return the first colomn cell value at this row
        //rs.getString("column name") ==> returns ther cell value at this column at this row


        //there will be 2 way to print data from database first by passing index number of colomn
        // or you need to pass column name.
        System.out.println("First column value: "+ resultSet.getString(1));
        System.out.println("First column value: "+ resultSet.getString("country_name"));

        //System.out.println(resultSet.getString(0); invalid column cunku INDEX 1'DEN BASLAR

  //if i wanna print 2. row of data
        //i need to move cursor
        resultSet.next(); //cursor is on 2. row
        resultSet.next(); //cursor is on 3. row

 System.out.println("Third column value at row 3: " + resultSet.getString(3));//
 System.out.println("Third column value at row 3: " + resultSet.getString("region_id"));//



        //close connection
        resultSet.close();
        statement.close();
        connection.close();

        // not gonna run bec. we closed connection
       // System.out.println("First column value: "+ resultSet.getString(1));

    }

}
