package com.example.estadao

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.estadao.di.PresenterModule
import com.example.estadao.repository.di.DatabaseModule
import com.example.estadao.repository.di.RepositoryModule
import com.facebook.stetho.Stetho
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EstadaoApp : Application() {

    private val sharedPreferencesName = BuildConfig.SHARED_PREFERENCES_FILE_NAME

    companion object {
        lateinit var appContext: Context
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()

        JodaTimeAndroid.init(this)
        Stetho.initializeWithDefaults(this)

        /** Set Application Context */
        appContext = applicationContext
        sharedPreferences = appContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

        startKoin {
            androidContext(this@EstadaoApp)
            modules(
                DatabaseModule.modules +
                        RepositoryModule.modules +
                        PresenterModule.modules
            )
        }
    }
}