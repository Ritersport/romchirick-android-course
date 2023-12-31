package nsu.titov.myconverter.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nsu.titov.myconverter.domain.models.CurrencyRepository
import nsu.titov.myconverter.domain.models.SimpleCurrency
import javax.inject.Inject

class CurrencyListViewModel @Inject constructor(
	private val repository: CurrencyRepository,
	private val toaster: Toaster
) : ViewModel() {


	val currencyData: MutableLiveData<List<SimpleCurrency>> = MutableLiveData()
	private val toasterHandler = CoroutineExceptionHandler { _, exception ->
		toaster.showToast(exception.message)
	}

	fun getCurrencyData() {
		viewModelScope.launch(Dispatchers.IO + toasterHandler) {
			var data = repository.getSimpleCached()
			if (data == null) {
				repository.fetchData()
			}
			withContext(Dispatchers.Main) {
				currencyData.value = repository.getSimpleCached()
			}
		}
	}

	fun forceRefresh() {
		viewModelScope.launch(Dispatchers.IO + toasterHandler) {
			repository.fetchData()
			withContext(Dispatchers.Main) {
				currencyData.value = repository.getSimpleCached()
			}
		}
	}

}