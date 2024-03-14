package org.pebiblioteca

/**
 * Gestor de lo relacionado con la consola
 */
object GestorConsola {

    /**
     * Imprime los mensajes pasados por paramtro en una nueva linea por defecto
     */
    fun imprimirMensaje(msg: String, lineaNueva: Boolean = true){
        if (lineaNueva) println(msg) else print(msg)
    }

}