package dssc.crossway;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GoServer implements Runnable {

    private String ip = "localhost";
    private int port = 10431;

    @Override
    public void run() {
        try {
            initServer();
        } catch (IOException e) {
            System.out.println( "server init failed" );
        }
    }

    public GoServer (String ip, int port) {
        this.ip = ip;
        this.port = port;
    }


    void initServer() throws IOException {
        //create serverSocket
        ServerSocket sSocket = new ServerSocket( this.port );
        //open socket
        Socket socket = sSocket.accept();
        //read input stream
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        do {
            line = reader.readLine();    // reads a line of text

            System.out.println( "*S* Server read line: " + line );

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter( output, true );
            writer.println( "Message received" );
            System.out.println( "*S* Server sent confirmation" );
        } while(!line.equals("close"));

        socket.close();
        sSocket.close();
    }
}
