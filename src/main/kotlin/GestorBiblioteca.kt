package org.pebiblioteca

/**
 * Esta clase será el corazón de nuestro sistema, encargándose de la lógica para gestionar los libros y otros elementos
 */
class GestorBiblioteca(private val catalogo: Catalogo<Elemento>, private val gestorPrestamo: IGestorPrestamos) {


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
        gestorPrestamo.registrarPrestamos(libro, usuario)

    }

    /**
     *Registra la devolucion de un libro
     */
    fun registrarDevolucion(libro: Libro){
        gestorPrestamo.registrarDevolucion(libro)
    }


    fun consultarHistorialPrestamos(){
        GestorConsola.imprimirMensaje("Historial de prestamos: ")
        gestorPrestamo.consultarHistorial()
    }


}