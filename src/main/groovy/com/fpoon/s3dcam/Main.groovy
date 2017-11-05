package com.fpoon.s3dcam

import groovy.swing.SwingBuilder
import javafx.geometry.Point3D

import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.WindowConstants
import java.awt.BorderLayout
import java.awt.Color
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

class Main {
    static Camera camera;

    static void main(String[] args) {
        def swing = new SwingBuilder()

        def frame = swing.frame(
                title: "Simple 3D camera",
                size: [800, 600],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ) {
            panel(layout: new BorderLayout()) {
                panel(
                      constraints: BorderLayout.EAST,
                      minimumSize: [100, -1],
                      border: BorderFactory.createRaisedBevelBorder()
                     ) {
                    boxLayout(axis:BoxLayout.Y_AXIS)
                    label(text: "SIMPLE 3D CAMERA")
                    //button(text: "RESET")

                }
                panel(constraints: BorderLayout.CENTER,
                        background: Color.BLACK,
                        id: "renderPanel",
                        componentResized: {camera?.render()})
            }
        }
        frame.addKeyListener(new KeyAdapter() {
            @Override
            void keyPressed(KeyEvent e) {
                switch (e.keyCode) {
                    case {it in [KeyEvent.VK_UP,
                                 KeyEvent.VK_DOWN,
                                 KeyEvent.VK_LEFT,
                                 KeyEvent.VK_RIGHT,
                                 KeyEvent.VK_W,
                                 KeyEvent.VK_S
                                ]}:
                        def translations = [(KeyEvent.VK_UP): Camera.TRANSLATION_UP,
                                            (KeyEvent.VK_DOWN): Camera.TRANSLATION_DOWN,
                                            (KeyEvent.VK_LEFT): Camera.TRANSLATION_LEFT,
                                            (KeyEvent.VK_RIGHT): Camera.TRANSLATION_RIGHT,
                                            (KeyEvent.VK_W): Camera.TRANSLATION_FORWARD,
                                            (KeyEvent.VK_S): Camera.TRANSLATION_BACKWARD
                                        ]
                        camera?.translate(translations[e.keyCode])
                        break
                    case e.VK_ADD:
                        camera?.zoom(Camera.FOCAL_CHANGE)
                        break
                    case KeyEvent.VK_SUBTRACT:
                        camera?.zoom(-Camera.FOCAL_CHANGE)
                        break
                    case KeyEvent.VK_NUMPAD8:
                        camera?.rotate(Camera.ROTATION_UP)
                        break
                    case KeyEvent.VK_NUMPAD2:
                        camera?.rotate(Camera.ROTATION_DOWN)
                        break
                    case KeyEvent.VK_NUMPAD4:
                        camera?.rotate(Camera.ROTATION_LEFT)
                        break
                    case KeyEvent.VK_NUMPAD6:
                        camera?.rotate(Camera.ROTATION_RIGHT)
                        break
                    case KeyEvent.VK_NUMPAD7:
                        camera?.rotate(Camera.ROTATION_Z_LEFT)
                        break
                    case KeyEvent.VK_NUMPAD9:
                        camera?.rotate(Camera.ROTATION_Z_RIGHT)
                        break
                }
                camera?.render()
            }
        })

        frame.setVisible(true)
        Scene scene = new Scene()
        def renderPanel = swing."renderPanel"
        camera = new Camera(renderPanel, scene)
        camera.translate(new Point3D(-370/2, -400, 200))
        camera.rotate(new Point3D(-Math.PI/4, 0, 0))
        camera.render()
    }
}
