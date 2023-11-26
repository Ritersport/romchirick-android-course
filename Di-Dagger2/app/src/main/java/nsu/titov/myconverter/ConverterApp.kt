package nsu.titov.myconverter

import android.app.Application
import android.content.Context
import nsu.titov.myconverter.di.AppComponent
import nsu.titov.myconverter.di.AppModule
import nsu.titov.myconverter.di.DaggerAppComponent
import nsu.titov.myconverter.di.RepositoryModule
import nsu.titov.myconverter.di.RoomModule

class ConverterApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .repositoryModule(RepositoryModule())
            .roomModule(RoomModule(this))
            .build()

    }

}
val Context.appComponent: AppComponent
    get() = when(this) {
        is ConverterApp -> appComponent
        else -> this.applicationContext.appComponent
    }
