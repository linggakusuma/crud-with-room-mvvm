package com.lingga.quiz.data.remote.services

import com.lingga.quiz.data.remote.responses.DataResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {

    @GET("countries/Indonesia")
    fun getData(): Single<DataResponse>

}