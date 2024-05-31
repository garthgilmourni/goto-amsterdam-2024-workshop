package org.exercises

import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class DesktopCurrentRuntimeTestRuntimeTest {
    @Test
    fun shouldDetectJVM() {
        val runtime = determineCurrentRuntime()
        assertContains(runtime.name, "OpenJDK")
        assertEquals(runtime.version, "17.0")
    }
}