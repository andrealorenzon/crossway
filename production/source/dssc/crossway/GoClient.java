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
            InputStream input = socket.getInputStream();
            BufferedReader readFromServer = new BufferedReader(new InputStreamReader(input));
            Console console = System.console();
            String serverMessage;
            String moveX;
            String moveY;


            do{
                //first of all get and print board status
                for (int i=0; i < 12; i++) {
                    serverMessage = readFromServer.readLine();
                    System.out.println(serverMessage);
                }

                System.out.println("*C* Next move: X = ");
                moveX = console.readLine();
                System.out.println("*C* Next move: Y = ");
                moveY = console.readLine();
                ///////////
                String toSend = ("x:"+moveX+",y:"+moveY);
                //////////
                writeToServer.println( toSend);
                System.out.println("*C* Client sent "+ toSend);

                serverMessage = readFromServer.readLine();

                System.out.println("*C* Server sent "+ serverMessage);


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
