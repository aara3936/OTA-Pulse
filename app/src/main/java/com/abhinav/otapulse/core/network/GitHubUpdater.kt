package com.abhinav.otapulse.core.network

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient

data class UpdateInfo(
    val version: String,
    val downloadUrl: String,
    val changelog: String
)

object GitHubUpdater {
    fun checkForUpdate(
        currentVersion: String,
        httpClient: OkHttpClient = OkHttpClient(),
        onResult: (UpdateInfo?) -> Unit
    ) {
        Handler(Looper.getMainLooper()).post { onResult(null) }
    }

    suspend fun checkForUpdate(
        currentVersion: String,
        httpClient: OkHttpClient = OkHttpClient()
    ): UpdateInfo? = withContext(Dispatchers.IO) {
        null
    }
}
