package com.example.lab_4.data.database

import com.example.lab_4.domain.Chiuit
import com.example.lab_4.domain.ChiuitRepository

class ChiuitDbStore(private val appDatabase: AppDatabase) : ChiuitRepository {

    override fun getAll(): List<Chiuit> {
        return appDatabase.chiuitDao().getAll().map { it.toDomainModel() }
    }

    override fun addChiuit(chiuit: Chiuit) {
        appDatabase.chiuitDao().insert(chiuit.toDbModel())
    }

    override fun removeChiuit(chiuit: Chiuit) {
        appDatabase.chiuitDao().deleteByTimestamp(chiuit.timestamp)
    }



    private fun Chiuit.toDbModel() = ChiuitEntity(timestamp, description)

    private fun ChiuitEntity.toDomainModel() = Chiuit(timestamp, description)

}