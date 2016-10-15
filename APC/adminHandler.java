package APC2;

import java.util.HashMap;

/**
 * Created by cs_ch on 10/12/2016.
 */
public class adminHandler implements handler{
    public void handleIt(HashMap data) {
        try {
            HashMap d2 = data;
            System.out.println(d2.get("password"));
            if (validation(d2)== true){
                System.out.println("Good morning Admin, What can I do for you");
            }else{
                System.out.println("something wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validation(HashMap d2){
        String lol = (String)d2.get("password");

        if(lol.equals("123456789")){
            return true;
        }else{
            return false;
        }
    }
}
