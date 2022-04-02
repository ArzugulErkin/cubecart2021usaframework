package com.unitedcoder.integrationtest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
//create a method to connect to database
    public static Connection connectToDatabaseServer(String dbUrl,String dbPort,String defaultDatabase,
                                                     String dbUsername,String dbPassword,ConnectionType connectionType)
    {
        //define a connection object
        Connection connection=null;
        String JTDS_Driver="net.sourceforge.jtds.jdbc.Driver";
        String MYSQL_Driver="com.mysql.cj.jdbc.Driver";
        switch (connectionType)
        {
            case MSSQL:
                try {
                    Class.forName(JTDS_Driver); //initialize the SQL Server driver
                } catch (ClassNotFoundException e) {
                    new RuntimeException("Please check the sql server driver information");
                }
                String connectionUrl = "jdbc:jtds:sqlserver://" + dbUrl + ":" + dbPort + ";DatabaseName=" + defaultDatabase;
                try {
                    connection= DriverManager.getConnection(connectionUrl,dbUsername,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MYSQL:
                try {
                    Class.forName(MYSQL_Driver).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    new RuntimeException("Please check mysql driver information");
                }
                String mysqlConnectionUrl="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDatabase+"?useSSL=false";
                try {
                    connection=DriverManager.getConnection(mysqlConnectionUrl,dbUsername,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("You need to specify a database connection type MSSQL or MYSQL");
                //verify the connections
                try {
                    if(!connection.isClosed())
                    {
                        System.out.println("Database connection is established");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return connection;
    }
    //define a method to disconnect from the database server
    public static void closeDatabaseConnection(Connection connection)
    {
        try {
            if(connection.isClosed())
            {
                System.out.println("connection has already been closed");
            }
            else {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
