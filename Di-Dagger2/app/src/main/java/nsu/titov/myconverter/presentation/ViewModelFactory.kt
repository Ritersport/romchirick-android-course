package nsu.titov.myconverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    currencyListVMProvider: Provider<CurrencyListViewModel>,
    converterVMProvider: Provider<ConverterViewModel>,
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        CurrencyListViewModel::class.java to currencyListVMProvider,
        ConverterViewModel::class.java to converterVMProvider,
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return providers[modelClass]!!.get() as T
    }
}

