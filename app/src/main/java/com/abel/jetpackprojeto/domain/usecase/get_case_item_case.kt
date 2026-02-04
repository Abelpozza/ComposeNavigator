package com.abel.jetpackprojeto.domain.usecase

import com.abel.jetpackprojeto.domain.model.HomeItem

class get_case_item_case {

    fun execute (): List<HomeItem> {
        return listOf(
            HomeItem("Acesso 1"),
            HomeItem("Acesso 2"),
            HomeItem("Acesso 3")

        )
    }
}