package org.izv.jcl.sourcecodeloader.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.izv.jcl.sourcecodeloader.model.repository.SourceCodeRepository

class SourceCodeViewModel(private val repository: SourceCodeRepository): ViewModel() {

    var sourceCode by mutableStateOf("")
    var error by mutableStateOf<String?>("")

    fun getSourceCode(url: String) {
        viewModelScope.launch {
            try {
                sourceCode = repository.httpGet(url)
            } catch (e: Exception) {
                sourceCode = ""
                error = e.message
            }
        }
    }

}