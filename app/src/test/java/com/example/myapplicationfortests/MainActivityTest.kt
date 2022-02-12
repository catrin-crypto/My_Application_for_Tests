package com.example.myapplicationfortests

import org.junit.Assert
import org.junit.Test

class MainActivityTest {
    @Test
    fun testAssertArrayEquals() {
        Assert.assertArrayEquals(
            "assertArrayEquals failed!",
            MainActivity.generateArray(),
            MainActivity.generateArray(), 0.1
        )
    }

    @Test
    fun testAssertArrayEqualsFailed() {
        Assert.assertArrayEquals(
            "assertArrayEquals failed!",
            MainActivity.generateArray(),
            MainActivity.generateArray(0.5), 0.1
        )
    }

    @Test
    fun testAssertEquals() {
        Assert.assertEquals(
            "Equal string",
            MainActivity.originalStringBuilderInstance.toString(),
            MainActivity.stringBuilderCopiedInstance.toString()
        )
    }

    @Test
    fun testAssertNotEquals() {
        Assert.assertNotEquals(
            "Strings are not equal",
            MainActivity.nullableString,
            MainActivity.stringBuilderCopiedInstance.toString()
        )
    }

    @Test
    fun testAssertNull() {
        Assert.assertNull("Null", MainActivity.nullableString)
    }

    @Test
    fun testAssertNotNull() {
        Assert.assertNotNull("Not null", MainActivity.originalStringBuilderInstance)
    }

    @Test
    fun testAssertSame() {
        Assert.assertSame(
            "Same",
            MainActivity.originalStringBuilderInstance,
            MainActivity.sameStringBuilder
        )
    }

    @Test
    fun assertNotSame() {
        Assert.assertNotSame(
            "Not same",
            MainActivity.originalStringBuilderInstance,
            MainActivity.stringBuilderCopiedInstance
        )
    }
}