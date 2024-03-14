package org.pebiblioteca

/**
 * Data class que represent un libro
 */
data class Libro(
    override val id: String,
    override val titulo: String,
    override val autor: String,
    override val anioPubli: Int,
    override val tematica: String,
    override var estado: EstadoLibro = EstadoLibro.DISPONIBLE): InterfaceLibro{
        init {
            require(titulo.isNotBlank()) {"El titulo no puede estar vacio"}
            require(autor.isNotBlank()){"El autor no puede estar vacio"}
            require(anioPubli in 1..2024) {"El año debe estar entre 1-2024"}
            require(tematica.isNotBlank()){"El titulo no puede estar vacio"}
        }


    }


enum class EstadoLibro{
    DISPONIBLE,
    PRESTADO
}