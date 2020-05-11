package Sistema

class Curso(nueva_asignatura : String, nueva_fecha : Fecha, nuevo_salon : Salon) {
    
    private var _asignatura : String = nueva_asignatura
    private var _fecha : Fecha = nueva_fecha
    private var _salon : Salon = nuevo_salon

    def getAsignatura() : String = _asignatura
    def getFecha() : Fecha = _fecha
    def getSalon() : Salon = _salon

}