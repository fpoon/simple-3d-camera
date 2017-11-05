package com.fpoon.s3dcam

import javafx.geometry.Point2D
import javafx.geometry.Point3D

import javax.swing.JPanel

class Camera {

    JPanel panel
    double focal
    Scene scene;


    Camera(JPanel panel, Scene scene) {
        this.focal = 300.0
        this.panel = panel
        this.scene = scene
    }

    def render() {
        render(scene.edges)
    }

    def render(Edge[] edges) {
        def gfx = panel.graphics
        edges.collect {translate(it)} .each {
            println "${it.begin} ${it.end}"
            gfx.color = it.color
            gfx.drawLine((int)it.begin.x, (int)it.begin.y, (int)it.end.x, (int)it.end.y);
        }

    }

    Edge translate(Edge edge3d) {
        return new Edge(
                translate(edge3d.begin),
                translate(edge3d.end),
                edge3d.color
        )
    }

    Point3D translate(Point3D p) {
        def rect = panel.getVisibleRect()
        def translate = new Point2D(rect.width / 2.0, rect.height / 2.0)
        def mltp = focal / p.y
        def x = mltp * p.getX() + translate.x
        def z = translate.y - mltp * p.getZ()
        return new Point3D(x, z, 0);
    }
}
