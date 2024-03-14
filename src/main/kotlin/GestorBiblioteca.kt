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
        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            return "Libro ${libro.getTitulo()} disponible"
        }
        return "Libro ${libro.getTitulo()} no disponible"
    }

    fun consultarHistorialPrestamos(){
        GestorConsola.imprimirMensaje("Historial de los libros prestados: ")
        registroPrestamos.consultarHistorialTodosPrestamos()
    }

    fun consultarHistorialUsuario(usuario: Usuario){
        GestorConsola.imprimirMensaje("Libros prestados al usuario ${usuario.nombre}: ")
        registroPrestamos.consultarHistorialUsuario(usuario)
    }

    fun consultarHistorialPrestamosLibro(libro: Libro){
        GestorConsola.imprimirMensaje("Historial de prestamos del libro: ${libro.getTitulo()}: ")
        registroPrestamos.consultarHistorialPrestamosLibro(libro)
    }

}