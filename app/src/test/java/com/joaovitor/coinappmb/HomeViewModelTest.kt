package com.joaovitor.coinappmb

import androidx.lifecycle.Observer
import com.joaovitor.coinappmb.repository.Repository
import com.joaovitor.coinappmb.ui.model.response.Exchange
import com.joaovitor.coinappmb.utils.InstantExecutorExtension
import io.mockk.Called
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verifySequence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class HomeViewModelTest {

    private lateinit var repository: Repository
    private lateinit var homeViewModel: HomeViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain((Dispatchers.Unconfined))
        repository = mockk()
        homeViewModel = HomeViewModel(repository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun fetchExchange_success() = runTest {
        val mockData = listOf<Exchange>(/*...*/)
        coEvery { repository.fetchExchange() } returns mockData

        val observer = mockk<Observer<List<Exchange>>>(relaxed = true)
        val loadingObserver = mockk<Observer<Boolean>>(relaxed = true)
        val errorObserver = mockk<Observer<Boolean>>(relaxed = true)

        homeViewModel.data.observeForever(observer)
        homeViewModel.isLoading.observeForever(loadingObserver)
        homeViewModel.isError.observeForever(errorObserver)

        homeViewModel.fetchExchange()

        verifySequence {
            loadingObserver.onChanged(true)
            observer.onChanged(mockData)
            loadingObserver.onChanged(false)
            errorObserver wasNot Called
        }
    }

    @Test
    fun fetchExchange_error() = runTest {
        coEvery { repository.fetchExchange() } throws RuntimeException("Error fetching data")

        val observer = mockk<Observer<List<Exchange>>>(relaxed = true)
        val loadingObserver = mockk<Observer<Boolean>>(relaxed = true)
        val errorObserver = mockk<Observer<Boolean>>(relaxed = true)

        homeViewModel.data.observeForever(observer)
        homeViewModel.isLoading.observeForever(loadingObserver)
        homeViewModel.isError.observeForever(errorObserver)

        homeViewModel.fetchExchange()

        verifySequence {
            loadingObserver.onChanged(true)
            errorObserver.onChanged(true)
            loadingObserver.onChanged(false)
            observer wasNot Called
        }
    }
}