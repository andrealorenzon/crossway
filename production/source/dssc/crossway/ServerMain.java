package dssc.crossway;

public class ServerMain {
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 10431;
        Thread serverThread = new Thread(new GoServer(ip, port));
        serverThread.start();
    }
}
