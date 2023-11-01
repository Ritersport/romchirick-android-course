package nsu.leorita.recycler.ui.view_models

import androidx.lifecycle.ViewModel
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

    private val songsPackSize = 15
    fun getDelegates(): List<Delegate> =
        listOf(
            SongDelegate(),
            AdDelegate(),
        )

    fun getItems(): List<ListItem> {
        val songs: List<ListItem> = songService.getSongs(songsPackSize).map {
            SongItem(it.name, it.singer)
        }
        val ads = adService.getAds().map {
            AdItem(it.category, it.header, it.description)
        }
        return songs + ads
    }

}