package kz.kd.practice

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var btnSecondActivity: Button
    private lateinit var btnContextMenu: Button
    private lateinit var btnPopupMenu: Button
    private lateinit var btnSubMenuActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initViews()
        initSecondActivity()
        initContextMenu()
        initPopupMenu()
        initSubMenuActivity()
    }

    private fun initToolbar() {
        val tbMain: Toolbar = findViewById(R.id.tb_main)
        setSupportActionBar(tbMain)
    }

    private fun initViews() {
        btnSecondActivity = findViewById(R.id.btn_second_activity)
        btnContextMenu = findViewById(R.id.btn_context_menu)
        btnPopupMenu = findViewById(R.id.btn_popup_menu)
        btnSubMenuActivity = findViewById(R.id.btn_submenu_activity)
    }

    private fun initSecondActivity() {
        btnSecondActivity.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun initContextMenu() {
        registerForContextMenu(btnContextMenu)
    }

    private fun initPopupMenu() {
        btnPopupMenu.setOnClickListener {
            val popup = PopupMenu(this, it)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_main, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_close -> {
                        Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.menu_more -> {
                        Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }
    }

    private fun initSubMenuActivity() {
        btnSubMenuActivity.setOnClickListener {
            Intent(this, SubMenuActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_close -> {
                Toast.makeText(this, "Context close", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_more -> {
                Toast.makeText(this, "Context more", Toast.LENGTH_SHORT).show()
                true
            }

            else -> return super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflaterMain: MenuInflater = menuInflater
        menuInflaterMain.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_close -> {
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_more -> {
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}