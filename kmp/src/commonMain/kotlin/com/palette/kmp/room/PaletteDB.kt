package com.palette.kmp.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.palette.kmp.dao.PaletteDao
import com.palette.kmp.models.PaletteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [PaletteModel::class],
    version = 1,
    exportSchema = true
)

@ConstructedBy(AppDatabase::class)
abstract class PaletteDB : RoomDatabase() {
    abstract fun paletteDao(): PaletteDao
}
class CreateDatabase(private val builder: RoomDatabase.Builder<PaletteDB>) {
    fun getDatabase(): PaletteDB {
        return builder
            .fallbackToDestructiveMigration(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabase : RoomDatabaseConstructor<PaletteDB>{
    override fun initialize(): PaletteDB
}