package nsu.titov.myconverter.di

import android.app.Application
import androidx.fragment.app.Fragment
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
import nsu.titov.myconverter.presentation.Toaster
import nsu.titov.myconverter.presentation.ViewModelFactory
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: Fragment)

    fun viewModelsFactory(): ViewModelFactory

    fun getCurrencyListMapper(): CurrencyMapper<Currency, SimpleCurrency>

    fun getConverterMapper(): CurrencyMapper<Currency, ConverterCurrency>

    fun getRepositoryMapper(): RepositoryInternalMapper

    fun getRemoteService(): CBRApiService

    fun getCurrencyDao(): CurrencyDao

    fun getCurrencyDatabase(): CurrencyDatabase

    fun getCurrencyRepository(): CurrencyRepository

    fun getToaster(): Toaster

    fun getApplication(): Application

}