package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Tests unitarios para la función calculateTip.
 *
 * Se prueba la lógica de la función de forma aislada.
 * Los tests verifican que la función maneje correctamente los diferentes
 * casos de los parámetros, como valores positivos, valores negativos,
 * redondeo y el funcionamiento en conjunto cuando se debe de dividir
 * el total con la propina entre múltiples personas
 */
class calculateTipTest {

    /**
     * Test: Cálculo de la propina con un porcentaje de 20% muestra el resultado correcto.
     *
     * Verifica que la función "calculateTip" retorna el resultado
     * esperado cuando tanto el "amount" como el "tipPercent" son positivos.
     */
    @Test
    fun calculationWith20PercentTipShowsCorrectResult(){
        val result = calculateTip(80.0, 20, false)
        assertEquals(16.0,result)
    }

    /**
     * Test: Cálculo de la propina con un porcentaje de 15%
     * y redondeo muestra el resultado correcto.
     *
     * Verifica que la función "calculateTip" retorna el resultado
     * esperado cuando tanto el "amount" como el "tipPercent" son positivos
     * y se aplica el redondeo.
     */
    @Test
    fun calculationWith15PercentTipAndRoundUpShowsCorrectResult(){
        val result = calculateTip(85.0, 15, true)
        assertEquals(13.0,result)
    }

    /**
     * Test: Cálculo de la propina con un "amount" negativo debe dar 0.
     *
     * Verifica el funcionamiento de la función "calculateTip" con un
     * "amount" negativo, aunque esta tendría que retornar un resultado
     * de 0, actualmente solo realiza la operación con el valor negativo
     */
    @Test
    fun calculationWithNegativeInputShows0(){
        val result = calculateTip(-85.0, 15, true)
        assertEquals(0.0,result)
    }

    /**
     * Test: Cálculo del total a pagar por persona, incluyendo propina
     *
     * Verifica que la lógica utilizada para obtener el monto total que
     * debe de pagar cada persona retorna un resultado correcto.
     */
    @Test
    fun calculationForTotalShowsCorrectResult(){
        val bill = 80.0
        val tip = calculateTip(bill, 20, true)
        val numberOfPeople = 3
        val result = (bill + tip) / numberOfPeople

        assertEquals(32.0,result)
    }
}