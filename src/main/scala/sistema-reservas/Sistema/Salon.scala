package Sistema

class Salon(nuevo_nombre : String, nueva_cap_max : Int) {

    private var _nombre : String = nuevo_nombre
    private var _luz : Boolean = false
    private var _cerradura : Boolean = false
    private var _temperatura : Double = 23.0
    private var _capacidad_max : Int = nueva_cap_max    
    private var _mantenimiento : Boolean = false

    def getNombre() : String = _nombre
    def getLuz() : Boolean = _luz
    def getCerradura() : Boolean = _cerradura
    def getTemperatura() : Double = _temperatura
    def getCapacidad() : Int = _capacidad_max
    def getMantenimiento() : Boolean = _mantenimiento

    def setLuz(nuevo_estado : Boolean) : Unit = _luz = nuevo_estado
    def setCerradura(nuevo_estado : Boolean) : Unit = _cerradura = nuevo_estado
    def setTemperatura(nuevo_estado : Double ) :Unit = _temperatura = nuevo_estado
    def setMantenimiento(mant :  Boolean) : Unit = _mantenimiento = mant
}