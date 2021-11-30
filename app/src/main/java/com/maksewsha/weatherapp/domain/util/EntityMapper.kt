package com.maksewsha.weatherapp.domain.util

interface EntityMapper <Entity, Model> {

    fun mapFromEntity(entity: Entity): Model
}