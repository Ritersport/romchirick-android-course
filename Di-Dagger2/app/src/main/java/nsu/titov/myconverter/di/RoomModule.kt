package nsu.titov.myconverter.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.data.dao.CurrencyDao
import nsu.titov.myconverter.data.mappers.RepositoryInternalMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.CBRApiService
import nsu.titov.myconverter.data.repository.CurrencyRepositoryImpl
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
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

    @Singleton
    @Provides
    fun providesCurrencyRepository(
        currencyListMapper: CurrencyMapper<Currency, SimpleCurrency>,
        converterMapper: CurrencyMapper<Currency, ConverterCurrency>,
        internalMapper: RepositoryInternalMapper,
        currencyDao: CurrencyDao,
        remoteService: CBRApiService,
    ): CurrencyRepository =
        CurrencyRepositoryImpl(
            currencyListMapper,
            converterMapper,
            internalMapper,
            currencyDao,
            remoteService,
    )
}