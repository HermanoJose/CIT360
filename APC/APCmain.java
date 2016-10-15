package APC2;

import java.util.*;
/**
 * Created by cs_ch on 10/12/2016.
 */
public class APCmain {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ApplicationCon con = new ApplicationCon();

        con.CreateHashMap("student", new studentHandler());
        con.CreateHashMap("admin", new adminHandler());

        try{
            System.out.println("Please tell me who are you?");
            String command = input.nextLine();
            command.toLowerCase();

            System.out.println("Please give me the password which is 123456789");
            String pwd = input.nextLine();

            //pass in data
            HashMap data = new HashMap();
            data.put("password", pwd);

            con.handleRequest(command, data);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
