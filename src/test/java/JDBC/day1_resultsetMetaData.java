package JDBC;

import JDBC.utils.databaseutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class day1_resultsetMetaData {

    public static void main(String[] args) throws SQLException {

        //create utils package
//create DataBaseUtil class
//create method called connectionDatabase under DataBaseUtil
//this method will take connection url , username and password
//it will create connection

//so we dont need to type below lines each time in the class
//    String url="jdbc:oracle:thin:@54.88.118.39:1521:XE";
//    String userName="hr";
//    String password="hr";
//
//    Connection connection= DriverManager.getConnection(url,userName,password);

        databaseutil.connectionDatabase();

        //bu alttaki commentler icin bir util yarttik databaseutilde
//        //statement
//        //you need to create statement from connection
//        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        //this statement will give me abilty to move anywhere in table
//
//        ResultSet resultSet=statement.executeQuery("SELECT * FROM Regions");

        ResultSet resultSet=databaseutil.runQuery("select * from employees");

        //resultSet.next();

        //System.out.println(resultSet.getString(3));

        ResultSetMetaData rmsd=resultSet.getMetaData();
        //we will be able to use librarry from metadata

        //such as column name column count
        int columnCount=rmsd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        //if you want to print 3 column name
        String thirdColumn=rmsd.getColumnName(3);
        System.out.println("thirdColumn = " + thirdColumn);

        System.out.println("**********************");

        for (int i=1 ; i <=columnCount ; i++){ //1 2 3 11
            System.out.print(rmsd.getColumnName(i) + "\t");
        }
        System.out.println();

        System.out.println("hello"+"\nworld ");
        System.out.println("\tsql");

        //if we want to store all calumnnames
        //we can store them in the arraylist

        List<String> columnNames=new ArrayList<>();

        for (int i=1 ; i <= columnCount ; i++){
            columnNames.add(rmsd.getColumnName(i));
        }

        System.out.println("columnNames = " + columnNames);

        resultSet.close();



    }

}

