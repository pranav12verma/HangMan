/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONArray;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author MSI
 */
public class HangMan {

    /**
     * @param args the command line arguments
     */
    static String word;
    static char[] c;
    static char[] u;
    public static String apiCall() throws UnsupportedEncodingException, MalformedURLException, IOException {
        String url = "https://random-word-api.herokuapp.com/word/";
        String charset = "UTF-8";  
        String number = "1";
        String query = null;
        String s = new String();

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
            // System.out.println(responseBody); // for getting JSON array
            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i < jsonArray.length(); i++) {
                s = jsonArray.getString(i);
                
            }
        }
        return s;
    }
    public static int random(int max){
        int randomNum;
        return randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
    }
    public static boolean check(char ip, char[] c){
        boolean flag = false;
        for(int i = 0 ;  i < c.length ; i++){
            if(ip == c[i]){
                flag = true;
                break;
            }    
        }
        return flag;
    }    
    
    public static void print(char[] u){
        for(int i = 0 ; i < u.length; i++){
            System.out.print(u[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        
        word = new String();
        word = apiCall();
        System.out.println("Welcome to HangMan Game");
        System.out.println("You get 5 lives to guess the correct word");
        System.out.println("Life will be deducted for each wrong word : ");
        System.out.println("The length of word is : "+word.length());
        
        boolean [] alpha = new boolean [26];
        
        int life = 4;
        int len = word.length();
        Scanner sc = new Scanner(System.in);
        c = word.toCharArray();
        u = new char[c.length];
        char hint = c[random(word.length())];
        int count = 0;
        for(int i = 0 ; i < u.length; i++){
            u[i] = '_';  
            if(hint == c[i]){
               u[i] = c[i];
               count++;
               alpha[((int)c[i]-97)] = true;
            }
        }
        print(u);
        int temp = 0;
        while(life>0 && temp<(len-count)){
            System.out.println("Enter a character: ");
            char ip = sc.next().charAt(0);
            ip = Character.toLowerCase(ip);
            if(alpha[((int)ip - 97)]){
                System.out.println("Already Entered");
                print(u);
                System.out.println("Life left: "+(life+1));
                continue;
            }
            alpha[((int)ip - 97)] = true;
            for(int  j= 0 ; j < len ; j++){
                if(ip == c[j] && ip != u[j]){
                    temp++;
                }
                if(ip == c[j]){
                    u[j] = c[j]; 
                    alpha[((int)c[j]-97)] = true;
                }
            }

            if(!check(ip, c) && alpha[((int)ip - 97)]){
                    --life;
            }
            else if(!check(ip, c)){

                    System.out.println("Already Entered Wrong");
 
            }
            print(u);
            System.out.println("Life left: "+(life+1));
            
        }
        if(life<=0)
            System.out.println("Game Over Life Over word was "+word);
        
        else if(temp >= len){
            System.out.println("You won the word was "+word);
        }
    }
}
