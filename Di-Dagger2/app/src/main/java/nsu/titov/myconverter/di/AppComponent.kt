package nsu.titov.myconverter.di

import android.app.Application
import dagger.Component
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.data.dao.CurrencyDao
import nsu.titov.myconverter.data.mappers.RepositoryInternalMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.CBRApiService
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
import nsu.titov.myconverter.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [AppModule::class, RoomModule::class, RepositoryModule::class])
public interface AppComponent {

    fun inject(application: Application)

    fun getCurrencyListMapper(): CurrencyMapper<Currency, SimpleCurrency>

    fun getConverterMapper(): CurrencyMapper<Currency, ConverterCurrency>

    fun getRepositoryMapper(): RepositoryInternalMapper

    fun getRemoteService(): CBRApiService

    fun getCurrencyDao(): CurrencyDao

    fun getCurrencyDatabase(): CurrencyDatabase

    fun getCurrencyRepository(): CurrencyRepository

    fun getApplication(): Application

}