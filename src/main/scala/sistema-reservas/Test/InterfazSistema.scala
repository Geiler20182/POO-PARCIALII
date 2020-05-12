package Test

import scala.io._
import Sistema._

object InterfazSistema  extends App {

    var cierreSistema : Boolean = false 
    var sistema : Sistema = new Sistema

    while(!cierreSistema) {

        var opcion : String = ""

        println("\n")
        if (sistema.getSesion() == "CERRADA") {
            
            menuSistema()
            println("\nIngrese una opcion")
            opcion = StdIn.readLine()

            if (opcion == "A") {
                
                println("Ingrese el nombre del salon")
                var nombre_salon : String = StdIn.readLine()
                print("\n")
                sistema.buscarSalonHorarios(nombre_salon)        
            }
            
            else if (opcion == "B") {
                sistema.mostrarSalones("TODOS")
            }

            else if (opcion == "C") {
                
                var estado_sesion : String = sistema.getSesion()
                println("\nUsuario")
                var usuario : String = StdIn.readLine()
                println("Contrasena")
                var contrasena : String = StdIn.readLine()

                sistema.iniciarSesion(usuario, contrasena)
                if (estado_sesion != sistema.getSesion()) {
                    println("\nLogeado correctamente como " + sistema.getSesion())
                }
                else {
                    println("\nUsuario o Contrasena incorrectos")
                }
            }

            //else if (opcion == "D") {

            //}

        }

        else if (sistema.getSesion() == "ESTUDIANTE") {
            menuSistemaUsuario()
            menuEstudiante()
            cierreSistema = true
        }

        else if (sistema.getSesion() == "ADMINISTRADOR") {
            
            menuSistemaUsuario()
            menuAdministrador()

            if (opcion == "A") {

            }

            else if (opcion == "B") {

            }

            else if (opcion == "1") {

            }
            else if (opcion == "2") {

            }
            else if (opcion == "3") {

            }
            else if (opcion == "4") {

            }
            else if (opcion == "5") {

            }
            else if (opcion == "6") {

            }
            else if (opcion == "7") {

            }
            else if (opcion == "8") {
                cierreSistema = true
            }

            cierreSistema = true
        }

        else {
            println("\nOpcion incorrecta")
        }

        println("\n")
    }


    def menuSistemaUsuario() : Unit = {

        println("[A] Buscar salon")
        println("[B] Ver horarios")
    }

    def menuSistema() : Unit = {

        println("[A] Buscar salon")
        println("[B] Ver horarios")
        println("[C] Iniciar Sesion")
        println("[D] Salir")
    }

    def menuAdministrador() : Unit = {

        println("[1] Inhabilitar Salon")
        println("[2] Habilitar Salon")
        println("[3] Cambiar temperatura salon")
        println("[4] Cambiar el tiempo de encendido (Luz)")
        println("[5] Cambiar el tiempo de apagado (Luz)")
        println("[6] Cambiar el tiempo apertura (Puerta)")
        println("[7] Cambiar el tiempo cierre (Puerta)")
        println("[8] Salir")
    }

    def menuEstudiante() : Unit = {
        
        println("[1] Reservar un salon")
        println("[2] Cancelar reserva")
        println("[3] Salir")

    }
}