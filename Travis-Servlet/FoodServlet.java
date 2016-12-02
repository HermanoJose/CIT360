import JSON.JSONInputStream;
import JSON.JSONOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Joseph on 12/1/16.
 */
@WebServlet(name = "FoodServlet", urlPatterns = {"/Food"})
public class FoodServlet extends HttpServlet {
    private ApplicationController theAppController = new ApplicationController();
    private FoodModel theModel = new FoodModel();

    public void init() {
        theAppController.mapCommand("getFood", new FoodHandler());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
//            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
//            Object clientObject = inFromClient.readObject();
//
//            System.out.println(clientObject);
//            String bye = "GoodBye";
//            outToClient.writeObject(bye);

            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
            HashMap<String, Object> dataMap = (HashMap)inFromClient.readObject();
            dataMap.put("model", this.theModel);
            dataMap.put("toClient", outToClient);
            String aCommand = (String) dataMap.get("command");
            theAppController.handleRequest(aCommand, dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
