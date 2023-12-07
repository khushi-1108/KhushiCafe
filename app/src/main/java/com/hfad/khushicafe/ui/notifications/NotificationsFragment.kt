package com.hfad.khushicafe.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.khushicafe.R
import com.hfad.khushicafe.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using the binding
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up of event details here using the generated binding references
        binding.ChristmasText.text = "Christmas Event"
        binding.NewYearText.text = "New Year Event"
        binding.ValentineText.text = "Valentine's Day Event"

        //images into ImageViews
        binding.ChristmasImage.setImageResource(R.drawable.christmas)
        binding.NewYearImage.setImageResource(R.drawable.newyear)
        binding.ValentineImage.setImageResource(R.drawable.valentine)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
