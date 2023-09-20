package nsu.leorita.exchanges.ui.currencyConverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import nsu.leorita.exchanges.databinding.FragmentCurrencyConverterBinding
import nsu.leorita.exchanges.ui.factory

class CurrencyConverterFragment : Fragment() {
    private var _binding: FragmentCurrencyConverterBinding? = null

    private val binding
        get() = requireNotNull(_binding)

    private val viewModel: CurrencyConverterViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)
        return binding.root
    }
}