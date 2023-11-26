package nsu.titov.myconverter.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import nsu.titov.myconverter.appComponent
import nsu.titov.myconverter.databinding.FragmentCurrencyListBinding
import nsu.titov.myconverter.presentation.CurrencyListViewModel
import nsu.titov.myconverter.ui.rv.CurrencyListRecyclerAdapter

class CurrencyListFragment : Fragment() {

	private lateinit var binding: FragmentCurrencyListBinding
	private val currencyListViewModel: CurrencyListViewModel by viewModels {
		requireContext().appComponent.viewModelsFactory()
	}
	private val adapter = CurrencyListRecyclerAdapter()

	override fun onAttach(context: Context) {
		context.appComponent.inject(this)
		super.onAttach(context)
	}


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = FragmentCurrencyListBinding
		.inflate(inflater, container, false)
		.also { binding = it }
		.root

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		val recycler = binding.currencyListRecyclerView

		currencyListViewModel.currencyData.observe(viewLifecycleOwner) { newData ->
			if (binding.swipeRefreshLayout.isRefreshing) {
				binding.swipeRefreshLayout.isRefreshing = false
			}
			newData?.let { data -> adapter.updateCurrencyData(data) }
		}

		currencyListViewModel.getCurrencyData()
		recycler.adapter = adapter

		binding.swipeRefreshLayout.setOnRefreshListener { onRefreshRequested() }
	}

	private fun onRefreshRequested() {
		currencyListViewModel.forceRefresh()
	}
}