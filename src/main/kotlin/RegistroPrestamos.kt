package org.pebiblioteca

interface IGestorPrestamos{
    fun registrarPrestamos(libro: Libro, usuario: Usuario)
    fun registrarDevolucion(libro: Libro)
    fun consultarHistorial()

}


/**
 * Mantendrá un registro de los préstamos actuales y un historial de todos los préstamos realizados, permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de libros específicos o usuarios.
 */
class RegistroPrestamos: IGestorPrestamos {

    private val prestamosActuales = mutableMapOf<String, MutableList<String>>()
    private val historialPrestamos = mutableMapOf<String, MutableList<String>>()


    /**
     * Registra el prestamo de un libro
     */
    override fun registrarPrestamos(libro: Libro, usuario: Usuario) {
        val infoPrestamo = "ID Libro: ${libro.getID()} - Libro: ${libro.getTitulo()} - Autor: ${libro.getAutor()} - AñoPubliacion: ${libro.getAnioPubli()} - Tematica: ${libro.getTematica()}"

        // Verificar si la ID del libro ya tiene una lista de prestamos, si no la creamos
        if (!prestamosActuales.containsKey(libro.getID())) {
            prestamosActuales[libro.getID()] = mutableListOf(infoPrestamo)
        }

        if(libro.getEstado() == EstadoElemento.DISPONIBLE){
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
    override fun registrarDevolucion(libro: Libro) {
        if (prestamosActuales.containsKey(libro.getID())) {
            prestamosActuales.remove(libro.getID())
            libro.modificarEstado()
            GestorConsola.imprimirMensaje("Devolución registrada con éxito para el libro con Nombre: ${libro.getTitulo()} y ID ${libro.getID()}.")
        } else {
            GestorConsola.imprimirMensaje("Error - El libro con Titulo: ${libro.getTitulo()}  y ID ${libro.getID()} no tiene préstamos activos.")
        }
    }




    /**
     * Retorna el historial de todos los prestamos
     */
    override fun consultarHistorial(){
        return if (historialPrestamos.isNotEmpty())historialPrestamos.forEach { println("${it.key} ->  ${it.value}") } else GestorConsola.imprimirMensaje("Historial vacio")
    }




}

