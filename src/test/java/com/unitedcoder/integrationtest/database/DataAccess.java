package com.unitedcoder.integrationtest.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

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


    public boolean getCustomerName(String emailAddress, Connection connection)
    {
        boolean isCustomerExist=false;
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
        String customerSqlScript=String.format("SELECT customer_id,email FROM cc_CubeCart_customer where email='%s'",emailAddress);
        //execute the statement
        try {
            resultSet=statement.executeQuery(customerSqlScript); //select statements
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //verify the result set
        if(resultSet==null)
        {
            System.out.println("No Records Found");
            return isCustomerExist;
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
                int customerId= 0;
                try {
                    customerId = cachedRowSet.getInt("customer_id");
                    String email=cachedRowSet.getString("email");
                    System.out.println(String.format("customer_id=%d email=%s ",customerId, email));
                    count=cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isCustomerExist=true;
            return isCustomerExist;
        }
    }

    public boolean getCategoryName(String categoryName, Connection connection)
    {
        boolean isCategoryExist=false;
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
        String categorySqlScript=String.format("SELECT cat_name,cat_id FROM cc_CubeCart_category where cat_name='%s'",categoryName);
        //execute the statement
        try {
            resultSet=statement.executeQuery(categorySqlScript); //select statements
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //verify the result set
        if(resultSet==null)
        {
            System.out.println("No Records Found");
            return isCategoryExist;
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
                int categoryId= 0;
                try {
                    categoryId = cachedRowSet.getInt("cat_id");
                    String catName=cachedRowSet.getString("cat_name");
                    System.out.println(String.format("cat_id=%d cat_name=%s ",categoryId, catName));
                    count=cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isCategoryExist=true;
            return isCategoryExist;
        }
    }

    public boolean insertNewCategory(CategoryObject categoryObject, Connection connection)
    {
        String insertCategorySQLScript="INSERT INTO cc_CubeCart_category\n" +
                "(cat_name,cat_desc,cat_parent_id,cat_image,per_ship,item_ship,\n" +
                "item_int_ship,per_int_ship,hide,seo_meta_title,seo_meta_description,seo_meta_keywords,priority,status)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //we use SQL Prepared Statment to set the value for each of the columns
        PreparedStatement insertSatement=null;
        System.out.println(categoryObject.toString());
        try {
            insertSatement=connection.prepareStatement(insertCategorySQLScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            insertSatement.setString(1,categoryObject.getCatName());
            insertSatement.setString(2,categoryObject.getCatDesc());
            insertSatement.setInt(3,categoryObject.getCatParentId());
            insertSatement.setInt(4,categoryObject.getCatImage());
            insertSatement.setDouble(5,categoryObject.getPerShip());
            insertSatement.setDouble(6,categoryObject.getItemShip());
            insertSatement.setDouble(7,categoryObject.getItemIntShip());
            insertSatement.setDouble(8,categoryObject.getPerIntShip());
            insertSatement.setInt(9,categoryObject.getHide());
            insertSatement.setString(10,categoryObject.getSeoMetaTitle());
            insertSatement.setString(11,categoryObject.getSeoMetaDescription());
            insertSatement.setString(12,categoryObject.getSeoMetaKeywords());
            insertSatement.setInt(13,categoryObject.getPriority());
            insertSatement.setInt(14,categoryObject.getStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //execute the statment
        int affectedRow=0;
        try {
            affectedRow=insertSatement.executeUpdate(); //insert, delete, update
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%d rows affected",affectedRow));
        if(affectedRow>=1)
            return true;
        else
            return false;
    }
}
