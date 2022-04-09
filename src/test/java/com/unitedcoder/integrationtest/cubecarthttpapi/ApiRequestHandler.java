package com.unitedcoder.integrationtest.cubecarthttpapi;

import org.apache.commons.lang3.time.StopWatch;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiRequestHandler {
    //define a getAllCustomers method
    public ApiResponseHandler getAllCustomers(String username,String password,String url, int port, String endPoint) {
        ApiResponseHandler apiResponseHandler = new ApiResponseHandler();
        AuthenticationProvider authenticationProvider = new AuthenticationProvider();
        StopWatch stopWatch = new StopWatch(); //start a clock before sending an api request
        stopWatch.start();
        //creating a new client
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(
                    authenticationProvider.getCredential(username, password, url, port)).build()) {
            //create a get request
            HttpGet httpGet = new HttpGet(url + ":" + port + "/" + endPoint);
            //get the response
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                System.out.println(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
                int responseCode = response.getStatusLine().getStatusCode();
                if (responseCode != 0) {
                    apiResponseHandler.setResponseCode(responseCode);
                    apiResponseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
                }
                //get the content
                HttpEntity entity = response.getEntity();  //this returns the response object entity
                if (entity != null) {
                    String responseContent = EntityUtils.toString(entity);
                    System.out.println(responseContent);
                    apiResponseHandler.setResponseContent(responseContent);
                }
            }
        }
        catch (IOException e) {
                e.printStackTrace();
            }
        return apiResponseHandler;
        }

    //define a addACustomerMethod method
    public ApiResponseHandler addACustomer(String username,String password,String url, int port, String endPoint,String payload) {
        ApiResponseHandler apiResponseHandler = new ApiResponseHandler();
        AuthenticationProvider authenticationProvider = new AuthenticationProvider();
        StopWatch stopWatch = new StopWatch(); //start a clock before sending an api request
        stopWatch.start();
        //creating a new client
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(
                authenticationProvider.getCredential(username, password, url, port)).build()) {
            //create a Post request
            HttpPost httpPost = new HttpPost(url + ":" + port + "/" + endPoint);
            httpPost.setHeader("Accept","application/json");
            httpPost.setHeader("Content-Type","application/json");
            httpPost.setEntity(new StringEntity(payload)); //set the request payload
            //get the response
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                System.out.println(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
                int responseCode = response.getStatusLine().getStatusCode();
                if (responseCode != 0) {
                    apiResponseHandler.setResponseCode(responseCode);
                    apiResponseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
                }
                //get the content
                HttpEntity entity = response.getEntity();  //this returns the response object entity
                if (entity != null) {
                    String responseContent = EntityUtils.toString(entity);
                    System.out.println(responseContent);
                    apiResponseHandler.setResponseContent(responseContent);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return apiResponseHandler;
    }
    }

