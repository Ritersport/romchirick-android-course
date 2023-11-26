package nsu.titov.myconverter.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.data.dao.CurrencyDao
import javax.inject.Singleton

@Module
class RoomModule(private val application: Application) {

    @Singleton
    @Provides
    fun providesCurrencyDatabase(): CurrencyDatabase {
        return Room.databaseBuilder(
            application,
            CurrencyDatabase::class.java,
            "CurrencyDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun providesCurrencyDao(database: CurrencyDatabase): CurrencyDao {
        return database.currencyDao()
    }

}