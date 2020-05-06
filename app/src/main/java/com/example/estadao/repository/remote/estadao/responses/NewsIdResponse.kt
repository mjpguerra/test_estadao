package com.example.estadao.repository.remote.estadao.responses

data class NewsIdResponse(
    val imagem: String = "",
    val titulo: String = "",
    val linhafina: String = "",
    val editoria: String = "",
    val credito: String = "",
    val origem: String = "",
    val datapub: String = "",
    val horapub: String = ""
)
