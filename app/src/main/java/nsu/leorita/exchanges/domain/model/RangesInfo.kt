package nsu.leorita.exchanges.domain.model

data class RangesInfo(
    val date: String,
    val ranges: Map<String, Currency>
)