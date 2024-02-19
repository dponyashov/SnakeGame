package ru.dponyashov.visualisation;

import ru.dponyashov.SnakeGame;
import ru.dponyashov.items.Apple;
import ru.dponyashov.items.Snake;
import ru.dponyashov.others.Direction;
import ru.dponyashov.others.Point;
import ru.dponyashov.others.SnakeGameStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraphicsSnakeGame extends JPanel {
    private final int cellSize = 20;
    private final int sizeX;
    private final int sizeY;
    private static GraphicsSnakeGame instance = null;
    private Snake snake = null;
    private Point apple = null;
    private SnakeGameStatus status;

    private GraphicsSnakeGame( SnakeGame game ) {
        setBackground(Color.BLACK);
        this.sizeX = game.cellCount();
        this.sizeY = game.cellCount();
        setPreferredSize( new Dimension( sizeX * cellSize, sizeY * cellSize ) );
        addKeyListener(new KeyWorker());
        setFocusable(true);
    }

    public static GraphicsSnakeGame getInstance( SnakeGame game ) {
        if ( instance == null ) {
            instance = new GraphicsSnakeGame( game );
        }
        instance.setGameStatus( game.status());
        instance.setSnake( game.snake() );
        instance.setApple( game.apple() );
        return instance;
    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        if( status == SnakeGameStatus.IN_GAME ){
            if ( this.apple != null ) {
                CellSnakeGame cellSnakeGame = new CellSnakeGame( this.apple.y() * cellSize,
                        this.apple.x() * cellSize, cellSize, this.apple.color());
                cellSnakeGame.draw( g );
            }
            if ( this.snake != null ) {
                for ( Point point: this.snake.points() ) {
                    CellSnakeGame cellSnakeGame = new CellSnakeGame( point.y() * cellSize,
                            point.x() * cellSize, cellSize, point.color());
                    cellSnakeGame.draw( g );
                }
            }
        } else if (status == SnakeGameStatus.GAME_OVER){
            g.setColor(Color.WHITE);
            g.drawString( "GAME OVER!", ( sizeX / 2 - 5 ) * cellSize, ( sizeY / 2 ) * cellSize );
        } else {
            g.setColor(Color.WHITE);
            g.drawString( "VICTORY!", ( sizeX / 2 - 4 ) * cellSize, ( sizeY / 2 ) * cellSize );
        }
    }

    public void setGameStatus( SnakeGameStatus status) {
        this.status = status;
    }

    public void setApple( Apple apple) {
        this.apple = apple;
    }

    public void setSnake( Snake snake) {
        this.snake = snake;
    }

    class KeyWorker extends KeyAdapter {
        @Override
        public void keyPressed( KeyEvent e ){
            super.keyPressed(e);
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT -> snake.turn( Direction.LEFT );
                case KeyEvent.VK_RIGHT -> snake.turn( Direction.RIGHT );
                case KeyEvent.VK_UP -> snake.turn( Direction.UP );
                case KeyEvent.VK_DOWN -> snake.turn( Direction.DOWN );
            }
        }
    }
}
