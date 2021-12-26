package JDBC.day2;



import JDBC.utils.databaseutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_AllData {

    public static void main(String[] args) throws SQLException {
        //connection -- statement -resultset

        databaseutil.connectionDatabase();

        //statment
        ResultSet rs=databaseutil.runQuery("select * from employees");

        System.out.println("DataBaseUtil.getTotalColumnCount() = " + databaseutil.getTotalColumnCount());

        rs.absolute(10);


        databaseutil.getAllData();

        rs.next();//afterlast
        System.out.println("rs.getString(1) = " + rs.getString(1));

        //print me specific row and column value
        //ex : row number 25 and print last name
        //expected output : Mourgos

        rs.absolute(25);
        System.out.println(rs.getString("last_name"));



    }
}