package br.com.fiap.pokermao

import android.app.Application
import br.com.fiap.pokermao.di.networkModule
import br.com.fiap.pokermao.di.repositoryModule
import br.com.fiap.pokermao.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyAplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start stetho
        Stetho.initializeWithDefaults(this)
// Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyAplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }
    }
