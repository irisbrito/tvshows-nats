package com.iris.controller

import com.iris.core.model.Serie
import com.iris.core.port.SerieServicePort
import com.iris.entrypoint.controller.SerieController
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.UUID

class SerieControllerTest : AnnotationSpec() {

    val service = mockk<SerieServicePort>()
    val serieController = SerieController(service)
    lateinit var serie : Serie
    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")


    @BeforeEach
    fun setUp(){
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should send serie to create`(){
        every {service.send(any()) } answers {serie}
        val result = serieController.create(serie).body()
        result shouldBe serie
    }

}