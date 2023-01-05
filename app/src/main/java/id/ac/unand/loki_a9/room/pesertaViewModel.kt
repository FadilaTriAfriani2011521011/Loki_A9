package id.ac.unand.loki_a9.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class pesertaViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData :  LiveData<List<peserta>>
    private val repository: pesertaRepository

    init {
        val pesertaDao = pesertaDatabase.getDatabase(application).pesertaDao()
        repository = pesertaRepository(pesertaDao)
        readAllData = repository.readAllData
    }

    fun addPeserta (peserta: peserta){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addPeserta(peserta)
        }
    }
}