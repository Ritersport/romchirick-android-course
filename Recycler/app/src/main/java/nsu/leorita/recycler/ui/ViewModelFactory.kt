package nsu.leorita.recycler.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nsu.leorita.recycler.domain.AdService
import nsu.leorita.recycler.domain.SongService
import nsu.leorita.recycler.ui.view_models.ListViewModel

class ViewModelFactory(
    private val songService: SongService,
    private val adService: AdService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            ListViewModel::class.java -> {
                ListViewModel(songService, adService)
            }
            else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory(songService: SongService, adService: AdService) = ViewModelFactory(songService, adService)