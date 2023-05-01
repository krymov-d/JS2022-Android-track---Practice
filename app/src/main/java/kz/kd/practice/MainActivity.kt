package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMain: RecyclerView = findViewById(R.id.recycler_view)

        val nameAdapter = NameAdapter(
            clickListener = {
                Log.d("name", it)
            }
        )

        val nameManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvMain.apply {
            adapter = nameAdapter
            layoutManager = nameManager
        }

        val nameList = listOf("Арман", "Игорь", "Daniel", "Айсұлу")
        nameAdapter.setItems(nameList)
    }
}