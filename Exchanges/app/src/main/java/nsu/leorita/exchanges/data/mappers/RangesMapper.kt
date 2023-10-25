package nsu.leorita.exchanges.data.mappers

import nsu.leorita.exchanges.data.services.models.ExchangeMessage
import nsu.leorita.exchanges.domain.model.Currency
import nsu.leorita.exchanges.domain.model.RangesInfo

object RangesMapper {
    fun toDomen(message: ExchangeMessage) : RangesInfo {
        val ranges = message.valuteSet.toList().map { Currency(it.second.code, it.second.name, it.second.nominal, it.second.value, it.second.previousValue) }
        return RangesInfo(message.date, ranges)
    }
}