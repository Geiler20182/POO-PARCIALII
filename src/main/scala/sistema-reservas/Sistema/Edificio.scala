package Sistema


class Edificio {
    
    private var _salones : List[Salon]  = Datos.BBDDSalones()

    def getSalones() : List[Salon] = _salones
}