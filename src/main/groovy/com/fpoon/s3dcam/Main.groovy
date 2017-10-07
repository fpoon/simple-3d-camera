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

class Main {
    static void main(String[] args) {
        def builder = new SwingBuilder();

        def frame = builder.frame(
                title: "Simple 3D camera",
                size: [400, 400],
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
                panel(constraints: BorderLayout.CENTER, background: Color.BLACK, id: "RENDER_PANEL")
            }
        }

        frame.setVisible(true);
    }
}
