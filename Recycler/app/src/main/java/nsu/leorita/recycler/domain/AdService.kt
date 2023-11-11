package nsu.leorita.recycler.domain

import io.reactivex.Single

interface AdService {
    fun getAd(): Single<List<Ad>>
}