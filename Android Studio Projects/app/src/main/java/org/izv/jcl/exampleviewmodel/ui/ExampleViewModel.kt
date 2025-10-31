package org.izv.jcl.exampleviewmodel.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExampleViewModel: ViewModel() {
    // val textField = remember { mutableStateOf("") }
    // var textString by remember { mutableStateOf("") }
    private val _contador = MutableStateFlow(0)
    val contador: StateFlow<Int> = _contador

    fun increment() {
        _contador.value++
    }
}