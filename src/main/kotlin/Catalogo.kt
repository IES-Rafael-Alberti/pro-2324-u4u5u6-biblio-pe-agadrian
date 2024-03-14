package org.pebiblioteca

/**
 * Alberga todos los elementos disponibles en la biblioteca. Facilita la organización y el acceso rápido a estos elementos.
 */
class Catalogo<T: Elemento> {

    private val elementos = mutableListOf<T>()

    /**
     * Añade el elemento pasado por parametro a la lista de elementos
     */
    fun anadirElemento(elemento: T){
        elementos.add(elemento)
    }

    /**
     * Elimina de la lista de elementos el pasado por parametro
     */
    fun eliminarElemento(elemento: T){
        // revisar
        val elementoEliminar = elementos.find { it.id == elemento.id }
        elementos.remove(elementoEliminar)
    }

    /**
     * Muestra la lista de elementos
     */
    fun mostrarElementos(){
        elementos.forEach { println(it) }
    }
}