package kz.kd.practice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val TAG = "FragmentLife"
const val ARG_COUNTER = "ARG_COUNTER"

class SecondFragment : Fragment(R.layout.fragment_second) {

    companion object {
        fun newInstance(counter: Int): SecondFragment{
            val args = Bundle()
            args.putInt(ARG_COUNTER, counter)

            val fragment = SecondFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "SecondFragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SecondFragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "SecondFragment onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "SecondFragment onViewCreated")

        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = arguments?.getInt(ARG_COUNTER).toString()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondFragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "SecondFragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondFragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "SecondFragment onDetach")
    }
}