package Sistema

import util.control.Breaks._
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}


class Sistema {

    private var _clases : List[Curso] = Datos.BBDDCursos()
    private var _edificio : Edificio = new Edificio
    private var _reservas : List[Reserva] = Datos.BBDDReservas()
    private var _usuarios : List[Usuario] = Datos.BBDDUsuarios()
    private var _sesion : String = "CERRADA"
    private var _horarios_reservas : List[Horario] = Datos.BBDDHorarios()


    private var _tiempo_inicio_luz : Int = 5
    private var _tiempo_final_luz : Int = 10
    private var _tiempo_inicio_temp : Int = 10
    private var _tiempo_final_temp : Int = 5
    private var _tiempo_apertura_puertas : Int = 15 
    private var _tiempo_cierre_puertas : Int = 10

    def getSesion() : String = _sesion
    def getEdificio() : Edificio = _edificio
    def getHorarios() : List[Horario] = _horarios_reservas
    
    def setTiempoInicioLuz(nuevo_tiempo : Int ) : Unit = _tiempo_inicio_luz = nuevo_tiempo
    def setTiempoFinalLuz(nuevo_tiempo : Int ) : Unit = _tiempo_final_luz = nuevo_tiempo
    def setTiempoInicioAires(nuevo_tiempo : Int ) : Unit = _tiempo_inicio_temp = nuevo_tiempo
    def setTiempoFinalAires(nuevo_tiempo : Int ) : Unit = _tiempo_final_temp = nuevo_tiempo
    def setTiempoAperturaPuerta(nuevo_tiempo : Int ) : Unit = _tiempo_apertura_puertas = nuevo_tiempo
    def setTiempoCierrePuerta(nuevo_tiempo : Int ) : Unit = _tiempo_cierre_puertas = nuevo_tiempo

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

    def retornarPosSalon(nombre_salon : String) : Int =  {

        var pos : Int = 0

        for (salon <- _edificio.getSalones() ) {
            
            if (salon.getNombre() == nombre_salon)
                return pos
            pos = pos + 1
        }
        return -1
    }

    def inHabilitarSalon(nombre_salon : String) : Unit = {

        var band : Boolean = false
        var pos : Int =  retornarPosSalon(nombre_salon)

        if (pos != -1) {

            breakable {


                for (reserva <- _reservas) {
                    if (verificarReserva(_edificio.getSalones()(pos), reserva.getFecha() : Fecha) == true ) {
                        band  = true
                        break
                    }
                }
            }

            if (band == false) {
                _edificio.getSalones()(pos).setMantenimiento(true)
            }
        }
    }

    def habilitarSalon(nombre_salon : String) :  Unit = {

        var pos : Int = retornarPosSalon(nombre_salon)
            
        if (pos != -1) {
            _edificio.getSalones()(pos).setMantenimiento(false)
        }
    }

    def mostrarSalones(nombre_salon : String ) : Unit = {

        var contador : Int = 0
        var sal : Int = 1

        for (s <- _edificio.getSalones()) {

            if ( (s.getNombre().charAt(0)  == nombre_salon.charAt(0)) || (nombre_salon == "TODOS")) {

                println( "[" + sal + "] SALON " + s.getNombre()) 
                print("    HORARIO          ESTADO")                    

                for (f <- _horarios_reservas) {

                    if (f.getSalon().getNombre() == s.getNombre()) {

                        var opcion : Int = 1
                        for (h <- f.getHorariosReserva()) {
                            print("\n[" + opcion + "] [" + h._hora_inicio + ":00 - " + 
                            h._hora_final +":00] " + verEstadoSalon(s, h)  ) 
                            opcion = opcion + 1
                        }
                    }
                }

                sal = sal + 1
                println("\n")
            }
        }
    }

    def verEstadoSalon(salon : Salon, fecha : Fecha) : String = {
        
        var estado = "DISPONIBLE"
        var pos : Int = 0

        breakable {
            for (s <- _edificio.getSalones()) {
                if (s.getNombre() == salon.getNombre()) break
                pos = pos + 1
            }
        }

        // Verificacion estado del salón
        
        if (_edificio.getSalones()(pos).getMantenimiento() == true)
            estado = "En Mantenimiento"
        
        else  {

            // Busqueda salon en cursos
            var bandera : Boolean = false
            breakable {

                for ( c <- _clases) {
                    if (c.getSalon().getNombre() == salon.getNombre
                       && c.getFecha()._hora_inicio == fecha._hora_inicio
                       && c.getFecha()._hora_final == fecha._hora_final) {
                        estado = "Ocupado, clase de " + c.getAsignatura()
                        bandera = true
                        break
                    }
                }

            }
            // Busqueda salon en resevas 

            if (!bandera) {

                breakable {

                    for ( r <- _reservas) {
                        if (r.getSalon().getNombre() == salon.getNombre
                        && r.getFecha()._hora_inicio == fecha._hora_inicio
                        && r.getFecha()._hora_final == fecha._hora_final) {
                            estado = "RESERVADO"
                            break
                        }
                    }

                }
            }
        }

        return estado
    }

