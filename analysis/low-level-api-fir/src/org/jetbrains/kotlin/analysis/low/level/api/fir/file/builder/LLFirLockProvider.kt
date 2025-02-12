/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.file.builder

import org.jetbrains.kotlin.analysis.low.level.api.fir.util.lockWithPCECheck
import org.jetbrains.kotlin.fir.declarations.FirFile
import java.util.concurrent.locks.ReentrantLock

/**
 * Keyed locks provider.
 */
internal class LLFirLockProvider {

    //We temporarily disable multi-locks to fix deadlocks problem
    private val globalLock = ReentrantLock()

    inline fun <R> withLock(
        @Suppress("UNUSED_PARAMETER") key: FirFile,
        lockingIntervalMs: Long = DEFAULT_LOCKING_INTERVAL,
        action: () -> R
    ): R {
        return globalLock.lockWithPCECheck(lockingIntervalMs) { action() }
    }
}

private const val DEFAULT_LOCKING_INTERVAL = 50L