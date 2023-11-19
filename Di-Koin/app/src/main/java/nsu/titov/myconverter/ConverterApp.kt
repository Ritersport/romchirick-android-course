package nsu.titov.myconverter

import android.app.Application
import nsu.titov.myconverter.di.AppModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ConverterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ConverterApp)
            modules(appModule)
        }
    }
}