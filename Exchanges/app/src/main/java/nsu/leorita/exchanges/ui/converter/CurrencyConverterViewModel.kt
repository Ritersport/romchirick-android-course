package nsu.leorita.exchanges.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyConverterViewModel : ViewModel() {

    private val _mulResult = MutableLiveData<Float>()
    val mulResult: LiveData<Float> = _mulResult

    fun convert(amount: Float, range: Float?) {
        val result = amount / range!!
        _mulResult.value = result
    }
}