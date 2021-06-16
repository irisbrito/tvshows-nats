package com.iris.controller

import com.iris.model.Serie
import com.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/series")
class SerieController(private val serieService: SerieService) {

    private val logger = LoggerFactory.getLogger(SerieController::class.java)

    @Post
    fun create(@Body serie: Serie): HttpResponse<Any> {
        serieService.send(Serie(UUID.randomUUID(), serie.name, serie.description, serie.description, serie.whereToWatch))
        logger.info("Saving serie! $serie")
        return HttpResponse.created(HttpStatus.ACCEPTED).body(this.serieService.send(serie))

    }

    @Put("/{id}")
    fun update(@PathVariable uuid: UUID, @Body serie: Serie): HttpResponse<Serie> {
        serieService.send(Serie(serie.id, serie.name, serie.description, serie.description, serie.whereToWatch))
        return HttpResponse.ok(HttpStatus.OK).body(this.serieService.send(serie))
    }
}