package com.iris.core.port

import com.iris.core.model.Serie
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun send(serie: Serie): Serie
}