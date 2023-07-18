package com.motompro.screenshoter.window

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

class ScreenshotWindow : JFrame(), KeyListener {

    private lateinit var panel: ScreenshotWindowPanel

    init {
        // Capture screen
        val screenDimension = Toolkit.getDefaultToolkit().screenSize
        val screenImage = Robot().createScreenCapture(Rectangle(screenDimension.width, screenDimension.height))
        // Set fullscreen
        extendedState = MAXIMIZED_BOTH
        isUndecorated = true
        // Set panel
        panel = ScreenshotWindowPanel(screenImage)
        contentPane = panel
        // Register key listener
        addKeyListener(this)

        isVisible = true
        toFront()
    }

    override fun keyPressed(event: KeyEvent) {
        if (event.keyCode == KeyEvent.VK_ESCAPE) dispose()
    }

    override fun keyTyped(event: KeyEvent) {}
    override fun keyReleased(event: KeyEvent) {}
}
