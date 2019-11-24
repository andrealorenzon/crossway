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

    private void startMultiplayerGame(Socket player1, Socket player2) throws IOException {

        OutputStream outputPlayer1 = player1.getOutputStream();
        PrintWriter writeToPlayer1 = new PrintWriter( outputPlayer1, true );

        writeToPlayer1.println( "Waiting for player 2.." );

        OutputStream outputPlayer2 = player2.getOutputStream();
        PrintWriter writeToPlayer2 = new PrintWriter( outputPlayer2, true );

        writeToPlayer2.println( "Both players connected." );
        writeToPlayer1.println( "Game starting..." );
        writeToPlayer2.println( "Game starting..." );
    }

    private void turn(Socket socket, GameController controller,  Colors color) throws IOException {

        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        Boolean isValid = false;

        do{

            writer.println(controller.getBoard());
            line = reader.readLine();    // reads a line of text
            int xMove;
            int yMove;
            //unpack and parse move command

            String[] tokens = line.split(",");
            try {
                xMove = Integer.parseInt(tokens[0].split(":")[1]);
                yMove = Integer.parseInt(tokens[1].split(":")[1]);

                //try to make a move
                try {
                    controller.placeStone( xMove, yMove, color );
                    writer.println( "Move accepted" );
                    isValid = true;
                } catch (OutOfBoardException oob) {
                    writer.println( "Out of board" );
                } catch(IllegalMoveException ill) {
                    writer.println( "Illegal move" );
                }
            } catch (NumberFormatException e) {
                writer.println( "Invalid input" );
                System.out.printf( "*S* Invalid move received, ignored: %s%n", line );
                continue;
            }

            System.out.printf( "*S* Server read line: %d,%d%n", xMove, yMove );
            System.out.println( "*S* Move processed, sent OK" );
    } while(!isValid);
}



    private void initServer() throws IOException {

        //instantiate controller
        GameController controller = new GameController( new GoBoard( 12 ), new CrosswayRules() );
        //create serverSocket
        ServerSocket sSocket = new ServerSocket( this.port );
        Console cons = System.console();
        //open socket for player 1
        Socket player1 = sSocket.accept();

        Socket player2 = sSocket.accept();

        startMultiplayerGame( player1, player2 );
        String stop = "";
        do {
            stop = cons.readLine();
            turn(player1, controller, Colors.WHITE);
            turn(player2, controller, Colors.BLACK);

        } while(stop != "stop");

        player1.close();
        player2.close();

        sSocket.close();
    }
}
