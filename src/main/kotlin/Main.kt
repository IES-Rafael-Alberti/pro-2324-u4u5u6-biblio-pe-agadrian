package org.pebiblioteca

interface Elemento{
    val id: String
}

interface InterfaceLibro: Elemento{
    val titulo: String
    val autor: String
    val anioPubli: Int
    val tematica: String
    val estado: EstadoLibro
}


fun main() {
    println("Hello World!")
}