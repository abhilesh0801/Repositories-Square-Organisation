package com.square

import com.square.data.api.ApiService
import com.square.utils.Constants.Companion.SQUARE_REPO_JSON
import com.square.utils.Constants.Companion.SUCCESS_RESPONSE_CODE
import com.square.utils.Constants.Companion.UTF_8
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

@RunWith(JUnit4::class)
class ApiServiceTest {

    private lateinit var apiService: ApiService

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        apiService = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient())
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun getRepositoriesTest() {
        val content = this.javaClass.classLoader!!.getResource(SQUARE_REPO_JSON).readText(
            Charset.forName(UTF_8))

        mockWebServer.enqueue(
            MockResponse()
            .setResponseCode(SUCCESS_RESPONSE_CODE)
            .setBody(content))

        val response = apiService.getRepositories().blockingFirst()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.isNotEmpty())
    }
}