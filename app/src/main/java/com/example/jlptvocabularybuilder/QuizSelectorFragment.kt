package com.example.jlptvocabularybuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.jlptvocabularybuilder.databinding.FragmentQuizSelectorBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizSelectorFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentQuizSelectorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_selector,container,false)
        val view = binding.root

        ArrayAdapter.createFromResource(
            view.context,
            R.array.quiz_type_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.quizTypeSpinner.adapter = adapter
        }

        binding.tvN5.setOnClickListener(this)
        binding.tvN4.setOnClickListener(this)
        binding.tvN3.setOnClickListener(this)
        binding.tvN2.setOnClickListener(this)
        binding.tvN1.setOnClickListener(this)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_n1 -> onLevelSelect(view)
            R.id.tv_n2 -> onLevelSelect(view)
            R.id.tv_n3 -> onLevelSelect(view)
            R.id.tv_n4 -> onLevelSelect(view)
            R.id.tv_n5 -> onLevelSelect(view)
        }
    }

    fun onLevelSelect(view: View) {
        if (!view.isSelected) {
            view.isSelected=true
            view.setBackgroundResource(R.drawable.selected_level_background_border)
        } else {
            view.isSelected=false
            view.setBackgroundResource(R.drawable.level_background_border)

        }
    }

}

