package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.recycler_view)

        setupAnimalAdapter()
    }

    private fun setupAnimalAdapter() {
        val animalAdapter = AnimalAdapter(
            clickListener = {
                Log.d("cat name:", it.toString())
            }
        )
        val animalManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvMain.apply {
            adapter = animalAdapter
            layoutManager = animalManager
        }

        val animalList = listOf(
            Cat("Lola", R.drawable.ic_launcher_background),
            Dog("Tapash", R.drawable.ic_launcher_foreground),
            Cat("Lola 2", R.drawable.ic_launcher_background),
            Dog("Tapash 2", R.drawable.ic_launcher_foreground),
            Cat("Lola 3", R.drawable.ic_launcher_background),
            Dog("Tapash 3", R.drawable.ic_launcher_foreground),
            Dog("Tapash", R.drawable.ic_launcher_foreground),
            Dog("Tapash 2", R.drawable.ic_launcher_foreground),
            Cat("Lola", R.drawable.ic_launcher_background),
            Cat("Lola", R.drawable.ic_launcher_background),
            Cat("Lola", R.drawable.ic_launcher_background),
            Cat("Lola", R.drawable.ic_launcher_background),
            Dog("Tapash 3", R.drawable.ic_launcher_foreground)
        )

        animalAdapter.setItems(animalList)
    }

    private fun setupSimpleAdapter() {

        val nameAdapter = NameAdapter(
            clickListener = {
                Log.d("name", it)
            }
        )

        val nameManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rvMain.apply {
            adapter = nameAdapter
            layoutManager = nameManager
        }

        val nameList = listOf("Арман", "Игорь", "Daniel", "Айсұлу")
        nameAdapter.setItems(nameList)
    }
}