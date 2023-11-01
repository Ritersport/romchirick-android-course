package nsu.leorita.recycler.data

import nsu.leorita.recycler.domain.Ad
import nsu.leorita.recycler.domain.AdService

class AdServiceRandom : AdService{
    override fun getAds(): List<Ad> {
        return listOf(Ad("Technology", "Twitter is X now", "What a stupid rebranding"))
    }
}