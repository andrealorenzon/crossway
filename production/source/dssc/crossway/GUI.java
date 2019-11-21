package dssc.crossway;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUI {
    public static void main(String[] args) {
        startGUI();
    }

    @NotNull
    private static JButton drawButton(int x, int y, Colors stoneCol)  {

        JButton button = new JButton( );

        if (stoneCol==Colors.WHITE) {

           button.setForeground( Color.WHITE );
           button.setText( "\u2B24" );
        } else if (stoneCol==Colors.BLACK) {
            button.setForeground( Color.BLACK );
            button.setText( "\u2B24" );
        }
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBackground(Color.lightGray);
        button.setFont(new Font ("Arial", Font.PLAIN, 32));
        button.setBounds( x*50+10, y*50+10, 49,49 );


        return button;
    }

    //remove later

    private static Colors randomColor() {
        return Colors.values()[new Random().nextInt(Colors.values().length)];
    }

    private static void startGUI()  {
        //config
        int side = 12; // get it from GC!
        String WHITE= "\u25EF";
        String BLACK= "\u2B24";
        String MAYBE= "\u0021\u20DD";
        Font defaultFont = new Font ("Arial", Font.PLAIN, 13 );

        JFrame f = new JFrame( "Crossways Game" );
        f.setBounds( 100,200,620,720 );

        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++) {
                f.add(drawButton(i,j,randomColor()));
            }
        }


        f.setLayout( null );
        f.setVisible( true );

        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}

