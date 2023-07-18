package nsu.leorita.exchanges.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase
import nsu.leorita.exchanges.data.room.CurrenciesDao
import nsu.leorita.exchanges.data.room.entities.CurrencyDbEntity
import nsu.leorita.exchanges.domain.model.Currency

@Database(
    version = 1,
    entities = [
        CurrencyDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCurrenciesDao(): CurrenciesDao
}