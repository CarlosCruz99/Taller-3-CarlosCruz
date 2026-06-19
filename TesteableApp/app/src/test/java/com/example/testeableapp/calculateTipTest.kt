package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import kotlin.test.Test
import kotlin.test.assertEquals

class calculateTipTest {
    @Test
    fun calculationWith20PercentTipShowsCorrectResult(){
        val result = calculateTip(80.0, 20, false)
        assertEquals(16.0,result)
    }

    @Test
    fun calculationWith15PercentTipAndRoundUpShowsCorrectResult(){
        val result = calculateTip(85.0, 15, true)
        assertEquals(13.0,result)
    }

    @Test
    fun calculationWithNegativeInputShows0(){
        val result = calculateTip(-85.0, 15, true)
        assertEquals(0.0,result)
    }

    @Test
    fun calculationForTotalShowsCorrectResult(){
        val bill = 80.0
        val tip = calculateTip(bill, 20, true)
        val numberOfPeople = 3
        val result = (bill + tip) / numberOfPeople

        assertEquals(32.0,result)
    }
}