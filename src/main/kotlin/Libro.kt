package org.pebiblioteca

/**
 * Data class que represent un libro
 */
data class Libro(
    override val id: String,
    private val titulo: String,
    private val autor: String,
    private val anioPubli: Int,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
): Elemento{
    init {
        require(titulo.isNotBlank()) {"El titulo no puede estar vacio"}
        require(autor.isNotBlank()){"El autor no puede estar vacio"}
        require(anioPubli in 1..2024) {"El año debe estar entre 1-2024"}
        require(tematica.isNotBlank()){"El titulo no puede estar vacio"}
    }

    fun getID(): String{
        return id
    }

    fun getTitulo(): String {
        return titulo
    }

    fun getAutor(): String{
        return autor
    }

    fun getAnioPubli(): Int{
        return anioPubli
    }

    fun getTematica(): String{
        return tematica
    }

    fun getEstado(): EstadoLibro{
        return estado
    }

    fun modificarEstado(){
        estado = if (estado == EstadoLibro.DISPONIBLE) EstadoLibro.PRESTADO else EstadoLibro.DISPONIBLE

    }



}





enum class EstadoLibro{
    DISPONIBLE,
    PRESTADO
}