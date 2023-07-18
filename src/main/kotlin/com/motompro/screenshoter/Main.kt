package com.motompro.screenshoter

import com.github.kwhat.jnativehook.GlobalScreen
import com.motompro.screenshoter.listener.KeyListener

fun main() {
    // Register key listener
    GlobalScreen.registerNativeHook()
    GlobalScreen.addNativeKeyListener(KeyListener())
}
