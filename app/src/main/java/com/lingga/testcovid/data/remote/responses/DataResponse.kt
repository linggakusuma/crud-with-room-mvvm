package com.lingga.testcovid.data.remote.responses

data class DataResponse(
    val confirmed: ValueResponse?,
    val recovered: ValueResponse?,
    val deaths: ValueResponse?,
    val lastUpdate: String?
)