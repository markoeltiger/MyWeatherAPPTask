package com.mark.homefeature.viewmodel

import com.mark.homefeature.HomeViewModel
import com.mark.homefeature.usecase.FakeGetLastCityUseCase
import com.mark.homefeature.usecase.FakeSaveLastCityUseCase
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private val fakeSaveUseCase = FakeSaveLastCityUseCase()
    private val fakeGetUseCase = FakeGetLastCityUseCase()

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = HomeViewModel(fakeSaveUseCase, fakeGetUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `submit valid city name updates state correctly`() = runTest {
        viewModel.onCityNameChange("Cairo")
        viewModel.onSubmitCity()
        assertTrue(viewModel.uiState.isValid)
        assertNull(viewModel.uiState.errorMessage)
    }

    @Test
    fun `submit empty city name shows error`() = runTest {
        viewModel.onCityNameChange("")
        viewModel.onSubmitCity()
        assertFalse(viewModel.uiState.isValid)
        assertEquals("City name cannot be empty", viewModel.uiState.errorMessage)
    }
}