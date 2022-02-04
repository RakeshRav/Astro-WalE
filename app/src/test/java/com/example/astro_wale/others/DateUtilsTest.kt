package com.example.astro_wale.others

import com.google.common.truth.Truth
import org.junit.Test

class DateUtilsTest {

    /**
    testing isPrevDate(oldDate: Long)
    1. passing today's date return false
     3. passsing future date returns false
    2. passing yesterday's date retruns true
     */
    @Test
    fun `passing today's date return false`(){
        val result = DateUtils.isPrevDate(System.currentTimeMillis())
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `passing yesterday's date return true`(){
        val result = DateUtils.isPrevDate(System.currentTimeMillis()-(24*60*60*1000))
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun `passing tomorrow's date return false`(){
        val result = DateUtils.isPrevDate(System.currentTimeMillis()+(24*60*60*1000))
        Truth.assertThat(result).isFalse()
    }
}