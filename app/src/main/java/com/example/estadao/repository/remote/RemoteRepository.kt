package com.example.estadao.repository.remote

import com.autopass.autopay.repository.remote.update_management.producers.AutenticateLoginProducer
import com.example.estadao.repository.remote.estadao.RemoteNewsRepository
import com.example.estadao.repository.remote.estadao.resources.RemoteNewsResources
import com.example.estadao.repository.remote.estadao.services.NewsServices
import org.koin.core.KoinComponent
import org.koin.core.inject

class RemoteRepository : RemoteFactory, KoinComponent {

    private val newsServices: NewsServices by inject()

    override val news: RemoteNewsResources = RemoteNewsRepository(newsServices, AutenticateLoginProducer())

}