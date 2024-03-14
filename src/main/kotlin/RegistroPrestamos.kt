package org.pebiblioteca

/**
 * Mantendrá un registro de los préstamos actuales y un historial de todos los préstamos realizados, permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de libros específicos o usuarios.
 */
class RegistroPrestamos {

    private val prestamosActuales = mutableMapOf<String, MutableList<String>>()
    private val historialPrestamos = mutableMapOf<String, MutableList<String>>()


    /**
     * Registra el prestamo de un libro
     */
    fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        val infoPrestamo = "ID Libro: ${libro.id} - Libro: ${libro.titulo} - Autor: ${libro.autor} - AñoPubliacion: ${libro.anioPubli} - Tematica: ${libro.tematica}"

        // Verificar si la ID del libro ya tiene una lista de prestamos, si no la creamos
        if (!prestamosActuales.containsKey(libro.id)) {
            prestamosActuales[libro.id] = mutableListOf(infoPrestamo)
        }

        if(libro.estado == EstadoLibro.DISPONIBLE){
            // Agregar prestamo a la lista de prestamos actuales
            prestamosActuales[libro.id]?.add("ID Usuario: ${usuario.id}") ?: GestorConsola.imprimirMensaje("Error al añadir el prestamo del libro con id: ${libro.id}")

            //agregamos el libro prestado al usuario
            usuario.librosPrestados.add(libro)

            // Registrar el préstamo en el historial
            if (!historialPrestamos.containsKey(libro.id)) {
                historialPrestamos[libro.id] = mutableListOf(infoPrestamo)
            } else {
                historialPrestamos[libro.id]?.add(infoPrestamo)
            }

            libro.estado = EstadoLibro.PRESTADO
        }else{
            GestorConsola.imprimirMensaje("El libro esta prestado actualmente!")
        }

    }

    /**
     * Registra la devolucion de un libro. El libro se elimina de prestamos actuales.
     */
    fun registrarDevolucion(libro: Libro) {
        if (prestamosActuales.containsKey(libro.id)) {
            prestamosActuales.remove(libro.id)
            libro.estado = EstadoLibro.DISPONIBLE
            GestorConsola.imprimirMensaje("Devolución registrada con éxito para el libro con ID ${libro.id}.")
        } else {
            GestorConsola.imprimirMensaje("El libro con ID ${libro.id} no tiene préstamos activos.")
        }
    }


    /**
     * Retorna el historial de prestamos de un libro a traves de su uuid
     */
    fun consultarHistorialLibros(libro: Libro): List<String>? {
        if (historialPrestamos.containsKey(libro.id)){
            return historialPrestamos[libro.id]?.toList()!!
        }
        return null
    }


    /**
     * Retorna el historial de prestamos a una persona a traves de su id
     */
    fun consultarHistorialUsuario(usuario: Usuario): List<Libro> {
        return usuario.librosPrestados.toList()
    }

    fun consultarPrestamosActuales(): MutableSet<String> {
        return prestamosActuales.keys
    }

}

