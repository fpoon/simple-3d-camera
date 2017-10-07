package com.fpoon.s3dcam;

import java.awt.*;

class Edge {
    Point begin;
    Point end;
    Color color;

    Edge (Point begin, Point end) {
        this(begin, end, Color.WHITE)
    }

    Edge (Point begin, Point end, Color color) {
        this.begin = begin
        this.end = end
        this.color = color
    }
}
