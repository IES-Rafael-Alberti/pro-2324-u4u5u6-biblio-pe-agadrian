package org.pebiblioteca

/**
 * Utilidades extra para gestionar biblioteca
 */
class UtilidadesBiblioteca {


    interface CreadorID{
        fun crearIDUnica(): Any
    }

    /**
     * Objeto estatico para crear UUIDS unica para libros
     */
    object CreadoUUID: CreadorID{
        private var idUnica = 0
        /**
         * Autoincrementa y devuelve una id unica con formato de UUID
         */
        override fun crearIDUnica(): String {
            idUnica++
            return "000-00${idUnica + 1}"
        }
    }


    /**
     * Objeto estatico para crear ID unica para usuarios
     */
    object CreadorIdUsers: CreadorID{
        private var idUsuario = 0
        override fun crearIDUnica(): Int{
            idUsuario++
            return idUsuario
        }
    }

}
