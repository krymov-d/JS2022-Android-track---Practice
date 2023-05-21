package kz.kd.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    private lateinit var btnEmptyBS: AppCompatButton
    private lateinit var btnStandardBS: AppCompatButton
    private lateinit var btnModalBS: AppCompatButton
    private lateinit var btnExpandingBS: AppCompatButton
    private lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEmptyBS = findViewById(R.id.button)
        btnStandardBS = findViewById(R.id.button2)
        btnModalBS = findViewById(R.id.button3)
        btnExpandingBS = findViewById(R.id.button4)
        coordinatorLayout = findViewById(R.id.stickerCoordinatorLayout)

        btnEmptyBS.setOnClickListener {
            BottomSheetEmpty().show(supportFragmentManager, null)
        }

        btnStandardBS.setOnClickListener {
            coordinatorLayout.isGone = !coordinatorLayout.isGone
        }

        btnModalBS.setOnClickListener {
            BottomSheetModal().show(supportFragmentManager, null)
        }

        btnExpandingBS.setOnClickListener {
            ExpandingSheetDialog().show(supportFragmentManager, null)
        }
    }
}