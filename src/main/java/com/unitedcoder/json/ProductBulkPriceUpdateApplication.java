package com.unitedcoder.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductBulkPriceUpdateApplication {
    public static void main(String[] args) {
        FunctionLibrary functionLibrary=new FunctionLibrary();
        functionLibrary.openBrowser();
        LoginUser loginUser=new LoginUser("testautomation1","automation123!");
        functionLibrary.login(loginUser);

        //add product
        //map json data to test data object
        ObjectMapper objectMapper=new ObjectMapper();
        CubecartTestData cubecartTestData=new CubecartTestData();
        try {
            cubecartTestData=objectMapper.readValue(new File("doc\\cubecart_test.json"),CubecartTestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> testProducts=new ArrayList<>();
        for(int i=0;i<4;i++) {
            //add a product
            String currentTimeStamp=functionLibrary.getCurrentTimestamp();
            Product product= cubecartTestData.getProduct();
            functionLibrary.addProduct(product,currentTimeStamp);
            testProducts.add(new Product(product.getProductName()+currentTimeStamp,product.getProductCode()+currentTimeStamp,
                    product.getProductCategory(),product.getProductManufacturer()));
            functionLibrary.sleep(5);
        }

        functionLibrary.priceChange(testProducts,ProductBulkPriceMethod.BY_AMOUNT, ProductPriceChangeAction.ADD,10);
        functionLibrary.sleep(5);
        /*
        functionLibrary.priceChange(testProducts,ProductBulkPriceMethod.BY_AMOUNT,ProductPriceChangeAction.SUBTRACT,5);
        functionLibrary.sleep(5);
        functionLibrary.priceChange(testProducts,ProductBulkPriceMethod.BY_AMOUNT,ProductPriceChangeAction.SETTO,50);
        functionLibrary.sleep(10);
        functionLibrary.priceChange(testProducts,ProductBulkPriceMethod.BY_PERCENTAGE,
                ProductPriceChangeAction.NO_ACTION_FOR_PERCENTAGE,5);

         */

        functionLibrary.deleteProduct(testProducts);

        functionLibrary.logout();
        functionLibrary.closeBrowser();


    }
}
