package kz.kd.practice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainFragment(), "MainFragment")
                .commit()
        }
//      Методы транзакции
//          add() - Добавляет фрагмент к активити
//          remove() - Удаляет фрагмент из активити
//          replace() - Заменяет сущефрагмент
//          hide() - Прячет фрагмент (делает невидимым на экране)
//          show() - Выводит скрытый фрагмент на экран
    }
}