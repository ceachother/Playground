/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-09-21 11:26
 * @Description:
 */
package com.cecil.jax.client;

import com.cecil.jax.entity.Account;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author LiMingChi 2016-09-21 11:26
 * @version V1.0
 */
public class AccountResourceClient {

    public void AccountIf() {

    }
    public static void main(String[] args) {
        String string = "";
        try {
            // Step1: Let's 1st create a json object
            Account account = new Account();
            account.setUserName("clientName");
            account.setId(255);
//            JSONObject jsonObject = new JSONObject(account);

            // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL("http://192.168.121.43:8077/ProductRESTService.svc/GetProductList");
//                URL url = new URL("http://localhost:8080/accounts/ac/json");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", 1);
                System.out.println(jsonObject.toString());
                OutputStream os = connection.getOutputStream();
                os.write("{\"ProductId\" : 1,\"Name\" :\"Product 1\"}".getBytes());
//                os.write("{\"id\":1}".getBytes());
//                os.write(jsonObject.toString().getBytes());
                os.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String output;
                while ((output = in.readLine()) != null) {
                    System.out.println(output);
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}