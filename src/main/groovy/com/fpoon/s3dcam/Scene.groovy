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
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],

                [
                        edges: [
                                [[0.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 140], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                                [[0.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[0.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[0.0, 0.0, 250], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                                [[0.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 200, 140], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],

                [
                        edges: [
                                [[60.0, 0.0, 0], new Color(0x77, 0x77, 0x77)],
                                [[60.0, 0.0, 250], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 250], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 0], new Color(0x77, 0x77, 0x77)],
                        ],
                        color: Color.WHITE
                ],

                [
                        edges: [
                                [[260, 0, 140], Color.YELLOW],
                                [[260, 0, 250], Color.YELLOW],
                                [[370, 0, 250], Color.YELLOW],
                                [[370, 0, 140], Color.YELLOW],
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[260, 0, 140], Color.YELLOW],
                                [[305, 150, 195], Color.YELLOW],
                                [[260, 0, 250], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[260, 0, 250], Color.YELLOW],
                                [[305, 150, 195], Color.YELLOW],
                                [[370, 0, 250], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[370, 0, 250], Color.YELLOW],
                                [[305, 150, 195], Color.YELLOW],
                                [[370, 0, 140], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[370, 0, 140], Color.YELLOW],
                                [[305, 150, 195], Color.YELLOW],
                                [[260, 0, 140], Color.YELLOW]
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],

                [
                        edges: [
                                [[260, 0.0, 0], Color.BLUE],
                                [[370.0, 0.0, 0], Color.BLUE],
                                [[370.0, 120.0, 0], Color.BLUE],
                                [[260, 80.0, 0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff),
                ],

                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                                [[260, 80.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[370.0, 0.0, 0.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 120, 120.0], Color.BLUE],
                                [[370.0, 120, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 80.0, 0.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ]
        ]

        defs.each {
            def edges = []
            it['edges'].eachWithIndex { v, idx ->
                def begin = new Point3D(v[0][0], v[0][1], v[0][2])
                def end
                if (idx < it['edges'].size()-1)
                    end = new Point3D(it['edges'][idx+1][0][0], it['edges'][idx+1][0][1], it['edges'][idx+1][0][2])
                else
                    end = new Point3D(it['edges'][0][0][0], it['edges'][0][0][1], it['edges'][0][0][2])
                edges += new Edge(begin, end, v[1])
            }
            def face = new Face();
            face.edges = edges
            face.color = it['color'];
            faces += face;
        }
    }
}
