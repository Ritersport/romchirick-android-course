package nsu.leorita.exchanges.domain.services

import io.reactivex.Single
import nsu.leorita.exchanges.domain.model.RangesInfo

interface RangesService {
    fun getRanges(): Single<RangesInfo>
}