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

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.recycler_view)
        btnUpdate = findViewById(R.id.btn_update)

        setupSampleAdapter()
    }

    private fun setupSampleAdapter() {
        val sampleAdapter = SampleAdapter()
        val sampleManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvMain.apply {
            adapter = sampleAdapter
            layoutManager = sampleManager
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
        val animalManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvMain.apply {
            adapter = animalAdapter
            layoutManager = animalManager
        }

        val animalList = mutableListOf<Animal>()
        for (i in 0..100) {
            val cat = Cat("Murka $i", R.drawable.ic_sun)
            animalList.add(cat)
            val dog = Dog("Mukhtar $i", R.drawable.ic_moon)
            animalList.add(dog)
        }

        animalAdapter.setItems(animalList)

        //LayoutManager
        var position: Int = 0
        animalManager.scrollToPosition(40)
        position = animalManager.findFirstVisibleItemPosition()
        Log.d(TAG, position.toString())
        position = animalManager.findFirstCompletelyVisibleItemPosition()
        Log.d(TAG, position.toString())
        position = animalManager.findLastVisibleItemPosition()
        Log.d(TAG, position.toString())
        position = animalManager.findLastCompletelyVisibleItemPosition()
        Log.d(TAG, position.toString())


        //ItemAnimator
        rvMain.itemAnimator = DefaultItemAnimator() // по умолчанию (можно не писать)
        rvMain.itemAnimator = null // отключаем анимацию


        //OnScrollListener
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                Log.d(TAG, newState.toString())
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                Log.d(TAG, "dx = $dx, dy = $dy")
            }
        }
        rvMain.addOnScrollListener(scrollListener)

        //SmoothScroller
        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_END
            }
        }
        smoothScroller.targetPosition = 90
        animalManager.startSmoothScroll(smoothScroller)

        //ItemDecoration
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvMain.addItemDecoration(dividerItemDecoration)

        //Scrollbars
        rvMain.isVerticalScrollBarEnabled = true
        rvMain.isHorizontalScrollBarEnabled = true
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