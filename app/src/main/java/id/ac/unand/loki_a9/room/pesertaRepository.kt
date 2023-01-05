package id.ac.unand.loki_a9.room

import androidx.lifecycle.LiveData

class pesertaRepository(private val pesertaDao: pesertaDao) {

    val readAllData : LiveData<List<peserta>> = pesertaDao.readAllData()

    suspend fun addPeserta(peserta: peserta){
        pesertaDao.addPeserta(peserta)
    }
}