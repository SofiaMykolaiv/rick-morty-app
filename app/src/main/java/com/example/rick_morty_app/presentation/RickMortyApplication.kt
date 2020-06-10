package com.example.rick_morty_app.presentation

import android.app.Application
import com.example.rick_morty_app.di.networkModule
import com.example.rick_morty_app.di.repositoryModule
import com.example.rick_morty_app.di.serviceModule
import com.example.rick_morty_app.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RickMortyApplication : Application() {

    companion object {
        lateinit var sInstance: RickMortyApplication
            private set

        val getAppInstance: RickMortyApplication
            get() = sInstance
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Stetho.initializeWithDefaults(this@RickMortyApplication)
        Timber.plant(Timber.DebugTree())
        setKoin()
    }

    private fun setKoin() = startKoin {
        androidContext(this@RickMortyApplication)
        modules(
            listOf(
                viewModelModule,
                repositoryModule,
                networkModule,
                serviceModule
//                databaseModule,
//                daoModule
            )
        )
    }
}