package com.codekul.GrapprApp.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pooja on 5/1/18.
 */
class DateFormat {
    fun getFormatedDate(dateInMillies: Long?): String {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        return simpleDateFormat.format(Date(dateInMillies!!))
    }
}