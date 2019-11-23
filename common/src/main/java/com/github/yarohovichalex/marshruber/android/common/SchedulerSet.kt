package com.github.yarohovichalex.marshruber.android.common

import kotlin.coroutines.CoroutineContext

open class SchedulerSet(
    open val ioCoroutineContext: CoroutineContext,
    open val uiCoroutineContext: CoroutineContext
)
