package com.fpoon.s3dcam

import groovy.swing.SwingBuilder
import groovy.swing.factory.BoxLayoutFactory

import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.WindowConstants
import javax.swing.border.Border
import java.awt.BorderLayout
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Graphics
import java.awt.event.ContainerAdapter
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.WindowEvent
import java.awt.event.WindowStateListener
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.security.Key

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
                        camera.translate(translations[e.keyCode])
                        break
                }
                camera?.render()
            }
        })
        frame.setVisible(true)
        Scene scene = new Scene()
        def renderPanel = swing."renderPanel"
        camera = new Camera(renderPanel, scene)
        camera.render()
    }
}
