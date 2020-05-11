package Sistema

class Reserva (cant_refrigerios : Int, fecha_reserva : Fecha, salon : Salon) {

    private var _refrigerios : Int = cant_refrigerios
    private var _fecha: Fecha = fecha_reserva
    private var _salon : Salon = salon

    def getSalon() : Salon = _salon
    def getRefrigerios() : Int = _refrigerios
    def getFecha() : Fecha = _fecha
}