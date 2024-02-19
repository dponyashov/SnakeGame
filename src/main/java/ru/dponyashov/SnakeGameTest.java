package ru.dponyashov;

import ru.dponyashov.visualisation.WindowSnakeGame;

import java.awt.*;

public class SnakeGameTest {
    private static final int stepDelay = 500;
    public static void main (String[] args) {
        SnakeGame snakeGame = new SnakeGame( 20, Color.GREEN, Color.RED );

        while ( snakeGame.inGame()) {
            snakeGame.nextStep();
            WindowSnakeGame.showWindow( snakeGame );
            try{
                Thread.sleep( stepDelay );
            } catch(Exception ignored){}
        }
    }
}