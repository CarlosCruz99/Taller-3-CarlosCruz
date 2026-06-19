package com.example.testeableapp

import androidx.compose.ui.semantics.SemanticsActions
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
 * Tests de UI adicionales para la pantalla de cálculo de propina (TipCalculatorScreen).
 *
 * Utilizan createComposeRule para renderizar el composable de forma
 * aislada sin necesidad de lanzar la Activity completa. Se prueba
 * que TipCalculatorScreen muestre correctamente los cálculos de propina
 * por cada persona y que los botones de cambios en la cantidad de personas
 * muestren los resultados esperados.
 */
class AdditionalTipCalculatorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * Test: TipCalculatorScreen refleja los cambios de los botones
     * relacionados al número de personas.
     *
     * Verifica el cambio en el valor del número de personas cuando
     * este es aumentado o disminuido por sus botones respectivos.
     */
    @Test
    fun tipCalculatorScreenTest_changesNumberOfPeople(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        repeat(5){
            composeTestRule.onNodeWithTag("morePeopleButton").performClick()
        }

        composeTestRule.onNodeWithText("Número de personas: 6").assertExists()

        composeTestRule.onNodeWithTag("lessPeopleButton").performClick()

        composeTestRule.onNodeWithText("Número de personas: 5").assertExists()
    }

    /**
     * Test: TipCalculatorScreen muestra el total a pagar
     * por persona.
     *
     * Verifica que el cambio en el valor del total a pagar
     * por cada persona se muestre correctamente.
     */
    @Test
    fun tipCalculatorScreenTest_displaysTotalAmountPerPerson(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("billInput")
            .performTextInput("50")

        repeat(4) {
            composeTestRule.onNodeWithTag("morePeopleButton")
                .performClick()
        }

        composeTestRule.onNodeWithText("Número de personas: 5")
            .assertExists()

        composeTestRule.onNodeWithText("Total por persona: $11.50")
            .assertExists()
    }
}