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
    override var estado: EstadoLibro = EstadoLibro.DISPONIBLE): InterfaceLibro


enum class EstadoLibro{
    DISPONIBLE,
    PRESTADO
}