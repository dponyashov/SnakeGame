package ru.dponyashov.visualisation;

import ru.dponyashov.SnakeGame;

import javax.swing.*;

public class WindowSnakeGame {
    private static JFrame frame = null;
    public static void showWindow( SnakeGame game ) {
        GraphicsSnakeGame graphicsSnakeGame = GraphicsSnakeGame.getInstance( game );
        if ( frame == null ) {
            frame = new JFrame();
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setLocation( 0 , 0 );
            frame.add( graphicsSnakeGame );
            frame.pack();
            frame.setVisible( true );
        }
        graphicsSnakeGame.repaint();
    }
}
