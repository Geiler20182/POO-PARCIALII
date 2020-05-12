package Test

import scala.io._
import scala.util._
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
            opcion = opcion.toUpperCase()
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

            else if (opcion == "D") {
                cierreSistema = true
            }

            else {
                print("\nOpcion incorrecta")
            }

        }

        else if (sistema.getSesion() == "ESTUDIANTE") {

            menuSistemaUsuario()
            menuEstudiante()
            println("\nIngrese una opcion")
            opcion = StdIn.readLine()
            opcion = opcion.toUpperCase()

            if (opcion == "A") {
                
                println("Ingrese el nombre del salon")
                var nombre_salon : String = StdIn.readLine()
                print("\n")
                sistema.buscarSalonHorarios(nombre_salon)        
            }
            
            else if (opcion == "B") {
                sistema.mostrarSalones("TODOS")
            }

            else if (opcion == "1") {
                sistema.mostrarSalones("TODOS")
                println("Ingrese el nombre del salon que desea reservar")
                var nombre_salon : String = StdIn.readLine()

                if (sistema.buscarSalon(nombre_salon)) {
                    
                    println("\nHa seleccionado : \n")
                    sistema.buscarSalonHorarios(nombre_salon)      
                    println("\n\nIngrese el numero del horario")
                    var numero_horario : Try[Int] = Try(StdIn.readLine().toInt)

                    
                    numero_horario  match {

                        case Success(s) => {

                            if (sistema.retornarFecha(s) != null) {
                                var pos_salon : Int = sistema.retornarPosSalon(nombre_salon)
                                val salon = sistema.getEdificio().getSalones()(pos_salon)
                                val fecha = sistema.retornarFecha(s)

                                if (!(sistema.verificarReserva(salon , fecha)) 
                                   && !(sistema.verificarClase(salon, fecha)) ) {
                                    
                                    println("\nRequiere refrigerio s/n")
                                    var ref : String = StdIn.readLine().toUpperCase()

                                    if (ref == "S") {

                                        println("\nDigite la cantidad de refrigerios")
                                        var cant_ref : Try[Int] = Try(StdIn.readLine().toInt)
                                        cant_ref match {

                                            case Success(s) => {
                                                sistema.reservar(s, salon, fecha)
                                                println("\nReserva realizada correctamente (con " + s + " refriferios)\n")
                                            } 
                                            case Failure(f) => println("\nError, finalizando reserva....\n") 

                                        }
                                    }

                                    else {
                                        sistema.reservar(0, salon, fecha)
                                        println("\nReserva realizada correctamente (sin refrigerios)\n")
                                    }

                                }
                                else {
                                    println("\nHorario no disponible")
                                }
                            }

                            else {
                                println("\nError, el horario seleccionado no existe")
                            }
                        }

                        case Failure(f) => println("\nEl valor debe ser un numero entero entre ]1, 6[")
                    }
                }

                else {
                    println("\nError, el salon no existe")
                }
                
            }
            else if (opcion == "2") {

            }
            else if (opcion == "3") {
                sistema.setSesion("CERRADA")
            }
        }

        else if (sistema.getSesion() == "ADMINISTRADOR") {
            
            menuSistemaUsuario()
            menuAdministrador()

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

            else if (opcion == "1") {
                
                println("\nIngrese el nombre del salon a Inhabilitar")
                var nombre_salon : String = StdIn.readLine()
                sistema.inHabilitarSalon(nombre_salon)
            }

            else if (opcion == "2") {
            
                println("\nIngrese el nombre del salon a habilitar")
                var nombre_salon : String = StdIn.readLine()
                sistema.habilitarSalon(nombre_salon)

            }

            else if (opcion == "3"){

                println("\nIngrese el nombre del salon que desea cambiar la temperatura")
                var nombre_salon : String = StdIn.readLine()

                if (sistema.buscarSalon(nombre_salon)) {

                    println("Ingrese la nueva temperatura")

                    var temperatura : Try[Double] = Try(StdIn.readLine().toDouble)
                    
                    temperatura match {

                        case Success(s) => {
                            sistema.modificarTemperatura(nombre_salon, s)
                            println("\nTemperatura cambiada correctamente")
                        }

                        case Failure(f) => println("\nLa temperatura debe ser un numero")
                    }
                    

                }
                else {
                    println("Error, El salon no existe")
                }
            }
            
            else if (opcion == "4") {

                println("Ingrese el nuevo tiempo de inicio para encender las luces antes de empezar una clase/reseva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)

                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoInicioLuz(s)
                    }
                    case Failure(f) => println("\nEl tiempo de ser un numero entero")
                }
            }

            else if (opcion == "5") {

                println("Ingrese el nuevo tiempo para apagar las luces despues de terminar una clase/reserva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)
                
                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoFinalLuz(s)
                    }
                    case Failure(f) =>  println("\nEl tiempo de ser un numero entero")
                }
            }

            else if (opcion == "6") {

                println("Ingrese el nuevo tiempo para la apertura de las puertas antes de iniciar una clase/reserva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)
                
                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoAperturaPuerta(s)
                    }
                    case Failure(f) =>  println("\nEl tiempo de ser un numero entero")
                }
            }

            else if (opcion == "7") {

                println("Ingrese el nuevo tiempo para cerrar las puertas despues de terminar una clase/reserva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)
                
                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoCierrePuerta(s)
                    }
                    case Failure(f) =>  println("El tiempo de ser un número entero")
                }
            }

            else if (opcion == "8") {

                println("Ingrese el nuevo tiempo para encender los aires antes de iniciar la clase/reserva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)
                
                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoInicioAires(s)
                        println("\nTiempo cambiado correctamente")
                    }
                    case Failure(f) =>  println("El tiempo de ser un número entero")
                }
            }

            else if (opcion == "9") {

                println("Ingrese el nuevo tiempo para apagar los aires despues de finalizar la clase/reserva (min)")
                var tiempo : Try[Int] = Try(StdIn.readLine().toInt)
                
                tiempo match {

                    case Success(s) => {
                        sistema.setTiempoFinalAires(s)
                        println("\nTiempo cambiado correctamente")
                    }
                    case Failure(f) =>  println("\nEl tiempo de ser un numero entero")
                }
            }

            else if (opcion == "10") {
                sistema.setSesion("CERRADA")
            }

            else {
                println("\nOpcion incorrecta")
            }   
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
        println("[8] Cambiar el tiempo de encendido (Aires)")
        println("[9] Cambiar el tiempo de apagado (Aires)")
        println("[10] Salir")
    }

    def menuEstudiante() : Unit = {
        
        println("[1] Reservar un salon")
        println("[2] Cancelar reserva")
        println("[3] Salir")

    }
}