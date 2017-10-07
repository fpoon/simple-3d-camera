package com.fpoon.s3dcam;

import java.awt.*;

class Edge {
    Point3D start;
    Point3D end;
    Color color;

    Edge (Point3D start, Point3D end) {
        this(start, end, Color.WHITE)
    }

    Edge (Point3D start, Point3D end, Color color) {
        this.start = start
        this.end = end
        this.color = color
    }
}
