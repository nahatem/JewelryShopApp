package uz.aziz.jewelryshopapp

import android.app.Application
import timber.log.Timber

class JewelryShopApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}