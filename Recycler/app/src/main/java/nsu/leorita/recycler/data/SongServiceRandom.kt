package nsu.leorita.recycler.data

import io.reactivex.Single
import nsu.leorita.recycler.domain.Song
import nsu.leorita.recycler.domain.SongService

class SongServiceRandom : SongService {
    override fun getSongs(count: Int): Single<List<Song>> {
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
        val items = mutableListOf<Song>()
        for (i: Int in 0..<count) {
            items.add(i, Song(songs.random(), singers.random()))
        }
        return Single.just(items)
    }
}