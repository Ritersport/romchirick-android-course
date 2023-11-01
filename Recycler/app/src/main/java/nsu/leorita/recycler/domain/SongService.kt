package nsu.leorita.recycler.domain

interface SongService {
    fun getSongs(count: Int): List<Song>
}