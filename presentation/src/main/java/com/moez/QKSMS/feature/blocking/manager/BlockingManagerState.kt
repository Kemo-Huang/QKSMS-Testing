package com.moez.QKSMS.feature.blocking.manager

data class BlockingManagerState(
    val blockingManager: Int = 0,
    val callControlInstalled: Boolean = false,
    val siaInstalled: Boolean = false
)
