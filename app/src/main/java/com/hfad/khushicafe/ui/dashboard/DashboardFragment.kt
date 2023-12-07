package com.hfad.khushicafe.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.khushicafe.R
import com.hfad.khushicafe.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.coffeeBrands
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val findCoffee = binding.findCoffee
        findCoffee.setOnClickListener {
            val coffeeCategorySpinner = binding.coffeeCategory
            val category = coffeeCategorySpinner.selectedItem.toString()
            val coffeeList = getCoffees(category)
            val coffeeBrands = binding.coffeeBrands
            val coffeeText = formatCoffeeList(coffeeList)
            coffeeBrands.text = coffeeText
        }

        return root
    }

    private fun getCoffees(category: String): List<Pair<String, Double>> {
        return when (category) {
            "Hot Coffee" -> listOf(
                "Espresso" to 2.5,
                "Caffee Latte" to 3.0,
                "Cappuccino" to 2.8
            )
            "Cold Coffee" -> listOf(
                "Iced Caffe Americano" to 3.2,
                "Nitro Cold Brew" to 4.0,
                "Iced Coffee" to 3.5
            )
            "Tea" -> listOf(
                "Green Tea" to 2.0,
                "Black Tea" to 1.8,
                "Herbal Tea" to 2.2
            )
            else -> listOf(
                "Lemonade" to 2.5,
                "Soda" to 1.5,
                "Fruit Punch" to 2.8
            )
        }
    }

    private fun formatCoffeeList(coffeeList: List<Pair<String, Double>>): String {
        return coffeeList.joinToString("\n") { (coffee, price) ->
            "$coffee - $$price"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
