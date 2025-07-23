package com.example.myassssmentapplication

import org.junit.Assert.*
import org.junit.Test

class DashboardItemTest {

    @Test
    fun testDashboardItemProperties() {
        val item = DashboardItem(
            name = "Zeus",
            culture = "Greek",
            domain = "Sky and Thunder",
            symbol = "Thunderbolt",
            parentage = "Cronus and Rhea",
            romanEquivalent = "Jupiter",
            description = "King of the Olympian gods..."
        )

        assertEquals("Zeus", item.name)
        assertEquals("Greek", item.culture)
        assertEquals("Thunderbolt", item.symbol)
    }
}
