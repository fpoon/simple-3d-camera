package com.fpoon.s3dcam

import javafx.geometry.Point3D

import java.awt.Color

class Scene {
    Edge[] edges

    Scene() {
        edges = []

        initEdges()
    }

    def initEdges() {
        def defs = [
                [[-10.0, -10.0, 100.0], [10.0, -10.0, 100.0], Color.RED],
                [[10.0, -10.0, 100.0], [10.0, 10.0, 100.0], Color.RED],
                [[10.0, 10.0, 100.0], [-10.0, 10.0, 100.0], Color.RED],
                [[-10.0, 10.0, 100.0], [-10.0, -10.0, 100.0], Color.RED],

                [[-10.0, -10.0, 120.0], [10.0, -10.0, 120.0], Color.GREEN],
                [[10.0, -10.0, 120.0], [10.0, 10.0, 120.0], Color.GREEN],
                [[10.0, 10.0, 120.0], [-10.0, 10.0, 120.0], Color.GREEN],
                [[-10.0, 10.0, 120.0], [-10.0, -10.0, 120.0], Color.GREEN],

                [[-10.0, -10.0, 120.0], [-10.0, -10.0, 100.0], Color.BLUE],
                [[10.0, -10.0, 120.0], [10.0, -10.0, 100.0], Color.BLUE],
                [[10.0, 10.0, 120.0], [10.0, 10.0, 100.0], Color.CYAN],
                [[-10.0, 10.0, 120.0], [-10.0, 10.0, 100.0], Color.CYAN],
        ]

        defs.each {
            def begin = new Point3D(it[0][0], it[0][1], it[0][2])
            def end   = new Point3D(it[1][0], it[1][1], it[1][2])
            edges += new Edge(begin, end, it[2])
        }

    }
}
