package nsu.leorita.recycler.ui.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nsu.leorita.recycler.domain.AdService
import nsu.leorita.recycler.domain.SongService
import nsu.leorita.recycler.ui.recycler_stuff.delegates.AdDelegate
import nsu.leorita.recycler.ui.recycler_stuff.delegates.Delegate
import nsu.leorita.recycler.ui.recycler_stuff.delegates.SongDelegate
import nsu.leorita.recycler.ui.recycler_stuff.items.AdItem
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem

class ListViewModel(
    private val songService: SongService,
    private val adService: AdService,
) : ViewModel() {

    private val _items = MutableLiveData<List<ListItem>>()
    val items: LiveData<List<ListItem>> = _items

    private val itemsList: MutableList<ListItem> = mutableListOf()

    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private val songsPackSize = 15

    init {
        loadItems()
    }

    fun getDelegates(): List<Delegate> = listOf(
        SongDelegate(),
        AdDelegate(),
    )

    private fun loadItems() {

        songService.getSongs(songsPackSize).map { songs ->
            songs.map {
                SongItem(it.name, it.singer) as ListItem
            }
        }.concatWith(adService.getAd().map {
            it.map { ad ->
                AdItem(ad.category, ad.header, ad.description)
            }
        }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe({ it ->
            modifyItemsList(it)
            _items.postValue(itemsList)
        }, {
            Log.e("error", it.message.toString())
        }).also {
            subscriptions.add(it)
        }
    }

    private fun modifyItemsList(items: List<ListItem>) {
        if (items[0] is SongItem) {
            itemsList.addAll(items)
        }
        if (items[0] is AdItem) {
            itemsList.add(1, items[0])
            itemsList.add(items[1])
        }
    }

}