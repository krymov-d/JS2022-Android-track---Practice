package kz.kd.practice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        val viewPagerAdapter = MyPagerAdapter()

        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.d(
                    "App", "onPageScrolled: position=$position, " +
                            "positionOffset=$positionOffset, " +
                            "positionOffsetPixels=$positionOffsetPixels"
                )
            }

            override fun onPageSelected(position: Int) {
                Log.d("App", "onPageSelected: $position")
                Toast.makeText(this@MainActivity, "onPageSelected: $position", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.d("App", "onPageScrollStateChanged: $state")
            }
        })
        viewPager.currentItem = 0
    }

    override fun onDestroy() {
        viewPager.clearOnPageChangeListeners()
        super.onDestroy()
    }
}