package org.pebiblioteca

/**
 * Gestor de lo relacionado con la consola
 */
object GestorConsola {

    fun imprimirMensaje(msg: String, lineaNueva: Boolean = true){
        if (lineaNueva) println(msg) else print(msg)
    }

}