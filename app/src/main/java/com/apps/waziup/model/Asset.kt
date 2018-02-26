package com.apps.waziup.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

/**
 * Immutable POJO that represents a ProjectOld
 * Created by askia on 2/25/2018.
 */
@Entity
data class Asset(
        @Id var id: Long = 0,
        var type: String? = "Farm",
        var name: String? = null,
        var description: String? = null,
        var position: Int = 0,
        var latitude: Short? = null,
        var longitude: Short? = null,
        var data: String? = null,
        var date: Date? = null,

        var isPublic: Boolean = false
)