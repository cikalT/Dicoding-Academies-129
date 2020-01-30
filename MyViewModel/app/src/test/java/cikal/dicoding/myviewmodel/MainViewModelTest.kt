package cikal.dicoding.myviewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "2"
        val lenght = "2"
        val height = "2"

        mainViewModel.calculate(width, lenght, height)
        assertEquals(8, mainViewModel.result)
    }
}