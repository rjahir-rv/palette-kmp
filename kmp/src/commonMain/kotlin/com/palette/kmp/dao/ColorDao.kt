package com.palette.kmp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.palette.kmp.models.ColorModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Insert
    suspend fun insertColor(color: ColorModel)

    @Update
    suspend fun updateColor(color: ColorModel)

    @Delete
    suspend fun deleteColor(color: ColorModel)

    @Query("DELETE FROM colors WHERE idPalette = :idPalette")
    suspend fun deleteColorById(idPalette: Int)

    @Query("SELECT * FROM colors WHERE idPalette = :idPalette")
    fun getColorById(idPalette: Int): Flow<List<ColorModel>?>

    @Query("SELECT * FROM colors")
    fun getAllColors(): Flow<ColorModel>




}