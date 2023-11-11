package nsu.leorita.recycler.ui.recycler_stuff.items

import nsu.leorita.recycler.domain.Ad
import nsu.leorita.recycler.domain.Song

fun AdItem.toDomain(): Ad =
    Ad(this.category, this.header, this.text)

fun SongItem.toDomain(): Song =
    Song(this.name, this.singer)

fun Song.toUI(): SongItem =
    SongItem(this.name, this.singer)

fun Ad.toUI(): AdItem =
    AdItem(this.category, this.header, this.description)