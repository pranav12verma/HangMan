/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.URLConnection;

/**
 *
 * @author MSI
 */
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Scanner;
import org.json.JSONObject;

import org.json.JSONArray;

public class test {

    // Create a neat value object to hold the URL
    public static void main(String args[]) throws UnsupportedEncodingException, MalformedURLException, IOException {
        String url = "https://random-word-api.herokuapp.com/word/";
        String charset = "UTF-8";  
        String number = "1";
        String query = null;


        try {
            query = String.format("number=%s", URLEncoder.encode(number, charset));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i < jsonArray.length(); i++) {
                String s = jsonArray.getString(i);
                System.out.println(s);
            }
        }
    }
}
