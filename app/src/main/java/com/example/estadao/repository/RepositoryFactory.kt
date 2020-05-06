package com.example.estadao.repository

import com.example.estadao.repository.local.LocalFactory
import com.example.estadao.repository.remote.RemoteFactory


interface RepositoryFactory {
    val local: LocalFactory
    val remote: RemoteFactory
}