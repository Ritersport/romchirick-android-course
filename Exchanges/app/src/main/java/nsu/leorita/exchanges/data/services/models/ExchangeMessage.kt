package nsu.leorita.exchanges.data.services.models

import com.google.gson.annotations.SerializedName

data class ExchangeMessage (
    @SerializedName("Date")
    var date: String,

    @SerializedName("Valute")
    var valuteSet: Map<String, Valute>
    ) {

}