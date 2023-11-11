package nsu.titov.myconverter.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import nsu.titov.myconverter.data.mappers.CurrencyToConverterMapper
import nsu.titov.myconverter.data.mappers.CurrencyToSimpleMapper
import nsu.titov.myconverter.data.mappers.RepositoryInternalMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.CBRApiService
import nsu.titov.myconverter.data.network.RetrofitInstance
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.SimpleCurrency
import nsu.titov.myconverter.presentation.Toaster
import nsu.titov.myconverter.ui.AndroidToaster

@Module
class RepositoryModule(private val application: Application) {

    @Provides
    fun providesCurrencyListMapper(): CurrencyMapper<Currency, SimpleCurrency> =
        CurrencyToSimpleMapper()

    @Provides
    fun providesConverterMapper(): CurrencyMapper<Currency, ConverterCurrency> =
        CurrencyToConverterMapper()


    @Provides
    fun provideRepositoryMapper(): RepositoryInternalMapper = RepositoryInternalMapper()

    @Provides
    fun provideRemoteService(): CBRApiService = RetrofitInstance().api

    @Provides
    fun provideToaster(): Toaster = AndroidToaster(application)
}