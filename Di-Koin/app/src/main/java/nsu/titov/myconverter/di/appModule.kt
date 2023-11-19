package nsu.titov.myconverter.di

import androidx.room.Room
import nsu.titov.myconverter.data.CurrencyDatabase
import nsu.titov.myconverter.data.mappers.CurrencyToConverterMapper
import nsu.titov.myconverter.data.mappers.CurrencyToSimpleMapper
import nsu.titov.myconverter.data.mappers.RepositoryInternalMapper
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.network.RetrofitInstance
import nsu.titov.myconverter.data.repository.CurrencyRepositoryImpl
import nsu.titov.myconverter.domain.mappers.CurrencyMapper
import nsu.titov.myconverter.domain.models.ConverterCurrency
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
import nsu.titov.myconverter.presentation.ConverterViewModel
import nsu.titov.myconverter.presentation.CurrencyListViewModel
import nsu.titov.myconverter.presentation.Toaster
import nsu.titov.myconverter.ui.AndroidToaster
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModule {
    val appModule = module {

        single {
            Room.databaseBuilder(
                androidContext(),
                CurrencyDatabase::class.java,
                "CurrencyDatabase"
            ).build()
        }

        viewModel { ConverterViewModel(get()) }
        viewModel { CurrencyListViewModel(get(), get()) }

        factory<CurrencyMapper<Currency, SimpleCurrency>>(named("toSimple")) { CurrencyToSimpleMapper() }
        factory<CurrencyMapper<Currency, ConverterCurrency>>(named("toConverter")) { CurrencyToConverterMapper() }
        factory { RetrofitInstance().api }
        factory<Toaster> { AndroidToaster(androidContext()) }

        factory<CurrencyRepository> {
            CurrencyRepositoryImpl(
                currencyListMapper = get(qualifier = named("toSimple")),
                converterMapper = get(qualifier = named("toConverter")),
                internalMapper = RepositoryInternalMapper(),
                localStorage = get<CurrencyDatabase>().currencyDao(),
                remoteService = get(),
            )
        }

    }
}