package com.fpoon.s3dcam

import javafx.geometry.Point2D
import javafx.geometry.Point3D

import javax.swing.JPanel
import java.awt.Color

class Camera {

    static final double TRANSLATION = 10.0
    static final Point3D TRANSLATION_UP = new Point3D(0, +TRANSLATION, 0);
    static final Point3D TRANSLATION_DOWN = new Point3D(0, -TRANSLATION, 0);
    static final Point3D TRANSLATION_LEFT = new Point3D(-TRANSLATION, 0, 0);
    static final Point3D TRANSLATION_RIGHT = new Point3D(+TRANSLATION, 0, 0);
    static final Point3D TRANSLATION_FORWARD = new Point3D(0, 0, +TRANSLATION);
    static final Point3D TRANSLATION_BACKWARD = new Point3D(0, 0, -TRANSLATION);

    JPanel panel
    double focal
    Scene scene;
    Point3D translation;


    Camera(JPanel panel, Scene scene) {
        this.focal = 300.0
        this.panel = panel
        this.scene = scene
        this.translation = new Point3D(0,0,0)
    }

    def render() {
        render(scene.edges)
    }

    def render(Edge[] edges) {
        def gfx = panel.graphics
        gfx.setColor(Color.BLACK)
        gfx.fillRect(0, 0, panel.width, panel.height)
        edges.collect {translatePoint(it)} .each {
            if (!(Double.isFinite(it.begin.z) && Double.isFinite(it.end.z)))
                return
            println "${it.begin} ${it.end}"
            gfx.color = it.color
            gfx.drawLine((int)it.begin.x, (int)it.begin.y, (int)it.end.x, (int)it.end.y);
        }

    }

    void translate(Point3D vector) {
        translation = translation.add(vector)
    }

    private Edge translatePoint(Edge edge3d) {
        return new Edge(
                translatePoint(edge3d.begin),
                translatePoint(edge3d.end),
                edge3d.color
        )
    }

    private Point3D translatePoint(Point3D p) {
        def rect = panel.getVisibleRect()
        def windowTranslation = new Point3D(rect.width / 2.0, rect.height / 2.0, 0)
        def mltp = focal / (p.z - translation.z)
        def x = mltp * (p.x + translation.x) + windowTranslation.x
        def y = windowTranslation.y - mltp * (p.y + translation.y)
        return new Point3D(x, y, (p.z - translation.z) > 0 ? 0 : Double.NaN);
    }
}
