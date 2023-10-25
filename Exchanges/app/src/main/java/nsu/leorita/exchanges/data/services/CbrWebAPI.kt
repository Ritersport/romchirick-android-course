package nsu.leorita.exchanges.data.services

import io.reactivex.Single
import nsu.leorita.exchanges.data.services.models.ExchangeMessage
import retrofit2.http.GET

interface CbrWebAPI {
    @GET("daily_json.js")
    fun getRanges(): Single<ExchangeMessage>
}