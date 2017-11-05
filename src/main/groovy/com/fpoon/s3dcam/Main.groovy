package com.fpoon.s3dcam

import groovy.swing.SwingBuilder
import javafx.geometry.Point3D

import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.WindowConstants
import java.awt.BorderLayout
import java.awt.Color
import java.awt.KeyEventDispatcher
import java.awt.KeyboardFocusManager
import java.awt.event.KeyEvent

class Main {
    static Camera camera;
    static Scene scene = new Scene()

    static void main(String[] args) {
        def swing = new SwingBuilder()

        def reset = {
            scene = new Scene()
            def renderPanel = swing."renderPanel"
            camera = new Camera(renderPanel, scene)
            camera.translate(new Point3D(-370/2, -400, 200))
            camera.rotate(new Point3D(-Math.PI/4, 0, 0))
            camera.render()
        }

        def moveForward = {
            camera?.translate(Camera.TRANSLATION_FORWARD)
            camera?.render()
        }

        def moveBackward = {
            camera?.translate(Camera.TRANSLATION_BACKWARD)
            camera?.render()
        }

        def moveUp = {
            camera?.translate(Camera.TRANSLATION_UP)
            camera?.render()
        }

        def moveDown = {
            camera?.translate(Camera.TRANSLATION_DOWN)
            camera?.render()
        }

        def moveLeft = {
            camera?.translate(Camera.TRANSLATION_LEFT)
            camera?.render()
        }

        def moveRight = {
            camera?.translate(Camera.TRANSLATION_RIGHT)
            camera?.render()
        }

        def rotateUp = {
            camera?.rotate(Camera.ROTATION_UP)
            camera?.render()
        }

        def rotateDown = {
            camera?.rotate(Camera.ROTATION_DOWN)
            camera?.render()
        }

        def rotateLeft = {
            camera?.rotate(Camera.ROTATION_LEFT)
            camera?.render()
        }

        def rotateRight = {
            camera?.rotate(Camera.ROTATION_RIGHT)
            camera?.render()
        }

        def rotateZLeft = {
            camera?.rotate(Camera.ROTATION_Z_LEFT)
            camera?.render()
        }

        def rotateZRight = {
            camera?.rotate(Camera.ROTATION_Z_RIGHT)
            camera?.render()
        }

        def zoomIn = {
            camera?.zoom(Camera.FOCAL_CHANGE)
            camera?.render()
        }

        def zoomOut = {
            camera?.zoom(-Camera.FOCAL_CHANGE)
            camera?.render()
        }

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
                    label(text: "CONTROL PANEL")
                    button(text: "RESET", actionPerformed: reset)
                    panel(
                            minimumSize: [100, -1],
                            border: BorderFactory.createRaisedBevelBorder()
                    ) {
                        boxLayout(axis: BoxLayout.Y_AXIS)
                        label(text: "MOVE CAMERA")
                        button(text: "FORWARD", actionPerformed: moveForward)
                        button(text: "BACKWARD", actionPerformed: moveBackward)
                        button(text: "UP", actionPerformed: moveUp)
                        button(text: "DOWN", actionPerformed: moveDown)
                        button(text: "LEFT", actionPerformed: moveLeft)
                        button(text: "RIGHT", actionPerformed: moveRight)
                    }
                    panel(
                            minimumSize: [100, -1],
                            border: BorderFactory.createRaisedBevelBorder()
                    ) {
                        boxLayout(axis: BoxLayout.Y_AXIS)
                        label(text: "ROTATE CAMERA")
                        button(text: "Z LEFT", actionPerformed: rotateZLeft)
                        button(text: "Z RIGHT", actionPerformed: rotateZRight)
                        button(text: "UP", actionPerformed: rotateUp)
                        button(text: "DOWN", actionPerformed: rotateDown)
                        button(text: "LEFT", actionPerformed: rotateLeft)
                        button(text: "RIGHT", actionPerformed: rotateRight)
                    }
                    panel(
                            minimumSize: [100, -1],
                            border: BorderFactory.createRaisedBevelBorder()
                    ) {
                        boxLayout(axis: BoxLayout.Y_AXIS)
                        label(text: "ZOOM")
                        button(text: "ZOOM IN", actionPerformed: zoomIn)
                        button(text: "ZOOM OUT", actionPerformed: zoomOut)
                    }

                }
                panel(constraints: BorderLayout.CENTER,
                        background: Color.BLACK,
                        id: "renderPanel",
                        componentResized: {camera?.render()})
            }
        }

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() != KeyEvent.KEY_PRESSED) return false
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
                return false;
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
