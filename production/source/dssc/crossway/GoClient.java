package dssc.crossway;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class GoClient implements Runnable {

    private String ip = "localhost";
    private int port = 10431;


    @Override
    public void run() {
        initClient();
    }

    public GoClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    void initClient() {
        try (Socket socket = new Socket(this.ip, this.port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writeToServer = new PrintWriter(output, true);

            Console console = System.console();
            String moveX;


            do{
                System.out.println("*C* Next move: X = ");
                moveX = console.readLine();
                System.out.println("*C* Next move: Y = ");
                String moveY = console.readLine();
                ///////////
                String toSend = ("x:"+moveX+",y:"+moveY);
                //////////
                writeToServer.println( toSend);
                System.out.println("*C* Client sent "+ toSend);
                InputStream input = socket.getInputStream();
                BufferedReader readFromServer = new BufferedReader(new InputStreamReader(input));
                String reply = readFromServer.readLine();

                System.out.println("*C* Server sent "+ reply);


            } while (!moveX.equals("bye"));


            socket.close();
        }
        catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }

    }
}
