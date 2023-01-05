package id.ac.unand.loki_a9.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [peserta::class], version = 1, exportSchema = false)
abstract class pesertaDatabase: RoomDatabase() {

    abstract fun pesertaDao() : pesertaDao

    companion object {
        @Volatile
        private var INSTANCE : pesertaDatabase? = null

        fun getDatabase (context: Context): pesertaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    pesertaDatabase::class.java,
                    "peserta_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}