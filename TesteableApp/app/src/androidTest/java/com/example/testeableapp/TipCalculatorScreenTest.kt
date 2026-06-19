package com.example.testeableapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class TipCalculatorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tipCalculatorScreenTest_roundsUpTipAndValidatesCalculationChange(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        //composeTestRule.onNodeWithText("Monto de la cuenta").
    }
}