package ru.dponyashov.visualisation;

import java.awt.*;

public class CellSnakeGame {
    int x;
    int y;
    int size;
    Color color;

    public CellSnakeGame( int x, int y, int size, Color color ) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    public void draw( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( this.color );
        g2d.fillRect( x, y, size, size );
    }
}
