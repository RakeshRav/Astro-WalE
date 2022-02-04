package com.example.astro_wale.others

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun isPrevDate(oldDate: Long): Boolean {
        val sdformat = SimpleDateFormat(Constants.DATE_FORMAT)
        val currDate = sdformat.parse(sdformat.format(Date()))
        val prevDate = sdformat.parse(sdformat.format(Date(oldDate)))
        return prevDate < currDate
    }
}