package nsu.leorita.exchanges.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import nsu.leorita.exchanges.data.room.entities.CurrencyDbEntity

@Database(
    version = 1,
    entities = [
        CurrencyDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCurrenciesDao(): CurrenciesDao
}