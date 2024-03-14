package org.pebiblioteca

interface Elemento{
    val id: String
}

interface InterfaceLibro: Elemento{
    val titulo: String
    val autor: String
    val anioPubli: Int
    val tematica: String
    val estado: EstadoLibro
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


    // Realizar al menos dos préstamo y dos devoluciones. Tanto un préstamo, como una devolución tiene que ser errónea, debido al estado del libro.

    val usuario1 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Diego", mutableListOf())
    val usuario2 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Diegin", mutableListOf())

    print("Prestando libro ${libro.titulo} a ${usuario1.nombre}... ")
    gestionBiblioteca.registrarPrestamo(libro, usuario1)

    print("Prestando libro ${libro.titulo} a ${usuario2.nombre}... ")
    gestionBiblioteca.registrarPrestamo(libro, usuario2)

    print("Prestando libro ${libro2.titulo} a ${usuario2.nombre}... ")
    gestionBiblioteca.registrarPrestamo(libro2, usuario2)

    print("Devolviendo libro ${libro.titulo}... ")
    gestionBiblioteca.registrarDevolucion(libro)

    print("Devolviendo libro ${libro.titulo}... ")
    gestionBiblioteca.registrarDevolucion(libro)


    //Mostrar el estado actual de los libros.
    println(gestionBiblioteca.consultarDisponibilidad(libro))
    println(gestionBiblioteca.consultarDisponibilidad(libro2))
    println(gestionBiblioteca.consultarDisponibilidad(libro3))











}