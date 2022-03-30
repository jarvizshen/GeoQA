package com.example.geoqa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.geoqa.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Resources.questions[0] = "Canberra is the capital of Australia"
        Resources.questions[1] = "Beijing is the capital of Mars"
        Resources.questions[2] = "Shanghai is the capital of Poland"
        Resources.answers[0] = false
        Resources.answers[1] = true
        Resources.answers[2] = true
        binding.question.text = Resources.questions[Resources.index]
        binding.cheatBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.nextBtn.setOnClickListener {
            if (Resources.index < Resources.questions.size - 1) {
                if (Resources.flag) {
                    Resources.flag = !Resources.flag
                }
                Resources.index = Resources.index + 1
                binding.question.text = Resources.questions[Resources.index]
            }
        }
        binding.trueBtn.setOnClickListener {
            if (Resources.answers[Resources.index] == true) {
                if (Resources.flag) {
                    Snackbar.make(binding.root, "good job!cheater!", Snackbar.LENGTH_SHORT).show()
                } else {
                    Snackbar.make(binding.root, "not bad,smart ass.", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                if (Resources.flag) {
                    Snackbar.make(
                        binding.root,
                        "Don't you remember you were cheated?dumb ass!",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(binding.root, "stupid motherfucker", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        binding.falseBtn.setOnClickListener {
            if (Resources.answers[Resources.index] == false) {
                if (Resources.flag) {
                    Snackbar.make(binding.root, "good job!cheater!", Snackbar.LENGTH_SHORT).show()
                } else {
                    Snackbar.make(binding.root, "not bad,smart ass.", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                if (Resources.flag) {
                    Snackbar.make(
                        binding.root,
                        "Don't you remember you were cheated?dumb ass!",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(binding.root, "stupid motherfucker", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}