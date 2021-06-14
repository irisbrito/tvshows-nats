package com.iris.service

import com.iris.model.Serie
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun send(serie: Serie): Serie
}