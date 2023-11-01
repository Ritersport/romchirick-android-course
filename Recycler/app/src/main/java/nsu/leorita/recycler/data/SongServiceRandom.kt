package nsu.leorita.recycler.data

import nsu.leorita.recycler.domain.Song
import nsu.leorita.recycler.domain.SongService

class SongServiceRandom : SongService {
    override fun getSongs(count: Int): List<Song> {
        val singers = listOf(
            "rita",
            "roma",
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
        val items = mutableListOf<Song>()
        for (i: Int in 0..count) {
            items.add(i, Song(songs.random(), singers.random()))
        }
        return items
    }
}