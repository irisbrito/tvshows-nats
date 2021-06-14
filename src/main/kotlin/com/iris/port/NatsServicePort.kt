package com.iris.port

import com.iris.model.Serie

interface NatsServicePort {
    fun sendNats(serie: Serie): Serie
}