package com.example.lab_4.data.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ChiuitDao {

    @Query("SELECT * FROM chiuits")
    fun getAll(): List<ChiuitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chiuit: ChiuitEntity)

    @Query("DELETE FROM chiuits WHERE timestamp = :timestamp")
    fun deleteByTimestamp(timestamp: Long)
}
