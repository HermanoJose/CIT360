import JSON.JSONInputStream;
import JSON.JSONOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cs_ch on 11/3/2016.
 */
public class RequestingThread extends Thread{
    boolean runningFlag = true;
    public void go() {
            try {
                URL url = new URL("http://localhost:8081/YEAH");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);//allows POST
                if(runningFlag) {
                    JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());
                    outToServer.writeObject("sending");
                }
                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());
                Object respone = inFromServer.readObject();
                System.out.println(respone);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void ThreadFlag(){
        runningFlag = false;
    }
}
