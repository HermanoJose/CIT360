package com.example.cs_ch.secondapp;

import com.example.cs_ch.secondapp.JSON.JSONInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by cs_ch on 10/21/2016.
 */
public class ConnectionRunnable implements Runnable{
    public void run() {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=83440,us&APPID=65d26ba0e2cb8255a4d24fe556aa9dfa");
            HttpURLConnection link = (HttpURLConnection) url.openConnection();
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();

            Weather printWeather = new Weather(jsonWeather);

            System.out.println(jsonWeather);
            System.out.println("City: " + printWeather.getCityName()); //get city name
            System.out.println("Temperature " + printWeather.getCurrentTemp() + "F");
            System.out.println("Temperature Max " +printWeather.getMaxTemp()+ "F");
            System.out.println("Temperature Min " +printWeather.getMinTemp()+ "F");
            System.out.println("Wind Speed " +printWeather.getWindSpeed());
            System.out.println("Wind Degree " +printWeather.getWindDegree());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        //Nasty Path
        try{
            //putting NULL in URL
            URL testingURL = new URL(null);
            HttpURLConnection testingLink = (HttpURLConnection) testingURL.openConnection();
            System.out.println(testingLink);

            //without permission
            URL testingURL2 = new URL("https://mg.mail.yahoo.com/neo/launch?.rand=8kco9vk4v1edh");
            HttpURLConnection testingLink2 = (HttpURLConnection) testingURL2.openConnection();
            JSONInputStream test2 = new JSONInputStream(testingLink2.getInputStream());
            System.out.println(test2);

            //blocked by firewall
            URL testingURL3 = new URL("http://deviantart.com/");
            HttpURLConnection testingLink3 = (HttpURLConnection) testingURL3.openConnection();
            JSONInputStream test3 = new JSONInputStream(testingLink3.getInputStream());
            System.out.println(test3);

            //url that I can get to the server..... microsoft.com/aksdjflkajslkdf.html
            URL testingURL4 = new URL("https://www.microsoft.com/aksdjflkajslkdf.html");
            HttpURLConnection testingLink4 = (HttpURLConnection) testingURL4.openConnection();
            JSONInputStream test4 = new JSONInputStream(testingLink4.getInputStream());
            System.out.println(test4);

            //invalid server....... asdlkfjslkd.com/main.html
            URL testingURL5 = new URL("asdlkfjslkd.com/main.html");
            HttpURLConnection testingLink5 = (HttpURLConnection) testingURL5.openConnection();
            JSONInputStream test5 = new JSONInputStream(testingLink5.getInputStream());
            System.out.println(test5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}