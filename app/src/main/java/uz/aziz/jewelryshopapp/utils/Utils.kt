package uz.aziz.jewelryshopapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Any.log(message: String) {
    Log.d("MyLog", message)
}

fun Any.toast(context: Context, message: String) {
    Toast.makeText(context,  message, Toast.LENGTH_SHORT).show()
}