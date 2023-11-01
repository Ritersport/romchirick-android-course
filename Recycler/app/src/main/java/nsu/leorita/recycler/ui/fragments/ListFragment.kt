package nsu.leorita.recycler.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import nsu.leorita.recycler.data.SongServiceRiRo
import nsu.leorita.recycler.databinding.FragmentListBinding
import nsu.leorita.recycler.ui.recycler_stuff.RecyclerAdapter
import nsu.leorita.recycler.ui.factory
import nsu.leorita.recycler.ui.recycler_stuff.MarginItemDecoration
import nsu.leorita.recycler.ui.view_models.ListViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = requireNotNull(_binding)

    private val viewModel: ListViewModel by viewModels { factory(SongServiceRiRo())  }

    private val itemMargin = 16
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = RecyclerAdapter(viewModel.getDelegates(requireContext()), viewModel.getItems())
        binding.recycler.addItemDecoration(MarginItemDecoration(itemMargin))
    }

    companion object {
        fun getInstance(): Fragment = ListFragment()
    }
}