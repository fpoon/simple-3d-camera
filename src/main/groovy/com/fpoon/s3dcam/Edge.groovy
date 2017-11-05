package com.fpoon.s3dcam

import javafx.geometry.Point3D;

import java.awt.*;

class Edge {
    Point3D begin;
    Point3D end;
    Color color;

    Edge (Point3D begin, Point3D end) {
        this(begin, end, Color.WHITE)
    }

    Edge (Point3D begin, Point3D end, Color color) {
        this.begin = begin
        this.end = end
        this.color = color
    }
}
