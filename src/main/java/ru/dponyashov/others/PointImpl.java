package ru.dponyashov.others;

import java.awt.*;

public class PointImpl implements Point{
    private int x;
    private int y;
    private final Color color;

    public PointImpl(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int x() {
        return x;
    }
    public int y() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Color color() {
        return color;
    }
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        PointImpl point = (PointImpl) object;
        return x == point.x && y == point.y;
    }

    @Override
    public Point clone() {
        return new PointImpl(this.x, this.y, this.color);
    }
}
