package JDBC;

import java.sql.*;

public class day1_ResultSetNewIteration {

    public static void main(String[] args) throws SQLException {


       // each time i will need connection
        //connection url, username, password

        String connectionUrl="jdbc:oracle:thin:@3.91.68.37:1521:XE";
        String userName="hr";
        String password="hr";


        //statement
        //yo need to creta estatement from connection
        Connection connection= DriverManager.getConnection(connectionUrl, userName, password);

        //2. adim
        //to be able to create statement, you neeed to use connection
        Statement statement=connection.createStatement();

        //3.adim
        //3. step is being able to pass and execute query
        ResultSet resultSet=statement.executeQuery("SELECT * FROM employees");

        //let say you wanna see 2.employee id and name
        //cursor is on top of table
        //to be able to get data youu need to move your cursor

        resultSet.next(); //cursor is on 1.row whicH is 1.employee
        resultSet.next(); // cursor is on 2.row

        System.out.println("+++++++++");

        System.out.println("employee id: "+ resultSet.getString(1)+" , employee first name: "
                +resultSet.getString(2));
        System.out.println("employee id: "+ resultSet.getString("employee_id")+
                " , employee first name: "+resultSet.getString("first_name"));

        System.out.println("+++++===++++");

        while(resultSet.next()){  //sadece we will have remaining ones, we already got Neena o yuzden onu bi daha vermedi
            System.out.println("employee id: "+ resultSet.getString(1)+" , employee first name: "
                    +resultSet.getString(2));
        }

resultSet.close(); //it will only close your result set which was query "select*from employees"


        //since i need to work on new query with same statement and same connection
        //we dont need to close everthing
        ResultSet resultSet2=statement.executeQuery("SELECT * FROM countries");

      //print whole countries table
     //cursor is before table

        System.out.println("+++++===++++");

        while(resultSet2.next()){
            System.out.println(resultSet2.getString("country_id")+ " " +
                 resultSet2.getString("country_name")+ " "+
                         resultSet2.getString("region_id"));

        }




        resultSet.close();
        statement.close();
        connection.close();


    }
}







