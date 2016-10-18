import JSON.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.*;

/**
 * Created by Heather on 9/27/2016.
 */
public class json {
    public static void main(String[] args) {

        // example of using the JSONUtilities.parse() method, which
        // needs to be in a try catch block at all times
        try {
            // a string in JSON string format, it is very important to
            // have it in this format, look in the book for more about format
            String json1 = "{\"Job Title\":\"Technician Intern\"}";

            // you need to cast the parse to what you want it to be
            // in this case I wanted it to be a (HashMap)
            HashMap aJob = (HashMap) JSONUtilities.parse(json1);
            System.out.println(aJob);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // nasty path - trying to parse a string, not a json string
            String string = "Technician Intern";
            HashMap stringJob = (HashMap) JSONUtilities.parse(string);
            System.out.println(stringJob);
        } catch (Exception e) {
            // you cannot give it a regular string, it has to be in json format
            System.out.println("Unexpected character (T) at position 0.");
        }

        try {
            // nasty path - tyring to parse an empty string
            String empty = "";
            HashMap emptyString = (HashMap) JSONUtilities.parse(empty);
            System.out.println(emptyString);

        } catch (Exception e) {
            // you get the error message below, it believes that it is at the end of the file
            System.out.println("Unexpected token END OF FILE at position 0");
        }

        try {
            // nasty path - trying to parse a null value
            String aNull = null;
            HashMap stringNull = (HashMap) JSONUtilities.parse(aNull);
            System.out.println(stringNull);
        } catch (Exception e) {
            // you just get null
            e.printStackTrace();
        }


        // JSON File Stream example including a JSONUtilities.stringyfy() example
        // the method also needs to be in a try catch block
        try {
            // creating a new file named personfile.txt
            File personFile = new File("personFile.txt");

            // opening a stream for the personfile
            FileOutputStream fileOut = new FileOutputStream(personFile);
            FileInputStream fileIn = new FileInputStream(personFile);

            // opening a steam for JSON
            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            JSONInputStream jsonIn = new JSONInputStream(fileIn);

            try {
                // nasty path - sending null to the jsonoutput stream
                String aNull = null;
                File nullFile = new File(aNull);
                FileOutputStream fileNull = new FileOutputStream(nullFile);
                JSONOutputStream jsonNull = new JSONOutputStream(fileNull);
                System.out.println(jsonNull);
            } catch (Exception e) {
                // this error message is thrown
                System.out.println("NullPointerException");
            }

            try {
                // nasty path - sending null to the jsonInput stream
                String aNull = null;
                File nullFile = new File(aNull);
                FileInputStream fileNull = new FileInputStream(nullFile);
                JSONInputStream jsonNull = new JSONInputStream(fileNull);
                System.out.println(jsonNull);
            } catch (Exception e) {
                // this error message is thrown
                System.out.println("NullPointerException");
            }

            try {
                // nasty path - trying to write to a file that the system has no rights to

                // the string is the path of my file that has no read or write permissions
                String noAccess = "C:\\Users\\Heather\\IdeaProjects\\sandbox\\noAccess.txt";
                FileOutputStream fileWrite = new FileOutputStream(noAccess);
                JSONOutputStream jsonWrite = new JSONOutputStream(fileWrite);
                // it shows the location of the JSONOutputStream but doesn't throw an error
                System.out.println(jsonWrite);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                // nasty path - trying to read a file that the system has no rights to

                // the string is the path of my file that has no read or write permissions
                String noAccess = "C:\\Users\\Heather\\IdeaProjects\\sandbox\\noAccess.txt";
                FileInputStream fileRead = new FileInputStream(noAccess);
                JSONInputStream jsonRead = new JSONInputStream(fileRead);
                // it shows the location of the JSONInputStream but doesn't throw an error
                System.out.println(jsonRead);
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                // nasty path - trying to read a photo

                // the string is the path of my photo
                String space = "C:\\Users\\Heather\\IdeaProjects\\sandbox\\outer-space.jpg";
                FileInputStream readSpace = new FileInputStream(space);
                JSONInputStream jsonReadSpace = new JSONInputStream(readSpace);
                // it shows the location of the JSONInputStream but doesn't throw an error
                System.out.println(jsonReadSpace);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Creating personBean objects -- you can make your own
            // this is just an example
            PersonBean person1 = new PersonBean();
            person1.setFirstName("John");
            person1.setLastName("Doe");
            person1.setAge(27);

            PersonBean person2 = new PersonBean();
            person2.setFirstName("Jordan");
            person2.setLastName("Smith");
            person2.setAge(16);

            PersonBean person3 = new PersonBean();
            person3.setFirstName("Sally");
            person3.setLastName("Smith");
            person3.setAge(24);

            PersonBean person4 = new PersonBean();
            person4.setFirstName("Jane");
            person4.setLastName("Doe");
            person4.setAge(30);

            // happy path - writing the objects to the personFile
            jsonOut.writeObject(person1);
            jsonOut.writeObject(person2);
            jsonOut.writeObject(person3);
            jsonOut.writeObject(person4);

            //read object multiple times, runs out of things to read

            // nasty path - adding a random int as a parameter and it appends to the end of the file
            jsonOut.writeObject(5);

            // nasty path - adding a random float and it also is appended to the end of the file
            jsonOut.writeObject(2.11);

            // using the stringify() method to convert the object into a JSONstring
            String jsonPerson1 = JSONUtilities.stringify(person1);
            System.out.println("Person1: " + jsonPerson1);
            String jsonPerson2 = JSONUtilities.stringify(person2);
            System.out.println("Person2: " + jsonPerson2);
            String jsonPerson3 = JSONUtilities.stringify(person3);
            System.out.println("Person3: " + jsonPerson3);
            String jsonPerson4 = JSONUtilities.stringify(person4);
            System.out.println("Person4: " + jsonPerson4);

            //stringify null, hello word, things that are already strings, dates
            try {
                // nasty path - stringify a null value
                String jsonNull = JSONUtilities.stringify(null);
                // it accepts and passes the null
                System.out.println("jsonNull: " + jsonNull);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                // nasty path - stringify a string
                String jsonHello = JSONUtilities.stringify("Hello World");
                // it works like normal
                System.out.println("jsonHello: " + jsonHello);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                // nasty path - stringify a date
                Date date = new Date();
                String jsonDate = JSONUtilities.stringify(date);
                // it works, prints the date in this format: YYYY-MM-DD and time XX:XX:XX.XXX
                // the regular day of week, month, day, time, time zone and year
                // example - Mon Oct 17 12:16:00 MDT 2016
                System.out.println(jsonDate);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



