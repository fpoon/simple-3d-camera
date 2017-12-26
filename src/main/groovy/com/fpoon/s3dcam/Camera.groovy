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
    static final Point3D TRANSLATION_FORWARD = new Point3D(0, 0, -TRANSLATION)
    static final Point3D TRANSLATION_BACKWARD = new Point3D(0, 0, +TRANSLATION)

    static final Point3D ROTATION_UP = new Point3D(-ROTATION, 0, 0)
    static final Point3D ROTATION_DOWN = new Point3D(+ROTATION, 0, 0)
    static final Point3D ROTATION_LEFT = new Point3D(0, -ROTATION, 0)
    static final Point3D ROTATION_RIGHT = new Point3D(0, +ROTATION, 0)
    static final Point3D ROTATION_Z_LEFT = new Point3D(0, 0, +ROTATION)
    static final Point3D ROTATION_Z_RIGHT = new Point3D(0, 0, -ROTATION)

    JPanel panel
    double focal
    Scene scene
    long frame


    Camera(JPanel panel, Scene scene) {
        this.focal = 300.0
        this.panel = panel
        this.scene = scene
        this.frame = 0;
    }

    void translate(Point3D vector) {
        scene.faces = scene.faces.collect {
            def f = new Face();
            f.edges = it.edges.collect() {
                new Edge(it.begin.add(vector), it.end.add(vector), it.color)
            }
            f.setColor(it.color)
            return f;
        }
    }

    void zoom(double change) {
        focal += change
        if (focal > FOCAL_MAX) focal = FOCAL_MAX
        if (focal < FOCAL_MIN) focal = FOCAL_MIN
    }

    void rotate(Point3D vector) {
        scene.faces = scene.faces.collect {
            def f = new Face();
            f.edges = it.edges.collect() {
                new Edge(rotate(it.begin, vector), rotate(it.end, vector), it.color)
            }
            f.setColor(it.color)
            return f;
        }
    }

    def render() {
        render(scene.faces)
    }

    def render(Face[] faces) {
        def gfx = panel.graphics
        gfx.setColor(Color.BLACK)
        gfx.fillRect(0, 0, panel.width, panel.height)
        faces.collect {
            def face = new Face()
            face.color = it.color
            face.edges = it.edges.collect {
                translatePoint(it)
            }
            return face
        }.each {
            if (it.edges.any {!(Double.isFinite(it.begin.z) && Double.isFinite(it.end.z))})
                return
            gfx.color = it.color
            gfx.fillPolygon(
                    it.edges.collect {(int)it.begin.x}.toArray() as int[],
                    it.edges.collect {(int)it.begin.y}.toArray() as int[],
                    it.edges.length,
            )
            it.edges.each {
                gfx.color = it.color
                gfx.drawLine((int) it.begin.x, (int) it.begin.y, (int) it.end.x, (int) it.end.y);
            }
        }
        frame++;
    }


    private Edge translatePoint(Edge edge3d) {
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

    Point3D build(Point3D point, double focal, Point3D windowTranslation) {
        def mltp = focal / point.z
        def x = mltp * point.x + windowTranslation.x
        def y = windowTranslation.y - mltp * point.y
        return new Point3D(x, y, point.z > 0 ? 0 : Double.NaN)
    }


}
