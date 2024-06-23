package com.example.listingmovie.presentation.state

import com.example.domain.model.Result

sealed interface MovieListState {
    data object Loading : MovieListState
    class Success(val movieResult: List<Result>): MovieListState
    class Error(val error: String): MovieListState
}