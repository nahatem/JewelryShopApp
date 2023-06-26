package uz.aziz.jewelryshopapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import timber.log.Timber

fun Any.log(message: String) {
    Timber.tag("MyLog").d(message)
}

fun Any.log(tag: String, message: String) {
    Timber.tag(tag).d(message)
}

fun Any.toast(context: Context, message: String) {
    Toast.makeText(context,  message, Toast.LENGTH_SHORT).show()
}