package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Tests unitarios adicionales para la función calculateTip.
 *
 * Se prueba la lógica de la función de forma aislada.
 * Los tests verifican que la función maneje correctamente los diferentes
 * casos de los parámetros, como valores decimales y el valor de 0.
 */
class AdditionalCalculateTipTest {

    /**
     * Test: Cálculo de la propina con un monto de 0 muestra el resultado correcto.
     *
     * Verifica que la función "calculateTip" retorna el resultado
     * esperado cuando el "amount" tiene un valor de 0, dicho resultado
     * esperado también debe de ser 0.
     */
    @Test
    fun calculationWithAmountAs0ShowsCorrectResult(){
        val result = calculateTip(0.0, 20, false)
        assertEquals(0.0,result)
    }

    /**
     * Test: Cálculo de la propina con un monto decimal muestra el resultado correcto.
     *
     * Verifica que la función "calculateTip" retorna el resultado
     * esperado cuando el "amount" es un valor decimal, tanto en el caso
     * de que se aplique el redondeo y en el que no sea aplicado.
     */
    @Test
    fun calculationWithDecimalAmountShowsCorrectResult(){
        var result = calculateTip(10.20, 15, false)
        assertEquals(1.53,result)

        result = calculateTip(10.20, 15, true)
        assertEquals(2.0,result)
    }
}