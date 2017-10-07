package com.fpoon.s3dcam

import javax.swing.JPanel
import java.awt.Rectangle

class Camera {
    JPanel panel;
    Rectangle rect;
    def edges = [];

    Camera(JPanel panel) {
        this.panel = panel
        this.rect = panel.getVisibleRect();
    }

    def transform() {
        //TODO: Add real affinite operations
        return edges.collect {new Edge(new Point(it.begin.x, it.begin.y), new Point(it.end.x, it.end.y), it.color)}
    }

    def draw() {
        def gfx = panel.graphics
        def edges = transform();
        edges.each {
            gfx.color = it.color
            gfx.drawLine((int)it.begin.x, (int)it.begin.y, (int)it.end.x, (int)it.end.y)
        }
    }
}
