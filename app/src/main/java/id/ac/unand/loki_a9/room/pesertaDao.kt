package id.ac.unand.loki_a9.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface pesertaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPeserta(peserta: peserta)

    @Query("SELECT * FROM tabel_peserta ORDER BY nim ASC")
    fun readAllData(): LiveData<List<peserta>>
}