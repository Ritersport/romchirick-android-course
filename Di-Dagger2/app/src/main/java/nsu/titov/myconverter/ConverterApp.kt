package nsu.titov.myconverter

import android.app.Application
import android.content.Context
import androidx.room.Room
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.di.AppModule
import nsu.titov.myconverter.di.DaggerAppComponent
import nsu.titov.myconverter.di.RepositoryModule
import nsu.titov.myconverter.di.RoomModule

class ConverterApp : Application() {

    val appComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .repositoryModule(RepositoryModule(this))
        .roomModule(RoomModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()

        databaseInstance = appComponent.getCurrencyDatabase()
    }

    companion object {
        //TODO DI
        lateinit var context: Context

        //TODO DI
        lateinit var databaseInstance: CurrencyDatabase
    }
}