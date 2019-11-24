package test.crossway;

import dssc.crossway.GoClient;
import dssc.crossway.GoServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NetworkingTest {
    @Test
    void ServerClientInitTest() throws IOException {
        String ip = "localhost";
        int port = 10431;
        Thread serverThread = new Thread(new GoServer(ip, port));
        Thread clientThread= new Thread(new GoClient(ip, port));
        serverThread.start();
        clientThread.start();
    }



}
