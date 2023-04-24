package kz.kd.practice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val TAG = "FragmentLife"

class SecondFragment : Fragment(R.layout.fragment_second) {
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