package com.fpoon.s3dcam

import javafx.geometry.Point2D
import javafx.geometry.Point3D

import javax.swing.JPanel
import java.awt.Color

class Camera {

    static final double TRANSLATION = 10.0
    static final double ROTATION = Math.PI/20;
    static final double FOCAL_CHANGE = 10.0
    static final double FOCAL_MIN = 50.0
    static final double FOCAL_MAX = 1000.0

    static final Point3D TRANSLATION_UP = new Point3D(0, -TRANSLATION, 0)
    static final Point3D TRANSLATION_DOWN = new Point3D(0, +TRANSLATION, 0)
    static final Point3D TRANSLATION_LEFT = new Point3D(+TRANSLATION, 0, 0)
    static final Point3D TRANSLATION_RIGHT = new Point3D(-TRANSLATION, 0, 0)
    static final Point3D TRANSLATION_FORWARD = new Point3D(0, 0, +TRANSLATION)
    static final Point3D TRANSLATION_BACKWARD = new Point3D(0, 0, -TRANSLATION)

    static final Point3D ROTATION_UP = new Point3D(-ROTATION, 0, 0)
    static final Point3D ROTATION_DOWN = new Point3D(+ROTATION, 0, 0)
    static final Point3D ROTATION_LEFT = new Point3D(0, -ROTATION, 0)
    static final Point3D ROTATION_RIGHT = new Point3D(0, +ROTATION,  0)
    static final Point3D ROTATION_Z_LEFT = new Point3D(0, 0, +ROTATION)
    static final Point3D ROTATION_Z_RIGHT = new Point3D(0, 0, -ROTATION)

    JPanel panel
    double focal
    Scene scene;
    Point3D translation;
    Point3D rotation;


    Camera(JPanel panel, Scene scene) {
        this.focal = 300.0
        this.panel = panel
        this.scene = scene
        this.translation = new Point3D(0,0,0)
        this.rotation = new Point3D(0,0,0)
    }

    void translate(Point3D vector) {
        translation = translation.add(vector)
    }

    void zoom(double change) {
        focal += change
        if (focal > FOCAL_MAX) focal = FOCAL_MAX
        if (focal < FOCAL_MIN) focal = FOCAL_MIN
    }

    void rotate(Point3D vector) {
        rotation = rotation.add(vector)
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

    private Edge translatePoint(Edge edge3d) {
        return new Edge(
                translatePoint(rotatePoint(edge3d.begin)),
                translatePoint(rotatePoint(edge3d.end)),
                edge3d.color
        )
    }

    private Point3D rotatePoint(Point3D o) {
        def x,y,z
        def Point3D p = new Point3D(o.x, o.y, o.z)
        //X axis
        x = p.x
        y = (p.z * Math.sin(rotation.x)) + (p.y * Math.cos(rotation.x))
        z = (p.z * Math.cos(rotation.x)) - (p.y * Math.sin(rotation.x))

        //Y axis
        p = new Point3D(x, y, z)
        x = (p.x * Math.cos(rotation.y)) - (p.z * Math.sin(rotation.y))
        y = p.y
        z = (p.x * Math.sin(rotation.y)) + (p.z * Math.cos(rotation.y))

        //Z axis
        p = new Point3D(x, y, z)
        x = (p.x * Math.cos(rotation.z)) + (p.y * Math.sin(rotation.z))
        y = (p.y * Math.cos(rotation.z)) - (p.x * Math.sin(rotation.z))
        z = p.z

        return new Point3D(x, y, z);
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
