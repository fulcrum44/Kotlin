package org.izv.jcl.sourcecodeloader.model.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URI

class SourceCodeRepository() {
    suspend fun httpGet(urlString: String): String {

        return withContext(Dispatchers.IO) {
            val url = URI.create(urlString).toURL()
            val connection = url.openConnection() as HttpURLConnection

            try {
                connection.requestMethod = "GET"
                connection.connectTimeout = 5000 // Aumentado un poco por si la web es pesada
                connection.readTimeout = 5000
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android)")

                connection.inputStream
                    .bufferedReader()
                    .use { it.readText() }

            } finally {
                connection.disconnect()
            }

        }
    }
}