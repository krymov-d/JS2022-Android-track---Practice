package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.START
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kz.kd.practice.customization.Animal
import kz.kd.practice.customization.AnimalAdapter
import kz.kd.practice.customization.Cat
import kz.kd.practice.customization.Dog
import kz.kd.practice.diffutil.Sample
import kz.kd.practice.diffutil.SampleAdapter

private const val TAG = "RecyclerView_II"

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView
    private lateinit var layoutManagerMain: LinearLayoutManager
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.recycler_view)
        layoutManagerMain = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        btnUpdate = findViewById(R.id.btn_update)

        setupAnimalAdapter()
    }

    private fun setupAnimalAdapter() {
        val animalAdapter = AnimalAdapter(
            clickListener = {
                Log.d("cat name:", it.toString())
            }
        )

        rvMain.apply {
            adapter = animalAdapter
            layoutManager = layoutManagerMain
        }

        val animalList = mutableListOf<Animal>()
        for (i in 0..100) {
            val cat = Cat("Murka $i", R.drawable.ic_sun)
            animalList.add(cat)
            val dog = Dog("Mukhtar $i", R.drawable.ic_moon)
            animalList.add(dog)
        }

        animalAdapter.setItems(animalList)

        //ItemDecoration
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvMain.addItemDecoration(dividerItemDecoration)

        //ItemTouchHelper
        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, START or END) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    return
                }

            }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(rvMain)
    }
}