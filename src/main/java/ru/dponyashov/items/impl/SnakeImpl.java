package ru.dponyashov.items.impl;

import ru.dponyashov.items.Snake;
import ru.dponyashov.others.Direction;
import ru.dponyashov.others.Point;
import ru.dponyashov.others.PointImpl;

import java.util.ArrayList;
import java.util.List;

public class SnakeImpl implements Snake {
    private List<Point> snake;
    private Direction direction;

    public SnakeImpl(Point head, int pointCount){
        initSnake(head, pointCount);
    }

    @Override
    public void move() {
        Point head = this.snake.get(0);
        int newX = head.x();
        int newY = head.y();
        switch (direction){
            case UP -> newX--;
            case DOWN -> newX++;
            case LEFT -> newY--;
            case RIGHT -> newY++;
        }
        for (int i = snake.size() - 1; i > 0; i--) {
            Point last = snake.get(i - 1);
            Point first = snake.get(i);
            first.setX(last.x());
            first.setY(last.y());
        }
        head.setX(newX);
        head.setY(newY);
    }

    @Override
    public void turn(Direction direction) {
        if((this.direction.value() + direction.value()) % 2 == 0) return;
        this.direction = direction;
    }

    @Override
    public List<Point> points() {
        return snake;
    }

    @Override
    public void addPoint(Point newPoint) {
        snake.add(0, newPoint);
    }

    @Override
    public Point nextHead() {
        Point head = this.snake.get(0);
        Point newHead = head.clone();
        int newX = head.x();
        int newY = head.y();
        switch (direction){
            case UP -> newX--;
            case DOWN -> newX++;
            case LEFT -> newY--;
            case RIGHT -> newY++;
        }
        newHead.setX(newX);
        newHead.setY(newY);
        return newHead;
    }

    private void initSnake(Point head, int count){
        direction = Direction.UP;
        snake = new ArrayList<>();
        snake.add(head);
        for(int i = 1; i < count; i++) {
            snake.add(new PointImpl(head.x(), head.y() + i, head.color()));
        }
    }
}
