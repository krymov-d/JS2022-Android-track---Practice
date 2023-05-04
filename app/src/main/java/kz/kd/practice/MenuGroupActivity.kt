package kz.kd.practice

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MenuGroupActivity : AppCompatActivity() {

    private lateinit var tbGroupMenu: Toolbar
    private var option = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_menu)

        initToolbar()
        initUpButton()
    }

    private fun initToolbar() {
        tbGroupMenu = findViewById(R.id.tb_group_menu_activity)
        setSupportActionBar(tbGroupMenu)
    }

    private fun initUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflaterMain: MenuInflater = menuInflater
        menuInflaterMain.inflate(R.menu.menu_group, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        when (option) {
            0 -> menu?.findItem(R.id.option_1)?.isChecked = true
            1 -> menu?.findItem(R.id.option_2)?.isChecked = true
            2 -> menu?.findItem(R.id.option_3)?.isChecked = true
            3 -> menu?.findItem(R.id.option_4)?.isChecked = true
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.option_1 -> {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
                option = 0
                true
            }

            R.id.option_2 -> {
                Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()
                option = 1
                true
            }

            R.id.option_3 -> {
                Toast.makeText(this, "News", Toast.LENGTH_SHORT).show()
                option = 2
                true
            }

            R.id.option_4 -> {
                Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
                option = 3
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}