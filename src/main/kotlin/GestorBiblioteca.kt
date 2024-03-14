package org.pebiblioteca

/**
 * Esta clase será el corazón de nuestro sistema, encargándose de la lógica para gestionar los libros y otros elementos
 */
class GestorBiblioteca(private val catalogo: Catalogo<Elemento>, private val registroPrestamos: RegistroPrestamos) {


    /**
     * Agrega el elemento pasado por parametro a el catalgo
     */
    fun aniadirElementos(elemento: Elemento){
        catalogo.anadirElemento(elemento)
    }

    /**
     * Elimina el elemento pasado por parametro del catalgo
     */
    fun eliminarElemento(elemento: Elemento){
        catalogo.eliminarElemento(elemento)
    }

    /**
     * Registra un prestamo en registroPrestamo, de un libro y del usuario al que se le presta
     */
    fun registrarPrestamo(libro: Libro, usuario: Usuario){
        registroPrestamos.registrarPrestamo(libro, usuario)

    }

    /**
     *Registra la devolucion de un libro
     */
    fun registrarDevolucion(libro: Libro){
        registroPrestamos.registrarDevolucion(libro)
    }

    /**
     * Si el libro esta disponible, retorna True, si no False
     */
    fun consultarDisponibilidad(libro: Libro): String{
        if (libro.estado == EstadoLibro.DISPONIBLE) {
            return "Libro ${libro.titulo} disponible"
        }
        return "Libro ${libro.titulo} no disponible"
    }

}