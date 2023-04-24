package kz.kd.practice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val TAG = "FragmentLife"

class MainFragment : Fragment(R.layout.fragment_main) {
    private var counter = 0
    private lateinit var textView: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "MainFragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainFragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "MainFragment onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "MainFragment onViewCreated")


        val button = view.findViewById<Button>(R.id.button)
        textView = view.findViewById(R.id.textView)

        button.setOnClickListener {
            counter++
            textView.text = counter.toString()
        }

        val resultButton = view.findViewById<Button>(R.id.result)
        resultButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragmentContainer,
                    SecondFragment.newInstance(counter),
                    "MainFragment2"
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainFragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "MainFragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainFragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "MainFragment onDetach")
    }

    fun resetCounter() {
        counter = 0
        textView.text = counter.toString()
    }
}