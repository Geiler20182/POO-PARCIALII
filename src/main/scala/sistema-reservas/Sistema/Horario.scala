package Sistema

class Horario(salon : Salon, nuevas_fechas : List[Fecha]) {

    private var _salon : Salon = salon
    private var _horarios :  List[Fecha] = nuevas_fechas

    def getSalon() : Salon = _salon
    def getHorariosReserva() : List[Fecha] = _horarios
}