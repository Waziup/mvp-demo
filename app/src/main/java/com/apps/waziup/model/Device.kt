package com.apps.waziup.model

import com.apps.waziup.util.BigDecimalConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.math.BigDecimal
import java.util.*

/**
 * Immutable POJO that represents a ProjectOld
 * Created by askia on 2/25/2018.
 */
@Entity
data class Device(
        @Id var id: Long = 0,
        var type: String? = "Farm",
        var name: String? = null,
        var description: String? = null,
        var position: Int = 0,
        @Convert(dbType = String::class, converter = BigDecimalConverter::class)
        var latitude: BigDecimal? = null,
        @Convert(dbType = String::class, converter = BigDecimalConverter::class)
        var longitude: BigDecimal? = null,
        var data: String? = null,
        var date: Date? = null,

        var isPublic: Boolean = false
)