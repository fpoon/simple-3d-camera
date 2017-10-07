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

class Main {
    static void main(String[] args) {
        def swing = new SwingBuilder()

        def frame = swing.frame(
                title: "Simple 3D camera",
                size: [600, 400],
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
                    button(text: "RESET")

                }
                panel(constraints: BorderLayout.CENTER, background: Color.BLACK, id: "renderPanel")
            }
        }
        frame.setVisible(true);
        Camera camera = new Camera(swing."renderPanel")
        camera.edges.add(new Edge(new Point(10, 20), new Point(150, 40)))
        camera.edges.add(new Edge(new Point(10, 20), new Point(15, 40)))
        camera.edges.add(new Edge(new Point(100, 20), new Point(150, 4)))
        camera.draw()
    }
}
