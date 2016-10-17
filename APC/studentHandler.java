package APC2;

import java.util.HashMap;
/**
 * Created by cs_ch on 10/12/2016.
 */
public class studentHandler implements handler {

    public void handleIt(HashMap data) {
        try {
            HashMap d1 = data;
            System.out.println("good student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
