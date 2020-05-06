package com.example.estadao.repository.local

import com.example.estadao.repository.local.general.resources.LocalGeneralResources


interface LocalFactory {
    val general: LocalGeneralResources
}