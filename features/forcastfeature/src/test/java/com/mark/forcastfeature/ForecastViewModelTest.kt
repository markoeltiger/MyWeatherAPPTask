package com.mark.forcastfeature

import com.mark.domain.forcastDomain.ForcasttWeatherResult
import com.mark.domain.forcastDomain.usecase.IGetForcastWeatherUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ForecastViewModelTest {

    // Test Dispatcher
    private val testDispatcher = StandardTestDispatcher()

    // Mock Use Case
    private lateinit var getForecastWeatherUseCase: IGetForcastWeatherUseCase

    // ViewModel under test
    private lateinit var viewModel: ForecastViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getForecastWeatherUseCase = mockk()
        viewModel = ForecastViewModel(getForecastWeatherUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `load forecast emits success state`() = runTest {
        val forecastData = fakeForecastWeather()
        coEvery { getForecastWeatherUseCase.execute("Cairo") } returns flowOf(
            ForcasttWeatherResult.SuccessResult(forecastData)
        )

        viewModel.processIntent(ForecastIntent.LoadForecast("Cairo"))
        advanceUntilIdle()

        val state = viewModel.state.value
        assertEquals("Cairo", state.city)
        assertEquals("32.0", state.maxTemp)
        assertFalse(state.isLoading)
    }
}