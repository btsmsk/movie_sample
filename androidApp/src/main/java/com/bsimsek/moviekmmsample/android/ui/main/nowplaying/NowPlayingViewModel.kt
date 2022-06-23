package com.bsimsek.moviekmmsample.android.ui.main.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsimsek.moviekmmsample.data.model.local.MovieCategory
import com.bsimsek.moviekmmsample.viewmodel.MovieSharedViewModel
import com.bsimsek.moviekmmsample.viewstate.MovieViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val sharedViewModel: MovieSharedViewModel,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    var viewState = MutableStateFlow(MovieViewState.empty)

    init {
        initState()
    }

    fun initState() {
        viewModelScope.launch(dispatcher) {
            sharedViewModel.fetchMovie(viewState = viewState.value, MovieCategory.nowPlaying.id)
                .collect {
                    viewState.value = it
                }
        }
    }
}