    def buscarSalonHorarios(nombre_salon : String) : Unit = {

        var existe : Boolean = false
        var pos : Int = 0

        breakable {

            for (salon <- _edificio.getSalones()) {
                if (salon.getNombre() == nombre_salon) {
                    existe = true
                    break
                }
                pos = pos + 1
            }
        }

        if (existe) {

            println("     SALON " + nombre_salon + " Temperatura: " + _edificio.getSalones()(pos).getTemperatura() + " C")

            for (f <- _horarios_reservas) {

                if (f.getSalon().getNombre() == _edificio.getSalones()(pos).getNombre()) {

                    var opcion : Int = 1
                    for (h <- f.getHorariosReserva()) {
                        print("\n[" + opcion + "] [" + h._hora_inicio + ":00 - " + 
                        h._hora_final +":00] " + verEstadoSalon(_edificio.getSalones()(pos), h)  ) 
                        opcion = opcion + 1
                    }
                }
            }

        }

        else {
            println("El salon " + nombre_salon + " no existe.")
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

    def actualizarEstadosSalon() : Unit = {

        val hoy = Calendar.getInstance().getTime()

        val formato_mes = new SimpleDateFormat("MM")
        val formato_dia = new SimpleDateFormat("dd")
        val formato_hora = new SimpleDateFormat("hh")
        val formato_minutos = new SimpleDateFormat("mm")
        val formato_amPm = new SimpleDateFormat("a")

        val mes_actual = formato_mes.format(hoy)
        val dia_actual = formato_dia.format(hoy)
        val hora_actual = formato_hora.format(hoy)
        val minutos_actual = formato_minutos.format(hoy)
        val amPm_actual = formato_amPm.format(hoy)
        

        for ( clase <- _clases) {

            

            if (clase.getFecha()._mes == mes_actual && clase.getFecha()._dia == dia_actual) {

                var h_reserva : Int = (clase.getFecha()._hora_inicio).toInt
                var h_actual : Int = (hora_actual).toInt
                var min_actual : Int = (minutos_actual).toInt

                // Encendiendo luces

                if ( h_actual + 1 == h_reserva && min_actual >= 55 && min_actual <= 59)  {

                    var pos : Int = 0

                    breakable {
                        for (salon <- _edificio.getSalones()) {
                            if (salon.getNombre() == clase.getSalon().getNombre() && amPm_actual == clase.getFecha()._amPm ) {
                                _edificio.getSalones()(pos).setLuz(true)
                                break
                            }
                            pos = pos + 1
                        }
                    }
                }

                h_reserva = (clase.getFecha()._hora_final).toInt

                if ( h_actual == h_reserva && min_actual >= 5 && min_actual <= 8)  {

                    var pos : Int = 0
                    var band : Boolean = false
                    
                    breakable {

                        for (c <- _clases) {
                            if (c.getSalon().getNombre() == clase.getSalon().getNombre()) {
                                band = true
                                break
                            }
                        }
                    }
                    breakable {

                        for (r <- _reservas) {
                            if (r.getSalon().getNombre() == clase.getSalon().getNombre()) {
                                band = true
                                break
                            }
                        }
                    }

                    if (!band) {

                        breakable {

                            for (salon <- _edificio.getSalones()) {
                                if (salon.getNombre() == clase.getSalon().getNombre() && amPm_actual == clase.getFecha()._amPm ) {
                                    _edificio.getSalones()(pos).setLuz(true)
                                    break
                                }
                                pos = pos + 1
                            }
                        }
                    }
                }
            } 

            // Apagando luces


            // Encendiendo Aires


            // Apagando Aires


            // Abriendo puertas 


            // Cerrando puertas

            /*if (rv.getFecha()._mes == mes_actual && rv.getFecha()._dia == dia_actual) {

                var h_reserva : Int = (rv.getFecha()._hora_inicio).toInt
                var h_actual : Int = (hora_actual).toInt
                var min_actual : Int = (minutos_actual).toInt

                if ( h_actual + 1 == h_reserva && min_actual >= 40 && min_actual <= 50)  {

                    var pos : Int = 0
                    breakable {
                        for (salon <- _edificio.getSalones()) {
                            if (salon.getNombre() == rv.getSalon().getNombre() && amPm_actual == rv.getFecha()._amPm ) {
                                _edificio.getSalones()(pos).setLuz(true)
                                break
                            }
                            pos = pos + 1
                        }
                    }
                }
            }*/
        }
    }

    def modificarTemperatura(nombre_salon : String, nueva_temp : Double) : Unit = {
    
        var pos : Int = 0

        breakable {
            for (salon <- _edificio.getSalones()) {
                if (salon.getNombre() == nombre_salon) {
                    _edificio.getSalones()(pos).setTemperatura(nueva_temp)
                    break
                }
                pos = pos + 1
            }
        }
    }

          
}