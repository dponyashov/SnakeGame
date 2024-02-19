package ru.dponyashov.others;

import java.awt.*;

public interface Point {
    int x();
    int y();
    void setX(int x);
    void setY(int y);
    Color color();
    boolean equals(Object object);
    Point clone();
}
