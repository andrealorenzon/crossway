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

    private void initServer() throws IOException {

        //instantiate controller
        GameController controller = new GameController( new GoBoard(12), new CrosswayRules());
        //create serverSocket
        ServerSocket sSocket = new ServerSocket( this.port );
        //open socket
        Socket socket = sSocket.accept();
        //read input stream + reader
        InputStream input = socket.getInputStream();
        BufferedReader readFromClient = new BufferedReader(new InputStreamReader(input));
        // output stream + writer
        OutputStream output = socket.getOutputStream();
        PrintWriter writeToClient = new PrintWriter( output, true );

        String line;
        do {
            writeToClient.println(controller.getBoard());
            line = readFromClient.readLine();    // reads a line of text
            int xMove;
            int yMove;
            //unpack and parse move command

            String[] tokens = line.split(",");
            try {
                xMove = Integer.parseInt(tokens[0].split(":")[1]);
                yMove = Integer.parseInt(tokens[1].split(":")[1]);

                //try to make a move
                try {
                    controller.placeStone( xMove, yMove, Colors.WHITE );
                    writeToClient.println( "Move accepted" );
                } catch (OutOfBoardException oob) {
                    writeToClient.println( "Out of board" );
                } catch(IllegalMoveException ill) {
                    writeToClient.println( "Illegal move" );
                }

            } catch (NumberFormatException e) {
                writeToClient.println( "Invalid input" );
                System.out.printf( "*S* Invalid move received, ignored: %s%n", line );
                continue;
            }

            System.out.printf( "*S* Server read line: %d,%d%n", xMove, yMove );
            System.out.println( "*S* Move processed, sent OK" );
        } while(!line.equals("close"));

        socket.close();
        sSocket.close();
    }
}
