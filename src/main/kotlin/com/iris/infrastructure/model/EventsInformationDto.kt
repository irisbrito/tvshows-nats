package com.iris.infrastructure.model

import com.iris.core.model.Serie
import java.util.*

data class EventsInformationDto(
    val events: Events = Events.SAVE_SERIE,
    val product: Serie = Serie(UUID.fromString(""),"", "","","")
)
