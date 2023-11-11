package nsu.leorita.recycler.ui.view_models

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    fun Disposable.unsubscribeOnCleared() {
        subscriptions.add(this)
    }
    override fun onCleared() {
        subscriptions.dispose()
    }
}