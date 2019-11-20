package dssc.crossway;

public class ClientMain {
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 10431;
        Thread clientThread= new Thread(new GoClient(ip, port));
        clientThread.start();
    }
}
