package dssc.crossway;

public class Main {
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 10431;
        Thread serverThread = new Thread(new GoServer(ip, port));
        Thread clientThread= new Thread(new GoClient(ip, port));
        serverThread.start();
        clientThread.start();
    }
}
