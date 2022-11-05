package com.amity.testapplication.core.network

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class DispatcherProvider {
    open val Main: CoroutineContext by lazy { Dispatchers.Main }
    open val IO: CoroutineContext by lazy { Dispatchers.IO }
}