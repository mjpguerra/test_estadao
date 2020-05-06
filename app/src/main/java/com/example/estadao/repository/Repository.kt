package com.example.estadao.repository

import android.content.Context
import com.example.estadao.repository.local.LocalFactory
import com.example.estadao.repository.local.LocalRepository
import com.example.estadao.repository.remote.RemoteFactory
import com.example.estadao.repository.remote.RemoteRepository

class Repository(applicationContext: Context) : RepositoryFactory {
    override val local: LocalFactory = LocalRepository(applicationContext)
    override val remote: RemoteFactory = RemoteRepository()
}