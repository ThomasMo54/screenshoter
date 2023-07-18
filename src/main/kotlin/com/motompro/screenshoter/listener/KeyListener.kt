package com.motompro.screenshoter.listener

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener
import com.motompro.screenshoter.window.ScreenshotWindow

private val SCREENSHOT_SHORTCUT = setOf(
    NativeKeyEvent.VC_META, // Windows key
    NativeKeyEvent.VC_SHIFT,
    NativeKeyEvent.VC_I,
)

class KeyListener : NativeKeyListener {

    private val pressedKeys = mutableSetOf<Int>()

    override fun nativeKeyPressed(event: NativeKeyEvent) {
        pressedKeys.add(event.keyCode)

        // If screenshot shortcut is done then open screenshot window
        if (pressedKeys.containsAll(SCREENSHOT_SHORTCUT)) {
            ScreenshotWindow()
        }
    }

    override fun nativeKeyReleased(event: NativeKeyEvent) {
        pressedKeys.remove(event.keyCode)
    }
}
