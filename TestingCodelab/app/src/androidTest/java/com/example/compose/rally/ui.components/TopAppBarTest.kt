package com.example.compose.rally.ui.components

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.compose.rally.RallyScreen
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_currentLabelExists() = with(composeTestRule) {
        val allScreens = RallyScreen.values().toList()
        setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = { },
                    currentScreen = RallyScreen.Accounts
                )
            }
        }

        onRoot().printToLog("currentLabelExists")

        onNode(
    hasText(RallyScreen.Accounts.name.uppercase()) and
            hasParent(
                hasContentDescription(RallyScreen.Accounts.name)
            ),
            useUnmergedTree = true
        ).assertExists()
    }
}