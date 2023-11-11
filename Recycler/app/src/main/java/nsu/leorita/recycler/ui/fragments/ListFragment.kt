package nsu.leorita.recycler.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import nsu.leorita.recycler.data.AdServiceRandom
import nsu.leorita.recycler.data.SongServiceRandom
import nsu.leorita.recycler.databinding.FragmentListBinding
import nsu.leorita.recycler.ui.recycler_stuff.RecyclerAdapter
import nsu.leorita.recycler.ui.factory
import nsu.leorita.recycler.ui.recycler_stuff.MarginItemDecoration
import nsu.leorita.recycler.ui.recycler_stuff.delegates.AdDelegate
import nsu.leorita.recycler.ui.recycler_stuff.delegates.SongDelegate
import nsu.leorita.recycler.ui.view_models.ListViewModel

private const val ITEM_MARGIN = 16

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = requireNotNull(_binding)

    private val viewModel: ListViewModel by viewModels {
        factory(SongServiceRandom(), AdServiceRandom())
    }

    private val delegates by lazy {
        listOf(
            SongDelegate(),
            AdDelegate(),
        )
    }

    private val _adapter by lazy {
        RecyclerAdapter(delegates)
    }

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
        initAdapter()
        initObservers()
    }

    private fun initAdapter() {
        with(binding.recycler) {
            adapter = _adapter
            addItemDecoration(MarginItemDecoration(ITEM_MARGIN))
        }
    }

    private fun initObservers() {
        viewModel.items.observe(viewLifecycleOwner) {
            _adapter.items = it
        }
    }

    companion object {
        fun getInstance(): Fragment = ListFragment()
    }
}