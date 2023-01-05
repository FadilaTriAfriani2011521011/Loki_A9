package id.ac.unand.loki_a9.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tabel_peserta")
data class peserta(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val nim: String,
    val nama: String
        )