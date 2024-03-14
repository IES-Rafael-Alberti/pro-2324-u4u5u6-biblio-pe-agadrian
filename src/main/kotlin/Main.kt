package org.pebiblioteca

interface Elemento{
    val id: String
}



fun main() {
    // Instanciar una GestorBiblioteca
    val catalogo = Catalogo<Elemento>()
    val registroPrestamos = RegistroPrestamos()
    val gestionBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Agregar al menos tres libros al catálogo.
    val libro = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Don Tomas", "Tomatin", 2023, "El dueño y señor")
    val libro2 = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Recetas", "Arguiñano", 2020, "Comida")
    val libro3 = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Peras", "Peritas", 1970, "Peras grandes")

    gestionBiblioteca.aniadirElementos(libro)
    gestionBiblioteca.aniadirElementos(libro2)
    gestionBiblioteca.aniadirElementos(libro3)


    // Ejercicio 3

    val usuario1 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(),"Diego", mutableListOf())
    val usuario2 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Diegin", mutableListOf())
    val usuario3 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Tomas", mutableListOf())

    gestionBiblioteca.registrarPrestamo(libro, usuario1)
    gestionBiblioteca.registrarPrestamo(libro2, usuario2)
    gestionBiblioteca.registrarPrestamo(libro3, usuario3)

    gestionBiblioteca.registrarDevolucion(libro)
    gestionBiblioteca.registrarPrestamo(libro, usuario2)

    // Historial de prestamos geeneral
    gestionBiblioteca.consultarHistorialPrestamos()

    // Libros prestados a un usuario en concreto
    gestionBiblioteca.consultarHistorialUsuario(usuario1)


    // Demostrar cómo se puede acceder a la información de los libros y usuarios de manera controlada a través de los métodos públicos sin exponer directamente las propiedades internas.

    println("Acceder a los valores de libro de forma segura:\nID Libro: ${libro.getID()} - Libro: ${libro.getTitulo()} - Autor: ${libro.getAutor()} - AñoPubliacion: ${libro.getAnioPubli()} - Tematica: ${libro.getTematica()}")












}