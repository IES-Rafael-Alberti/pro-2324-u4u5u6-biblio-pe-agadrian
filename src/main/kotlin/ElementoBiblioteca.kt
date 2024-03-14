package org.pebiblioteca

abstract class ElementoBiblioteca {

    abstract val id: Int
    abstract val titulo: Int
    abstract val estado: EstadoElemento



}

interface Prestable{
    fun prestar()
    fun devolver()
}