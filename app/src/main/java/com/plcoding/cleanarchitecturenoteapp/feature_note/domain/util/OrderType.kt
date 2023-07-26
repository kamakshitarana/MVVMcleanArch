package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util


//step: 5  to pass the parameter in the getNotes class
sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}