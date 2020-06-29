package com.lingga.testcovid.data.remote.services

import com.lingga.testcovid.data.remote.responses.DataResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {

    @GET("countries/Indonesia")
    fun getData(): Single<DataResponse>

}