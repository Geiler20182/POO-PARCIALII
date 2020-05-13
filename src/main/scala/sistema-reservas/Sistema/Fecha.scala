package Sistema

class Fecha(nueva_hora_in : String, nueva_hora_fi : String, actual : String) {

    var _hora_inicio : String = nueva_hora_in
    var _hora_final : String = nueva_hora_fi
    var _amPm : String = actual
    var _disponible : Boolean = true

    def setDisponible(cambio_disp : Boolean) : Unit = _disponible = cambio_disp
}