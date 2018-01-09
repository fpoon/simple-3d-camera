package com.fpoon.s3dcam

import javafx.geometry.Point3D

import java.awt.Color

class Scene {
    static DEPTH = 2
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
                                [[50.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN]
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[0.0, 0.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],[
                        edges: [
                                [[0.0, 0.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                                [[0.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 0.0], Color.GREEN],
                                [[50.0, 0.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 120.0, 0.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 0.0], Color.GREEN],
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 120.0, 0.0], Color.GREEN],
                                [[0.0, 120.0, 120.0], Color.GREEN],
                                [[50.0, 120.0, 120.0], Color.GREEN]
                        ],
                        color: new Color(0x77, 0xff, 0x77)
                ],

                [
                        edges: [
                                [[0.0, 0.0, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                                [[0.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 140], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[0.0, 0.0, 250], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                                [[0.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 0.0, 140], Color.RED],
                                [[0.0, 0.0, 250], Color.RED],
                                [[0.0, 200, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 140], Color.RED],
                                [[50.0, 0.0, 250], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[50.0, 0.0, 140], Color.RED],
                                [[50.0, 200, 250], Color.RED],
                                [[50.0, 200, 140], Color.RED],
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],
                [
                        edges: [
                                [[0.0, 200, 140], Color.RED],
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
                        ],
                        color: new Color(0xff, 0x77, 0x77)
                ],

                [
                        edges: [
                                [[60.0, 0.0, 0], new Color(0x77, 0x77, 0x77)],
                                [[60.0, 0.0, 250], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 250], new Color(0x77, 0x77, 0x77)],
                        ],
                        color: Color.WHITE
                ],
                [
                        edges: [
                                [[60.0, 0.0, 0], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 250], new Color(0x77, 0x77, 0x77)],
                                [[250.0, 0, 0], new Color(0x77, 0x77, 0x77)],
                        ],
                        color: Color.WHITE
                ],

                [
                        edges: [
                                [[260, 0, 140], Color.YELLOW],
                                [[370, 0, 250], Color.YELLOW],
                                [[370, 0, 140], Color.YELLOW],
                        ],
                        color: new Color(0xff, 0xff, 0x77)
                ],
                [
                        edges: [
                                [[260, 0, 140], Color.YELLOW],
                                [[260, 0, 250], Color.YELLOW],
                                [[370, 0, 250], Color.YELLOW],
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
                                [[370.0, 120.0, 0], Color.BLUE]
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0], Color.BLUE],
                                [[370.0, 120.0, 0], Color.BLUE],
                                [[260, 80.0, 0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff),
                ],
                [
                        edges: [
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE]
                        ],
                        color: new Color(0x77, 0x77, 0xff),
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[370.0, 0.0, 120.0], Color.BLUE]
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
                                [[260, 0.0, 120.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 0.0, 0.0], Color.BLUE],
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
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[370.0, 0.0, 0.0], Color.BLUE],
                                [[370.0, 120, 120.0], Color.BLUE],
                                [[370.0, 120, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 80.0, 0.0], Color.BLUE],
                                [[260, 80.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE]
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ],
                [
                        edges: [
                                [[260, 80.0, 0.0], Color.BLUE],
                                [[370.0, 120.0, 120.0], Color.BLUE],
                                [[370.0, 120.0, 0.0], Color.BLUE],
                        ],
                        color: new Color(0x77, 0x77, 0xff)
                ]
        ]

        defs = defs.collectMany {
            splitTriangle(pfl(it['edges'][0][0]), pfl(it['edges'][1][0]), pfl(it['edges'][2][0]), it['color'], it['edges'][0][1], DEPTH)
        }

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

    Point3D pfl(list) {
        return new Point3D(list[0] as double, list[1] as double, list[2] as double)
    }

    def splitTriangle(Point3D v1, Point3D v2, Point3D v3, fill, color, depth) {
        def ret = []

        if (depth == 0) {
            ret += [
                    edges: [
                            [[v1.x, v1.y, v1.z], color],
                            [[v2.x, v2.y, v2.z], color],
                            [[v3.x, v3.y, v3.z], color]
                            ],
                    color: fill
                    ]
            return ret;
        }

        def v1v2 = v1.midpoint(v2)
        def v2v3 = v2.midpoint(v3)
        def v3v1 = v3.midpoint(v1)

        ret = ret + splitTriangle(v1, v1v2, v3v1, fill, color, depth-1)
        ret = ret + splitTriangle(v2, v2v3, v1v2, fill, color, depth-1)
        ret = ret + splitTriangle(v3, v3v1, v2v3, fill, color, depth-1)
        ret = ret + splitTriangle(v1v2, v2v3, v3v1, fill, color, depth-1)

        return ret
    }
}
