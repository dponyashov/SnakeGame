package ru.dponyashov;

import ru.dponyashov.items.Apple;
import ru.dponyashov.items.Snake;
import ru.dponyashov.items.impl.AppleImpl;
import ru.dponyashov.items.impl.SnakeImpl;
import ru.dponyashov.others.Point;
import ru.dponyashov.others.PointImpl;
import ru.dponyashov.others.SnakeGameStatus;

import java.awt.Color;

public class SnakeGame {
    private final int cellCount;
    private Snake snake;
    private Apple apple;
    private final Color appleColor;
    private SnakeGameStatus gameStatus = SnakeGameStatus.IN_GAME;

    public SnakeGame(int cellCount, Color snakeColor, Color appleColor) {
        this.cellCount = cellCount;
        this.appleColor = appleColor;
        InitGame(snakeColor);
    }

    public void nextStep() {
        if(!checkApple()) {
            snake.move();
        }
        checkBorders();
    }
    public Snake snake() {
        return this.snake;
    }
    public boolean inGame() {
        return gameStatus == SnakeGameStatus.IN_GAME;
    }
    public SnakeGameStatus status(){
        return gameStatus;
    }

    public int cellCount() {
        return this.cellCount;
    }

    public Apple apple() {
        return this.apple;
    }

    private boolean checkApple() {
        Point nextHead = snake.nextHead();
        if (nextHead.equals(this.apple)) {
            snake.addPoint(nextHead);
            CreateApple();
            return true;
        }
        return false;
    }

    private void checkBorders() {
        Point head = snake.points().get(0);
        int xHead = head.x();
        int yHead = head.y();
        if ((xHead < 0) || (xHead >= this.cellCount) || (yHead < 0) || (yHead >= this.cellCount)) {
            this.gameStatus = SnakeGameStatus.GAME_OVER;
        }
        if (snake.points().size() < 5)
            return;
        for (int i = snake.points().size() - 1; i > 0; i--) {
            Point point = snake.points().get(i);
            if (head.equals(point)) {
                this.gameStatus = SnakeGameStatus.GAME_OVER;
            }
        }
    }

    private void InitGame(Color snakeColor) {
        int snakeSize = 3;
        int headX = cellCount / 2;
        int headY = cellCount / 2 - snakeSize / 2;
        Point snakeHead = new PointImpl(headX, headY, snakeColor);

        snake = new SnakeImpl(snakeHead, snakeSize);
        CreateApple();
    }

    private void CreateApple() {
        int iterationCount = 100;
        do {
            iterationCount--;
            int x = (int) (Math.random() * this.cellCount);
            int y = (int) (Math.random() * this.cellCount);
            apple = new AppleImpl(x, y, this.appleColor);
        } while (!appleNotOnSnake(apple) && iterationCount >= 0);
        if (iterationCount < 0){
            gameStatus = SnakeGameStatus.VICTORY;
        }
    }

    private boolean appleNotOnSnake(Point apple) {
        return snake.points().stream()
                .noneMatch(p -> p.equals(apple));
    }
}
