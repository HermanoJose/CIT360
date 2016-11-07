public class JSONEchoClient {
    public static void main(String[] args) {
        RequestingThread request = new RequestingThread();
        try {
            for (int x = 0; x < 10; x++) {
                if(x==5){
                    request.ThreadFlag();
                    request.go();
                    request.interrupt();
                }else {
                    request.go();
                    request.sleep(2000);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
