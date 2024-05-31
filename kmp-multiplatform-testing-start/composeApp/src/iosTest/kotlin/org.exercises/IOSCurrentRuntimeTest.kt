package org.exercises

import kotlin.test.Test
import kotlin.test.assertEquals

class IOSCurrentRuntimeTest {
    @Test
    fun shouldDetectOS() {
        val runtime = determineCurrentRuntime()
        assertEquals(runtime.name, "ios")
        assertEquals(runtime.version, "unknown")
    }
}