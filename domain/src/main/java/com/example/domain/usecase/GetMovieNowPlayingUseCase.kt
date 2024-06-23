package com.example.domain.usecase


import com.example.common.Resource
import com.example.domain.model.MovieResponse
import com.example.domain.repository.TmdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieNowPlayingUseCase @Inject constructor(
    private val repository: TmdbRepository
) {
    operator fun invoke(): Flow<Resource<MovieResponse>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieNowPlaying()
            emit(Resource.Success(movie))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
