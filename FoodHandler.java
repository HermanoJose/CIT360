import JSON.JSONOutputStream;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Joseph on 12/1/16.
 */
public class FoodHandler implements Handler{
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        String todayDate = (String)dataMap.get("date");
        FoodModel theModel = (FoodModel)dataMap.get("model");
        Food foundFood = theModel.getFood(todayDate);
        HashMap<String, Object> responseMap = new HashMap<>();
        JSONOutputStream outToClient = (JSONOutputStream)dataMap.get("toClient");
        try {
            outToClient.writeObject(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
