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

        // JSON File Stream example including a JSONUtilities.stringyfy() example
        // the method also needs to be in a try catch block
        try {
            // creating a new file named personfile.txt
            File personFile = new File("personFile.txt");

            // opening a stream for the personfile
            FileOutputStream fileOut = new FileOutputStream(personFile);
            FileInputStream fileIn = new FileInputStream(personFile);

            // opening a string for JSON
            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            JSONInputStream jsonIn = new JSONInputStream(fileIn);

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

            // writing the objects to the personFile
            jsonOut.writeObject(person1);
            jsonOut.writeObject(person2);
            jsonOut.writeObject(person3);
            jsonOut.writeObject(person4);
            
            // using the stringify() method to convert the object into a JSONstring
            String jsonPerson1 = JSONUtilities.stringify(person1);
            System.out.println("Person1: "+jsonPerson1);
            String jsonPerson2 = JSONUtilities.stringify(person2);
            System.out.println("Person2: "+jsonPerson2);
            String jsonPerson3 = JSONUtilities.stringify(person3);
            System.out.println("Person3: "+jsonPerson3);
            String jsonPerson4 = JSONUtilities.stringify(person4);
            System.out.println("Person4: "+jsonPerson4);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // nasty paths from here on out! Sorry I haven't thought of any

    }
}



