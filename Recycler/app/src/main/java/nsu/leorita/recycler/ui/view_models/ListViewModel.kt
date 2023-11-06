package nsu.leorita.recycler.ui.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nsu.leorita.recycler.domain.AdService
import nsu.leorita.recycler.domain.SongService
import nsu.leorita.recycler.ui.recycler_stuff.items.AdItem
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem
import java.lang.Thread.sleep

private const val SONGS_PACK_SIZE = 15

class ListViewModel(
    private val songService: SongService,
    private val adService: AdService,
) : BaseViewModel() {

    private val _items = MutableLiveData<List<ListItem>>()
    val items: LiveData<List<ListItem>> = _items

    init {
        val songs = getSongs(SONGS_PACK_SIZE)
        val ads = getAds()
        val items = getItems(songs, ads)
        val o = Observable.create { emitter ->
            emitter.onNext(songs)
            sleep(5000)
            emitter.onNext(items)
            sleep(5000)
            emitter.onNext(emptyList<ListItem>())
        }
        loadItems(o)
    }

    private fun loadItems(o: Observable<List<ListItem>>) {

        o.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                _items.value = it
            }, {
                Log.e("error", it.message.toString())
            }).unsubscribeOnCleared()
    }


    private fun getSongs(count: Int): List<SongItem> {
        val singers = listOf(
            "Rita",
            "Roma",
            "Komsomolsk",
            "SBPCH",
            "Mitski",
            "KICA8bit",
        )
        val songs = listOf(
            "hehehoho",
            "hihihaha",
            "Sodade",
            "Na dva",
            "Why didn't you stop me?",
            "MrrrMeow",
        )
        val items = mutableListOf<SongItem>()
        for (i: Int in 0..<count) {
            items.add(i, SongItem(songs.random(), singers.random()))
        }
        return items
    }

    private fun getAds(): List<AdItem> {
        return listOf(
            AdItem("Technology", "Twitter is X now", "What a stupid rebranding"),
            AdItem("Animals", "Kot Mer", "Cool as fuck"),
        )
    }

    private fun getItems(songs: List<SongItem>, ads: List<AdItem>): List<ListItem> {
        val items = mutableListOf<ListItem>()
        for (s in songs) {
            items.add(s)
        }
        items.add(1, ads[0])
        items.add(ads[1])
        return items
    }

}