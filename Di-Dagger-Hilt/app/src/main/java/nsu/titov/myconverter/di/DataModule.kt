package nsu.titov.myconverter.di;

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.data.dao.CurrencyDao
import nsu.titov.myconverter.data.mappers.CurrencyToConverterMapper
import nsu.titov.myconverter.data.mappers.CurrencyToSimpleMapper
import nsu.titov.myconverter.data.mappers.RepositoryInternalMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.CBRApiService
import nsu.titov.myconverter.data.network.RetrofitInstance
import nsu.titov.myconverter.data.repository.CurrencyRepositoryImpl
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.mappers.RepositoryMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
import nsu.titov.myconverter.presentation.Toaster
import nsu.titov.myconverter.ui.AndroidToaster

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository

    @Binds
    abstract fun bindCurrencyListMapper(impl: CurrencyToSimpleMapper): CurrencyMapper<Currency, SimpleCurrency>

    @Binds
    abstract fun bindConverterMapper(impl: CurrencyToConverterMapper): CurrencyMapper<Currency, ConverterCurrency>

    @Binds
    abstract fun bindInternalMapper(impl: RepositoryInternalMapper): RepositoryMapper


   companion object {

       @Provides
       fun provideDatabase(@ApplicationContext applicationContext: Context): CurrencyDatabase {
           return Room.databaseBuilder(
               applicationContext,
               CurrencyDatabase::class.java,
               "CurrencyDatabase"
           ).build()
       }

        @Provides
        fun provideCurrencyDao(currencyDatabase: CurrencyDatabase): CurrencyDao {
            return currencyDatabase.currencyDao()
        }

       @Provides
       fun provideToaster(@ApplicationContext applicationContext: Context): Toaster {
           return AndroidToaster(applicationContext)
       }

       @Provides
       fun provideCBRApi(): CBRApiService {
           return RetrofitInstance().api
       }
   }

}
