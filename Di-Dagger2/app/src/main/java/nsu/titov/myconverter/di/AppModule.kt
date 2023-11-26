package nsu.titov.myconverter.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import nsu.titov.myconverter.appComponent
import nsu.titov.myconverter.presentation.ConverterViewModel
import nsu.titov.myconverter.presentation.CurrencyListViewModel
import nsu.titov.myconverter.presentation.ViewModelFactory
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class, RoomModule::class, RepModule::class])
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Provides
    fun providesCurrencyVMFactory(): ViewModelFactory =
        ViewModelFactory(
            {
                CurrencyListViewModel(
                    application.appComponent.getCurrencyRepository(),
                    application.appComponent.getToaster()
                )
            },
            {
                ConverterViewModel(
                    application.appComponent.getCurrencyRepository()
                )
            }
        )
}