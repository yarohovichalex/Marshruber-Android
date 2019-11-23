package com.github.yarohovichalex.marshruber.android.driver

import kotlin.test.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object AppDriverTest : Spek({

    val set by memoized { mutableListOf<String>() }

    describe("adding an item") {
        beforeEachTest {
            set.add("item")
        }

        it("should contain item") {
            assertEquals("item", set[0])
        }
    }
})
