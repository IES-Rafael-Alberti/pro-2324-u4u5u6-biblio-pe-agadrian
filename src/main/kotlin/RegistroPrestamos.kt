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
        val infoPrestamo = "ID Libro: ${libro.getID()} - Libro: ${libro.getTitulo()} - Autor: ${libro.getAutor()} - AñoPubliacion: ${libro.getAnioPubli()} - Tematica: ${libro.getTematica()}"

        // Verificar si la ID del libro ya tiene una lista de prestamos, si no la creamos
        if (!prestamosActuales.containsKey(libro.getID())) {
            prestamosActuales[libro.getID()] = mutableListOf(infoPrestamo)
        }

        if(libro.getEstado() == EstadoLibro.DISPONIBLE){
            // Agregar prestamo a la lista de prestamos actuales
            prestamosActuales[libro.getID()]?.add("ID Usuario: ${usuario.id}") ?: GestorConsola.imprimirMensaje("Error al añadir el prestamo del libro con id: ${libro.getID()}")

            //agregamos el libro prestado al usuario
            usuario.librosPrestados.add(libro)
            GestorConsola.imprimirMensaje("Libro ${libro.getTitulo()} prestado a ${usuario.nombre} correctamente")

            // Registrar el préstamo en el historial
            if (!historialPrestamos.containsKey(libro.getID())) {
                historialPrestamos[libro.getID()] = mutableListOf(infoPrestamo)
            } else {
                historialPrestamos[libro.getID()]?.add(infoPrestamo)
            }

            libro.modificarEstado()
        }else{
            GestorConsola.imprimirMensaje("Error - El libro ${libro.getTitulo()} esta prestado actualmente!")
        }

    }

    /**
     * Registra la devolucion de un libro. El libro se elimina de prestamos actuales.
     */
    fun registrarDevolucion(libro: Libro) {
        if (prestamosActuales.containsKey(libro.getID())) {
            prestamosActuales.remove(libro.getID())
            libro.modificarEstado()
            GestorConsola.imprimirMensaje("Devolución registrada con éxito para el libro con Nombre: ${libro.getTitulo()} y ID ${libro.getID()}.")
        } else {
            GestorConsola.imprimirMensaje("Error - El libro con Titulo: ${libro.getTitulo()}  y ID ${libro.getID()} no tiene préstamos activos.")
        }
    }


    /**
     * Retorna el historial de prestamos de un libro a traves de su uuid
     */
    fun consultarHistorialPrestamosLibro(libro: Libro) {
        if (historialPrestamos.containsKey(libro.getID())){
            return historialPrestamos.filter { it.key == libro.getID() }.forEach { println(it) }
        }

    }


    /**
     * Retorna el historial de prestamos a una persona a traves de su id
     */
    fun consultarHistorialUsuario(usuario: Usuario) {
        return usuario.librosPrestados.forEach{ println(it) }
    }


    /**
     * Retorna el historial de todos los prestamos
     */
    fun consultarHistorialTodosPrestamos(){
        return historialPrestamos.forEach { println("${it.key} ->  ${it.value}") }
    }


}

