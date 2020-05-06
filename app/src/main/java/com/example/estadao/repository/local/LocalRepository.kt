package com.example.estadao.repository.local

import android.content.Context
import com.example.estadao.repository.local.general.LocalGeneralRepository
import com.example.estadao.repository.local.general.resources.LocalGeneralResources
import org.koin.core.KoinComponent

class LocalRepository(applicationContext: Context) : LocalFactory, KoinComponent {

    override val general: LocalGeneralResources = LocalGeneralRepository(applicationContext)

}