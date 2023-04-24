package kz.kd.practice

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addToBackStack = false
        findViewById<CheckBox>(R.id.checkBox).setOnCheckedChangeListener { _, isChecked ->
            addToBackStack = isChecked
        }

        findViewById<Button>(R.id.add).setOnClickListener {
            val transaction = supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, MainFragment(), "MainFragment")

            if (addToBackStack) transaction.addToBackStack(null)

            transaction.commit()
        }

        findViewById<Button>(R.id.replace).setOnClickListener {
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SecondFragment(), "SecondFragment")

            if (addToBackStack) transaction.addToBackStack(null)

            transaction.commit()
        }

        findViewById<Button>(R.id.resetCounter).setOnClickListener {
            val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if(fragment is MainFragment) {
                fragment.resetCounter()
            }
        }
    }
}