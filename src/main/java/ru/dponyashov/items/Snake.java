package ru.dponyashov.items;

import ru.dponyashov.others.Direction;
import ru.dponyashov.others.Point;

import java.util.List;

public interface Snake {
    void move();
    void turn(Direction direction);
    List<Point> points();
    void addPoint(Point newPoint);
    Point nextHead();
}