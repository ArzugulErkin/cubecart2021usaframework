package com.unitedcoder.integrationtest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    //write a method to get a product information
    public boolean getProductName(String productName, Connection connection)
    {
        boolean isProductExist=false;
        Statement statement=null; //define a Statement object for executing sql script
        ResultSet resultSet=null; //define resultSet object
        CachedRowSet cachedRowSet=null;
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement= connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String productSqlScript=String.format("SELECT product_id,name,price FROM cc_CubeCart_inventory where name='%s'",productName);
        //execute the statement
        try {
            resultSet=statement.executeQuery(productSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //verify the result set
        if(resultSet==null)
        {
            System.out.println("No Records Found");
            return isProductExist;
        }
        else {
            try {
                cachedRowSet.populate(resultSet); //we store the result in the cached row set
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true)
            {
                try {
                    if(!cachedRowSet.next())
                        break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                int productId= 0;
                try {
                    productId = cachedRowSet.getInt("product_id");
                    String name=cachedRowSet.getString("name");
                    double price=cachedRowSet.getDouble("price");
                    System.out.println(String.format("product_id=%d name=%s price=%.2f",productId,name,price));
                    count=cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isProductExist=true;
            return isProductExist;
        }
    }
}
