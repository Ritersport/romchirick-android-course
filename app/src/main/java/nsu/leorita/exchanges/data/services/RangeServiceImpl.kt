package nsu.leorita.exchanges.data.services

import io.reactivex.Single
import nsu.leorita.exchanges.data.mappers.RangesMapper
import nsu.leorita.exchanges.domain.model.RangesInfo
import nsu.leorita.exchanges.domain.services.RangesService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RangeServiceImpl : RangesService {
    private val BASE_URL = "https://www.cbr-xml-daily.ru/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    private val cbrWebAPI = retrofit.create<CbrWebAPI>()

    override fun getRanges(): Single<RangesInfo> {
        return cbrWebAPI.getRanges().map(RangesMapper::toDomen)
    }

}