package kz.kd.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter : PagerAdapter() {

    private val layouts = listOf(
        R.layout.viewpager1_text,
        R.layout.viewpager1_button
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val layout = inflater.inflate(layouts[position], container, false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Title $position"
    }
}