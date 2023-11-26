package nsu.titov.myconverter.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import nsu.titov.myconverter.data.mappers.CurrencyToConverterMapper
import nsu.titov.myconverter.data.mappers.CurrencyToSimpleMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.CBRApiService
import nsu.titov.myconverter.data.network.RetrofitInstance
import nsu.titov.myconverter.data.repository.CurrencyRepositoryImpl
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
import nsu.titov.myconverter.presentation.Toaster
import nsu.titov.myconverter.ui.AndroidToaster

@Module
class RepositoryModule() {

    @Provides
    fun provideRemoteService(): CBRApiService = RetrofitInstance().api

    @Provides
    fun providesCurrencyListMapper(): CurrencyMapper<Currency, SimpleCurrency> = CurrencyToSimpleMapper()

    @Provides
    fun providesCurrencyConverterMapper(): CurrencyMapper<Currency, ConverterCurrency> = CurrencyToConverterMapper()


}

@Module
abstract class RepModule() {
    @Binds
    abstract fun bindRepository(impl: CurrencyRepositoryImpl): CurrencyRepository

    @Binds
    abstract fun bindToaster(impl: AndroidToaster): Toaster
}