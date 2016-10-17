package HttpConnection;

import java.net.HttpURLConnection;
import java.net.URL; //URL library
import java.util.HashMap;
import java.util.Scanner;

import JSON.JSONInputStream;
/**
 * Created by cs_ch on 10/11/2016.
 */
public class url {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=83440,us&APPID=65d26ba0e2cb8255a4d24fe556aa9dfa");
            HttpURLConnection link = (HttpURLConnection) url.openConnection();
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather); //weather class
            printWeather(theWeather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static void printWeather(Weather theWeather){
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("City: " + theWeather.getCityName()); //get city name
            System.out.println("Temperature " + KelvinToFahren(theWeather.getCurrentTemp()) + "F");
            System.out.println("Temperature Max " +KelvinToFahren(theWeather.getMaxTemp())+ "F");
            System.out.println("Temperature Min " +KelvinToFahren(theWeather.getMinTemp())+ "F");
            System.out.println("Wind Speed " +theWeather.getWindSpeed());
            System.out.println("Wind Degree " +theWeather.getWindDegree());

            System.out.println("If you would like temp in Celcius, type Yes, if not, just press enter");
            String command = input.nextLine();
            if (command == null){
                System.out.println("Thanks!");
            }else{
                System.out.println("Temperature " + KelvinToCel(theWeather.getCurrentTemp())+ "C");
                System.out.println("Temperature Max " +KelvinToCel(theWeather.getMaxTemp())+ "C");
                System.out.println("Temperature Min " +KelvinToCel(theWeather.getMinTemp())+ "C");
            }

        }

        private static double KelvinToFahren(double Kelvin){
            double Fahren = ((Kelvin*9)/5) - 459.67;
            return Fahren;
        }

        private static double KelvinToCel(double Kelvin){
            double Cel = Kelvin - 273.15;
            return Cel;
        }
}
