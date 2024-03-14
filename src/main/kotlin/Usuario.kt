package org.pebiblioteca

/**
 * Representará a los usuarios de la biblioteca, conteniendo información como ID, nombre, y una lista de libros prestados.
 */
data class Usuario(
    val id: Int,
    val nombre: String,
    val librosPrestados: MutableList<Libro>)
