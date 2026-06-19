package com.example.testeableapp

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

/**
 * Tests de UI para la pantalla de cálculo de propina (TipCalculatorScreen).
 *
 * Utilizan createComposeRule para renderizar el composable de forma
 * aislada sin necesidad de lanzar la Activity completa. Se prueba
 * que TipCalculatorScreen muestre correctamente los cálculos de propina
 * realizados y que la pantalla se actualice al hacer cambios en los datos.
 */
class TipCalculatorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * Test: TipCalculatorScreen redondea la propina y
     * cambia los cálculos al cambiar datos.
     *
     * Verifica el cambio en el valor de la propina cuando
     * se marca la opción de redondeo, además del cálculo
     * de la propina dentro de la interfaz.
     */
    @Test
    fun tipCalculatorScreenTest_roundsUpTipAndValidatesCalculationChange(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        composeTestRule.onNodeWithTag("billInput").performTextInput("10")

        composeTestRule.onNodeWithTag("roundUpTipCheckbox").performClick()

        composeTestRule.onNodeWithText("Propina: $2.00").assertExists()
    }

    /**
     * Test: TipCalculatorScreen cambia el slider del
     * porcentaje de propina y cambia los datos del cálculo.
     *
     * Verifica el cambio en el valor de la propina cuando
     * se modifica el porcentaje de propina con el slider.
     */
    @Test
    fun tipCalculatorScreenTest_changesTipPercentageAndValidatesCalculationChange(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule
            .onNodeWithTag("billInput")
            .performTextInput("10")

        composeTestRule
            .onNodeWithTag("tipSlider")
            .performSemanticsAction(
                SemanticsActions.SetProgress
            ) { it(50f) }

        composeTestRule
            .onNodeWithText("Porcentaje de propina: 50%")
            .assertExists()

        composeTestRule
            .onNodeWithText("Propina: $5.00")
            .assertExists()
    }

    /**
     * Test: TipCalculatorScreen muestra el monto de la cuenta,
     * el porcentaje de propina y el número de personas.
     *
     * Verifica que los textos correspondientes al monto,
     * porcentaje y número de personas sean visibles al
     * renderizar la pantalla
     */
    @Test
    fun tipCalculatorScreenTest_displaysTipData(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule
            .onNodeWithText("Monto de la cuenta")
            .assertExists()

        composeTestRule
            .onNodeWithText("Porcentaje de propina: 15%")
            .assertExists()

        composeTestRule
            .onNodeWithText("Número de personas: 1")
            .assertExists()
    }
}