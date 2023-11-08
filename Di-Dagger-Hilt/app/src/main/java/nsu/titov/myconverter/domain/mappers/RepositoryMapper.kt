package nsu.titov.myconverter.domain.mappers

import nsu.titov.myconverter.data.models.CBRResponse
import nsu.titov.myconverter.data.models.Currency
import nsu.titov.myconverter.data.models.CurrencyDto

interface RepositoryMapper {
    fun currencyFromResponse(response: CBRResponse): List<Currency>

    fun dtoToCurrency(currencyDto: CurrencyDto): Currency

    fun currencyToDto(currency: Currency): CurrencyDto
}