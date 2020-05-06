package com.autopass.autopay.repository.remote.update_management.producers

import com.example.estadao.repository.remote.estadao.model.Login

class AutenticateLoginProducer {

    fun execute(user: String, pass: String): Login {
        return Login(user = user, pass = pass)
    }
}