package JDBC.day2;

import JDBC.utils.databaseutil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class c3_PracticeJunit {

    @BeforeAll
    public static void createConnection(){
        //connection
        databaseutil.connectionDatabase();
    }


    //print row number 15 column job_id from jobs table
    @Test
    public void TC1_printRow15ColumnJobIDFromJOBS(){
        //statment resultset run querry
        databaseutil.runQuery("select * from jobs");

        String itProg=databaseutil.getColumnDataFrowRow(15,"job_id");

        System.out.println(itProg);

        Assertions.assertEquals("IT_PROG" , databaseutil.getColumnDataFrowRow(15 ,"job_id" ));

    }

    @Test
    public void TC2_totalColumnCountJobs(){
        //statment resultset
        databaseutil.runQuery("select * from jobs");

        int actualColumnCount=databaseutil.getTotalColumnCount();

        int  expectedColumnCount=4;
        Assertions.assertEquals(expectedColumnCount,actualColumnCount);
    }

    @Test
    public void TC3_totalColumnCountEmployees(){
        //statment resultset
        databaseutil.runQuery("select * from employees");

        System.out.println("DataBaseUtil.getTotalColumnCount() = " + databaseutil.getTotalColumnCount());


        int actualColumnCount=databaseutil.getTotalColumnCount();

        int  expectedColumnCount=11;
        Assertions.assertEquals(expectedColumnCount,actualColumnCount);

    }

    @Test
    public void TC4_totalColumnCountEmployees(){
        //statment resultset


//        System.out.println("DataBaseUtil.getTotalColumnCount() = " + DataBaseUtil.getTotalColumnCount());


//        int actualColumnCount=DataBaseUtil.getTotalColumnCount();

//        int  expectedColumnCount=11;
//        Assertions.assertEquals(expectedColumnCount,actualColumnCount);

    }

    @Test
    public void TC5_mapPractice() throws SQLException {
        //statmet resultset
        ResultSet resultSet=databaseutil.runQuery("select * from employees");
        resultSet.absolute(10);

        Map<String,String> mapExample=new LinkedHashMap<>();

        mapExample.put("Last Name","Chen");
        mapExample.put("Last Name", resultSet.getString(3));//faviet

        System.out.println(mapExample);



    }



    @AfterAll
    public  static  void closed(){

        databaseutil.closingDatabase();

    }
}
