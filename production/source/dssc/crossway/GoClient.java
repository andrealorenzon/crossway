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
            PrintWriter writer = new PrintWriter(output, true);

            Console console = System.console();
            String text;


            do{
                System.out.println("*C* Next Line:");
                text = console.readLine();
                writer.println( text );
                System.out.println("*C* Client sent "+ text);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
               String reply = reader.readLine();

                System.out.println("*C* Server sent "+ reply);

            } while (!text.equals("bye"));


            socket.close();
        }
        catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }

    }
}
