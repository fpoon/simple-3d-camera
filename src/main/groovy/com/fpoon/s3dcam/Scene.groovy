package com.fpoon.s3dcam

import javafx.geometry.Point3D

import java.awt.Color

class Scene {
    Face[] faces

    Scene() {
        faces = []

        initEdges()
    }

    def initEdges() {
        def defs = [
                [
                        edges: [
                                [[0.0, 0.0, 0.0], [50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], [50.0, 120.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], [0.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], [0.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 120.0], [50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], [50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], [0.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], [0.0, 0.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], [0.0, 0.0, 120.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], [50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], [50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], [0.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], [0.0, 0.0, 120.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], [0.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], [0.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], [0.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 0.0], [50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], [50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], [50.0, 120.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], [50.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 120.0, 0.0], [0.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], [50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], [50.0, 120.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], [0.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],

                [
                        edges: [
                                [[0.0, 0.0, 250], [50.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], [50.0, 200, 250], Color.RED],
                                [[50.0, 200, 250], [0.0, 200, 250], Color.RED],
                                [[0.0, 200, 250], [0.0, 0.0, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], [50.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 140], [50.0, 200, 140], Color.RED],
                                [[50.0, 200, 140], [0.0, 200, 140], Color.RED],
                                [[0.0, 200, 140], [0.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], [0.0, 0.0, 250], Color.RED],
                                [[0.0, 0.0, 250], [50.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], [50.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 140], [0.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], [0.0, 0.0, 250], Color.RED],
                                [[0.0, 0.0, 250], [0.0, 200, 250], Color.RED],
                                [[0.0, 200, 250], [0.0, 200, 140], Color.RED],
                                [[0.0, 200, 140], [0.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 140], [50.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], [50.0, 200, 250], Color.RED],
                                [[50.0, 200, 250], [50.0, 200, 140], Color.RED],
                                [[50.0, 200, 140], [50.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 200, 140], [0.0, 200, 250], Color.RED],
                                [[0.0, 200, 250], [50.0, 200, 250], Color.RED],
                                [[50.0, 200, 250], [50.0, 200, 140], Color.RED],
                                [[50.0, 200, 140], [0.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],

                [
                        edges: [
                                [[60.0, 0.0, 0], [60.0, 0.0, 250], new Color(0x77, 0x77, 0x77)],
                                [[60.0, 0.0, 250], [250.0, 0, 250], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 250], [250, 0, 0], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 0], [60.0, 0.0, 0], new Color(0x77, 0x77, 0x77)],
                        ],
                        color: Color.WHITE
                ],

                [
                        edges: [
                                [[260, 0, 140], [260, 0, 250], Color.YELLOW],
                                [[260, 0, 250], [370, 0, 250], Color.YELLOW],
                                [[370, 0, 250], [370, 0, 140], Color.YELLOW],
                                [[370, 0, 140], [260, 0, 140], Color.YELLOW],
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[260, 0, 140], [305, 150, 195], Color.YELLOW],
                                [[305, 150, 195], [260, 0, 250], Color.YELLOW],
                                [[260, 0, 250], [260, 0, 140], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[260, 0, 250], [305, 150, 195], Color.YELLOW],
                                [[305, 150, 195], [370, 0, 250], Color.YELLOW],
                                [[370, 0, 250], [260, 0, 250], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[370, 0, 250], [305, 150, 195], Color.YELLOW],
                                [[305, 150, 195], [370, 0, 140], Color.YELLOW],
                                [[370, 0, 140], [370, 0, 250], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[370, 0, 140], [305, 150, 195], Color.YELLOW],
                                [[305, 150, 195], [260, 0, 140], Color.YELLOW],
                                [[260, 0, 140], [370, 0, 140], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],

                [
                        edges: [
                                [[260, 0.0, 0], [370.0, 0.0, 0], Color.BLUE],
                                [[370.0, 0.0, 0], [370.0, 120.0, 0], Color.BLUE],
                                [[370.0, 120.0, 0], [260, 80.0, 0], Color.BLUE],
                                [[260, 80.0, 0], [260, 0.0, 0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 120.0], [370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], [370.0, 120.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], [260, 80.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], [260, 0.0, 120.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff),
                ],

                [
                        edges: [
                                [[260, 0.0, 0.0], [260, 0.0, 120.0], Color.BLUE],
                                [[260, 0.0, 120.0], [370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], [370.0, 0.0, 0.0], Color.BLUE],
                                [[370.0, 0.0, 0.0], [260, 0.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], [260, 0.0, 120.0], Color.BLUE],
                                [[260, 0.0, 120.0], [260, 80.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], [260, 80.0, 0.0], Color.BLUE],
                                [[260, 80.0, 0.0], [260, 0.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[370.0, 0.0, 0.0], [370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], [370.0, 120, 120.0], Color.BLUE],
                                [[370.0, 120, 120.0], [370.0, 120, 0.0], Color.BLUE],
                                [[370.0, 120, 0.0], [370.0, 0.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 80.0, 0.0], [260, 80.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], [370.0, 120.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], [370.0, 120.0, 0.0], Color.BLUE],
                                [[370.0, 120.0, 0.0], [260, 80.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ]
        ]

        defs.each {
            def edges = []
            it['edges'].each {
                def begin = new Point3D(it[0][0], it[0][1], it[0][2])
                def end = new Point3D(it[1][0], it[1][1], it[1][2])
                edges += new Edge(begin, end, it[2])
            }
            def face = new Face();
            face.edges = edges
            face.color = it['color'];
            faces += face;
        }
    }
}
