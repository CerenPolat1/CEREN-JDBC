package JDBC.day2;

import JDBC.utils.databaseutil;

public class DataBaseUtiiPractice {

    public static void main(String[] args) {

        //connection -statment -resultset

        databaseutil.connectionDatabase();

        databaseutil.runQuery("select * from jobs");

        String row5JobTitle=databaseutil.getColumnDataFrowRow(5, "job_title");


        System.out.println("row5JobTitle = " + row5JobTitle);


        //this will count total column from jobs table which is 4
        System.out.println("DataBaseUtil.getTotalColumnCount() = " + databaseutil.getTotalColumnCount());


        databaseutil.getAllData();
    }


}
