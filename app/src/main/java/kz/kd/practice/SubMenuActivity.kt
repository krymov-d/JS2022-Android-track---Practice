package kz.kd.practice

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SubMenuActivity : AppCompatActivity() {

    private lateinit var tbSubMenu: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submenu)

        initToolbar()
        initUpButton()
    }

    private fun initToolbar() {
        tbSubMenu = findViewById(R.id.tb_submenu_activity)
        setSupportActionBar(tbSubMenu)
    }

    private fun initUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflaterMain: MenuInflater = menuInflater
        menuInflaterMain.inflate(R.menu.menu_submenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.menu_login -> {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_password -> {
                Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_read_news -> {
                Toast.makeText(this, "News", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_read_other -> {
                Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}