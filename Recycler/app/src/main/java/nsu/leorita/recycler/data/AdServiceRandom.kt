package nsu.leorita.recycler.data

import io.reactivex.Single
import nsu.leorita.recycler.domain.Ad
import nsu.leorita.recycler.domain.AdService
import java.util.concurrent.TimeUnit

class AdServiceRandom : AdService {
    override fun getAd(): Single<List<Ad>> {
        return Single.just(
            listOf(
                Ad("Technology", "Twitter is X now", "What a stupid rebranding"),
                Ad("Animals", "Kot Mer", "Cool as fuck"),
            )
        ).delay(5, TimeUnit.SECONDS)
    }
}