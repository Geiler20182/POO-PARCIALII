package Test

import Sistema._
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}


object Test {

    def main(args: Array[String]) : Unit = {

        var sistema : Sistema =  new Sistema

        println("\n---------------------")
        //sistema.mostrarSalones("LA") 
        sistema.modificarTemperatura("LA1.0", 58.4)
        sistema.inHabilitarSalon("LA1.4")
        sistema.buscarSalonHorarios("LA1.4")
        println("\n---------------------\n")

        /*


        for ( h <- sistema.getHorarios()) {
            println(h.getSalon().getNombre())
            for (f <- h.getHorariosReserva() ) {
                if (f._dia == "06") {
                    print(f._hora_inicio + " ")
                }
            }
            print("\n")
        }
        
        
        sistema.iniciarSesion("geiler", "123")

        println(sistema.getSesion())
        println(sistema.buscarSalon("LA1.0"))

        val hoy = Calendar.getInstance (). getTime ()
    
        // crea los formateadores de fecha / hora
        val day = new SimpleDateFormat("dd")
        val mes =  new SimpleDateFormat("MM")
        val minuteFormat = new SimpleDateFormat ("mm")
        val hourFormat = new SimpleDateFormat ("hh")
        val amPmFormat = new SimpleDateFormat ("a")

        val currentHour = hourFormat.format (hoy) // 12
        val currentMinute = minuteFormat.format (hoy) // 29
        val amOrPm = amPmFormat.format (hoy) // PM
        val currentDay = day.format(hoy)
        val currentMes = mes.format(hoy)

        println(currentHour)
        println(currentMinute)
        println(amOrPm)
        println(currentDay)
        println(currentMes)*/
    }       

}
