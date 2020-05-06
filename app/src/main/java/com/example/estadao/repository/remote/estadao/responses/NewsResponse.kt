package com.example.estadao.repository.remote.estadao.responses

data class NewsResponse(
    val chapeu: String,
    val data_hora_publicacao: String,
    val id_documento: String,
    val imagem: String,
    val linha_fina: String,
    val source: String,
    val titulo: String,
    val url: String
)
