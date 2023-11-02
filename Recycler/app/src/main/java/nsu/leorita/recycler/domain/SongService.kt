package nsu.leorita.recycler.domain

import io.reactivex.Single

interface SongService {
    fun getSongs(count: Int): Single<List<Song>>
}