package APC2;

import java.util.HashMap;
/**
 * Created by cs_ch on 10/12/2016.
 */
public class ApplicationCon {
    private HashMap<String, handler> handlerMap = new HashMap();

    public void handleRequest(String command, HashMap<String, Object> data) {
        handler commander = handlerMap.get(command);
        if (commander != null) {
            commander.handleIt(data);
        }else{
            System.out.println("ID cannot be empty");
        }
    }

    public void CreateHashMap(String aCommand, handler acHandler) {
        handlerMap.put(aCommand, acHandler);
    }
}
