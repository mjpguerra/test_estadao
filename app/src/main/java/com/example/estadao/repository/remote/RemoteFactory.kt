package com.example.estadao.repository.remote

import com.example.estadao.repository.remote.estadao.resources.RemoteNewsResources

interface RemoteFactory {
    val news: RemoteNewsResources
}