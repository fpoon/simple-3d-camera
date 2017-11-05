package com.fpoon.s3dcam

import javafx.geometry.Point2D
import javafx.geometry.Point3D

import javax.swing.JPanel
import java.awt.Color

class Camera {

    static final double TRANSLATION = 10.0
    static final double ROTATION = Math.PI / 20;
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
    static final Point3D ROTATION_RIGHT = new Point3D(0, +ROTATION, 0)
    static final Point3D ROTATION_Z_LEFT = new Point3D(0, 0, +ROTATION)
    static final Point3D ROTATION_Z_RIGHT = new Point3D(0, 0, -ROTATION)

    JPanel panel
    double focal
    Scene scene
    Point3D translation
    Point3D rotation
    long frame


    Camera(JPanel panel, Scene scene) {
        this.focal = 300.0
        this.panel = panel
        this.scene = scene
        this.translation = new Point3D(0, 0, 0)
        this.rotation = new Point3D(0, 0, 0)
        this.frame = 0;
    }

    void translate(Point3D vector) {
        translation = translation.add(vector)
        scene.edges = scene.edges.collect { new Edge(it.begin.add(vector), it.end.add(vector), it.color) }
    }

    void zoom(double change) {
        focal += change
        if (focal > FOCAL_MAX) focal = FOCAL_MAX
        if (focal < FOCAL_MIN) focal = FOCAL_MIN
    }

    void rotate(Point3D vector) {
        rotation = rotation.add(vector)
        scene.edges = scene.edges.collect { new Edge(rotate(it.begin, vector), rotate(it.end, vector), it.color) }
    }

    def render() {
        render(scene.edges)
    }

    def render(Edge[] edges) {
        def gfx = panel.graphics
        gfx.setColor(Color.BLACK)
        gfx.fillRect(0, 0, panel.width, panel.height)
        edges.collect { translatePoint(it) }.each {
            if (!(Double.isFinite(it.begin.z) && Double.isFinite(it.end.z)))
                return
            gfx.color = it.color
            gfx.drawLine((int) it.begin.x, (int) it.begin.y, (int) it.end.x, (int) it.end.y);
        }
        debug()
        frame++;
    }

    def debug() {
        def gfx = panel.graphics
        [new Edge(Point3D.ZERO, Point3D.ZERO.add(translation.x, 0, 0), Color.RED),
         new Edge(Point3D.ZERO, Point3D.ZERO.add(0, translation.y, 0), Color.GREEN),
         new Edge(Point3D.ZERO, Point3D.ZERO.add(0, 0, translation.z), Color.BLUE),
        ].collect { translatePoint(it, translation, Point3D.ZERO) }.each {
            if (!(Double.isFinite(it.begin.z) && Double.isFinite(it.end.z)))
                return
            gfx.color = it.color
            gfx.drawLine((int) it.begin.x, (int) it.begin.y, (int) it.end.x, (int) it.end.y);
        }
        println "---- FRAME ${frame} ----"
        println "Translation: [x: ${translation.x}; y: ${translation.y}; z: ${translation.z}]"
        println "Rotation: [x: ${Math.toDegrees(rotation.x) % 360}; y: ${Math.toDegrees(rotation.y) % 360}; z: ${Math.toDegrees(rotation.z) % 360}]"

    }

    private Edge translatePoint(Edge edge3d) {
        translatePoint(edge3d, translation, rotation)
    }

    private Edge translatePoint(Edge edge3d, Point3D translation, Point3D rotation) {
        Point3D windowTranslation = new Point3D(panel.width / 2.0, panel.height / 2.0, 0)
        return new Edge(
                build(edge3d.begin, focal, windowTranslation),
                build(edge3d.end, focal, windowTranslation),
                edge3d.color
        )
    }


    Point3D rotate(Point3D point, Point3D rotation) {
        def x, y, z
        def Point3D p = new Point3D(point.x, point.y, point.z)
        //X axis
        x = p.x
        y = (p.y * Math.cos(rotation.x)) - (p.z * Math.sin(rotation.x))
        z = (p.y * Math.sin(rotation.x)) + (p.z * Math.cos(rotation.x))

        //Y axis
        p = new Point3D(x, y, z)
        x = (p.x * Math.cos(rotation.y)) - (p.z * Math.sin(rotation.y))
        y = p.y
        z = (p.x * Math.sin(rotation.y)) + (p.z * Math.cos(rotation.y))

        //Z axis
        p = new Point3D(x, y, z)
        x = (p.x * Math.cos(rotation.z)) - (p.y * Math.sin(rotation.z))
        y = (p.x * Math.sin(rotation.z)) + (p.y * Math.cos(rotation.z))
        z = p.z

        return new Point3D(x, y, z)
    }

    Point3D translate(Point3D point, Point3D translation) {
        return point.add(translation)
    }

    Point3D build(Point3D point, double focal, Point3D windowTranslation) {
        def mltp = focal / point.z
        def x = mltp * point.x + windowTranslation.x
        def y = windowTranslation.y - mltp * point.y
        return new Point3D(x, y, point.z > 0 ? 0 : Double.NaN)
    }


}
