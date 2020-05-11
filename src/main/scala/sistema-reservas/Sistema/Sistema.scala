package Sistema

import util.control.Breaks._
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}


class Sistema {

    private var _edificio : Edificio = new Edificio
    private var _reservas : List[Reserva] = Datos.BBDDReservas()
    private var _usuarios : List[Usuario] = Datos.BBDDUsuarios()
    private var _sesion : String = "CERRADA"
    private var _horarios_reservas : List[Horario] = Datos.BBDDHorarios()
    
    def getSesion() : String = _sesion
    def getEdificio() : Edificio = _edificio
    def getHorarios() : List[Horario] = _horarios_reservas
    
    def iniciarSesion(correo : String, contrasena : String ) : Unit = {

        breakable {
            for ( user <- _usuarios) {

                if ( user.getUsuario() == correo && 
                     user.getContrasena() == contrasena ) {
                    _sesion = user.getTipo()
                    break
                }
            }
        }
    }

    def buscarSalon(nombre_salon : String) : Boolean = {

        for (salon <- _edificio.getSalones() ) {
            
            if (salon.getNombre() == nombre_salon)
                return true
        }

        return false
    }

    def inHabilitarSalon(salon : Salon) : Unit = {

        var band : Boolean = false
        var pos : Int = 0

        breakable {

            for (reserva <- _reservas) {
                if (verificarReserva(salon : Salon, reserva.getFecha() : Fecha) == true ) {
                    band  = true
                    break
                }
            }
        }

        if (band == false) {

            breakable {

                for (s <- _edificio.getSalones()) {
                    if (s.getNombre() == salon.getNombre()) {
                        _edificio.getSalones()(pos).setMantenimiento(true)
                        break
                    }
                    pos = pos + 1
                }
            }
        }

    }

    def habilitarSalon(salon : Salon) :  Unit = {

        var pos : Int = 0

        breakable {
        
            for (s <- _edificio.getSalones()) {
                if (s.getNombre() == salon.getNombre() && s.getMantenimiento() == true) {
                    _edificio.getSalones()(pos).setMantenimiento(false)
                    break
                }
                pos = pos + 1
            }
        }
    }

    def mostrarSalones(nombre_salon : String ) : Unit = {

        var contador : Int = 0
        breakable {
            var sal : Int = 1
            for (h <- _horarios_reservas ) {

                if (h.getSalon().getNombre().charAt(0)  == nombre_salon.charAt(0)) {

                    println("\n[" + sal + "] SALON " + h.getSalon().getNombre() ) 
                    verHorarioSalon(h)
                    sal = sal + 1
                }
                contador = contador + 1
                if (contador == 1) break 
                println()
            }
        }


    }

    def verHorarioSalon(h : Horario) : Unit = {

        
        print("\nHORARIO AM\t    ESTADO\n")   
        var cont : Int = 0
        var opcion : Int = 1

        for (f <- h.getHorariosReserva() ) {
            if (f._amPm == "AM" && f._dia == "10" && f._mes == "05") {

                var estado : String = "DISPONIBLE"

                if (f._disponible == false) {

                    estado = "RESERVADO"
                }
                
                print("\n[" + opcion + "] [" + f._hora_inicio + ":00 - " + f._hora_final +":00]" + " " + estado) 
                opcion = opcion + 1 
            }
            cont = cont + 1
        }

        print("\n\nHORARIO PM\t    ESTADO\n")   
        cont = 0

        for (f <- h.getHorariosReserva() ) {
            
            var estado : String = "DISPONIBLE"

            if (f._disponible == false) {
                estado = "RESERVADO"
            }
            if (f._amPm == "PM" && f._dia == "10" && f._mes == "05") {
                print("\n[" + opcion + "] [" + f._hora_inicio + ":00 - " + f._hora_final +":00]" + " " + estado) 
                opcion = opcion + 1 
            }
            cont = cont + 1
        }
       
    }

    def salonDisponible(salon : Salon) : Boolean = {
        
        for (s <- _edificio.getSalones()) {

            if (s.getNombre() == salon.getNombre() && s.getMantenimiento() == true) {
                return false
            } 
        }

        return true
    }

    def verificarReserva(salon : Salon, fecha : Fecha) : Boolean = {

        for (reserva <- _reservas) {
            if (reserva.getSalon().getNombre() == salon.getNombre() ) {
                return true
            }
        }
        return false
    }

    def reservar(refrigerios : Int, salon : Salon, fecha : Fecha) : Unit = {
        
        var nueva_reserva : Reserva = new Reserva(refrigerios, fecha, salon)
        _reservas = nueva_reserva :: _reservas
    } 

    def encerderLuces() : Unit = {

        val hoy = Calendar.getInstance().getTime()

        val formato_mes =new SimpleDateFormat("MM")
        val formato_dia = new SimpleDateFormat("dd")
        val formato_hora = new SimpleDateFormat("hh")
        val formato_minutos = new SimpleDateFormat("mm")
        val formato_amPm = new SimpleDateFormat("a")

        val mes_actual = formato_mes.format(hoy)
        val dia_actual = formato_dia.format(hoy)
        val hora_actual = formato_hora.format(hoy)
        val minutos_actual = formato_minutos.format(hoy)
        val amPm_actual = formato_amPm.format(hoy)

        
        for ( rv <-  _reservas) {

            if (rv.getFecha()._mes == mes_actual && rv.getFecha()._dia == dia_actual) {

                var h_reserva : Int = (rv.getFecha()._hora_final).toInt
                var h_actual : Int = (hora_actual).toInt

                println(h_reserva + " " + h_actual)
                println("MES: " + mes_actual)
            }
        }
    }

          
}