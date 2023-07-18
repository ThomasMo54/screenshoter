package com.motompro.screenshoter.window

import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JPanel
import kotlin.math.max

private val DARK_FILTER_COLOR = Color(20, 20, 20, 100)

class ScreenshotWindowPanel(
    private val screenImage: BufferedImage,
) : JPanel() {

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawImage(screenImage, 0, 0, null)
        g.color = DARK_FILTER_COLOR
        g.fillRect(0, 0, width, height)
    }

    private fun darken(color: Color, darkRate: Double): Color {
        val red = max(0.0, color.red - 255 * darkRate).toInt()
        val green = max(0.0, color.green - 255 * darkRate).toInt()
        val blue = max(0.0, color.blue - 255 * darkRate).toInt()
        return Color(red, green, blue, color.alpha)
    }
}
