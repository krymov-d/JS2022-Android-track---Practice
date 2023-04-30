package kz.kd.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import java.util.Random

private const val TAG = "Room_Tag"
private const val MY_DB = "my_db"

class MainActivity : AppCompatActivity() {

    private lateinit var tvMain: TextView
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMain = findViewById(R.id.tv_value)
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)

        val db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, MY_DB)
            .allowMainThreadQueries()
            .build()

        btnOne.setOnClickListener {
            val idInt = Random().nextInt()
            val personOne = Person(personId = idInt, firstName = "$idInt", lastName = "$idInt")
            db.personDao().insertAll(personOne)
        }

        btnTwo.setOnClickListener {
            val allPerson = db.personDao().getAll()
            allPerson.forEach {
                Log.e(TAG, "Person = $it")
            }
        }

//        val db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "my-database")
//            .addMigrations(MigrationFromVersion1ToVersion2()) // миграция БД
//            .allowMainThreadQueries() // разрешить работу с БД на основном потоке
//            .createFromAsset("pre_populated_database_file") // создать БД из подставленного файла (данных)
//            .fallbackToDestructiveMigration() // очистить в случае ошибки миграции
//            .setQueryExecutor(SomeExecutor()) // задать Executor для запросов в фоновом режиме
//            .build()

//        Также можно создать inMemoryDatabase - базу, которая существует до тех пор, пока процесс не будет уничтожен. Работает как кеш.
//        val db = Room.inMemoryDatabaseBuilder(applicationContext, MyDatabase::class.java)
    }
}