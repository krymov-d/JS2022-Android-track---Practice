package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
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
private const val KEY_POSITION = "KEY_POSITION"
private const val KEY_OFFSET = "KEY_OFFSET"

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

    override fun onSaveInstanceState(outState: Bundle) {
        val firstItemPosition = layoutManagerMain.findFirstVisibleItemPosition()
        val top = layoutManagerMain.findViewByPosition(firstItemPosition)?.top ?: 0
        outState.putInt(KEY_POSITION, firstItemPosition)
        outState.putInt(KEY_OFFSET, top)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val firstItemPosition = savedInstanceState.getInt(KEY_POSITION)
        val top = savedInstanceState.getInt(KEY_OFFSET)
//        layoutManagerMain.scrollToPosition(firstItemPosition)
        layoutManagerMain.scrollToPositionWithOffset(firstItemPosition, top)
    }

    private fun setupSampleAdapter() {
        val sampleAdapter = SampleAdapter()

        rvMain.apply {
            adapter = sampleAdapter
            layoutManager = layoutManagerMain
        }

        val sampleList = mutableListOf<Sample>()
        for (i in 0..50) {
            val sample = Sample(id = i, name = "Sample $i")
            sampleList.add(sample)
        }
        sampleAdapter.setData(sampleList)

        btnUpdate.setOnClickListener {
            val updatedSampleList = mutableListOf<Sample>()
            for (i in 0..50) {
                if (i % 2 == 0) {
                    continue
                }
                val sample = Sample(id = i, name = "Sample $i")
                updatedSampleList.add(sample)
            }
            sampleAdapter.updateData(updatedSampleList)
        }
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
    }

    private fun setupSimpleAdapter() {

        val nameAdapter = NameAdapter(
            clickListener = {
                Log.d("name", it)
            }
        )

        rvMain.apply {
            adapter = nameAdapter
            layoutManager = layoutManagerMain
        }

        val nameList = listOf("Арман", "Игорь", "Daniel", "Айсұлу")
        nameAdapter.setItems(nameList)
    }
}