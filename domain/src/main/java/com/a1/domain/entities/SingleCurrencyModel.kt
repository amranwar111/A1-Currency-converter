package com.a1.domain.entities

class SingleCurrencyModel(val name: String, val amount: String) {
    override fun toString(): String {
        return name
    }
}