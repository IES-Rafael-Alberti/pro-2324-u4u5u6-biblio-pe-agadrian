package org.pebiblioteca

/**
 * Representará a los usuarios de la biblioteca, conteniendo información como ID, nombre, y una lista de libros prestados.
 */
class Usuario(
    val id: Int,
    val nombre: String,
    val librosPrestados: MutableList<Libro> = mutableListOf()
){


    /**
     * Agrega un libro a la lista
     */
    fun agregarLibro(libro: Libro){
        if (libro !in librosPrestados){
            librosPrestados.add(libro)
            GestorConsola.imprimirMensaje("Libro añadido correctamente")
        }else{
            GestorConsola.imprimirMensaje("Error - El libro ${libro.getTitulo()} ya esta en tus libros prestados")
        }
    }

    fun eliminarLibro(libro: Libro){
        if (libro in librosPrestados) {
            librosPrestados.remove(libro)
            GestorConsola.imprimirMensaje("Libro eliminado correctamente")
        }else{
            GestorConsola.imprimirMensaje("Error - El libro ${libro.getTitulo()} no esta en los prestados")
        }
    }

    fun consultarLibrosPrestados() {
        if (librosPrestados.isNotEmpty()) {
            GestorConsola.imprimirMensaje("Libros prestados a $nombre:")
            librosPrestados.forEach { println(it.getTitulo()) }
        } else {
            GestorConsola.imprimirMensaje("No hay libros prestados a $nombre.")
        }
    }

}
