package Sistema


object Datos {

    /* Simulación base de datos */

    var salones : List[Salon] = List()

    var s1 : Salon = new Salon("LA1.0", 25)
    var s2 : Salon = new Salon("LA1.1", 25)
    var s3 : Salon = new Salon("LA1.2", 25)
    var s4 : Salon = new Salon("LA1.3", 25)
    var s5 : Salon = new Salon("LA1.4", 25)
    var s6 : Salon = new Salon("LA1.5", 25)

    var c1 : Salon = new Salon("PL2.0", 35)
    var c2 : Salon = new Salon("PL2.1", 35)
    var c3 : Salon = new Salon("PL2.2", 35)
    var c4 : Salon = new Salon("PL2.3", 35)
    var c5 : Salon = new Salon("PL2.4", 35)
    var c6 : Salon = new Salon("PL2.5", 35)

    var p1 : Salon = new Salon("ED3.0", 45)
    var p2 : Salon = new Salon("ED3.1", 45)
    var p3 : Salon = new Salon("ED3.2", 45)
    var p4 : Salon = new Salon("ED3.3", 45)
    var p5 : Salon = new Salon("ED3.4", 45)
    var p6 : Salon = new Salon("ED3.5", 45)


    salones = s1 :: s2 :: s3 :: s4 :: s5 :: s6 :: salones
    salones = c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: salones 
    salones = p1 :: p2 :: p3 :: p4 :: p5 :: p6 :: salones 

    
    var datos_usuarios : List[Usuario] = List()

    var e1 : Usuario = new Usuario("Geiler Hipia", "geiler", "123", "ESTUDIANTE")
    var e2 : Usuario = new Usuario("Jhon eduard", "jhon", "123", "ESTUDIANTE")
    var e3 : Usuario = new Usuario("Isabella nuñez", "isabella", "123", "ESTUDIANTE")
    var e4 : Usuario = new Usuario("Alejandra less", "aleja", "123", "ESTUDIANTE")
    var e5 : Usuario = new Usuario("July gallego", "july", "123", "ESTUDIANTE")

    var ad1 : Usuario = new Usuario("Julian Perez", "root", "root", "ADMINISTRADOR")
    var ad2 : Usuario = new Usuario("Camilo Toro", "camilo", "123", "ADMINISTRADOR")

    datos_usuarios = e1 :: e2 :: e3 :: e4 :: e5 :: ad1 :: ad2 :: datos_usuarios

    var f1 : Fecha = new Fecha("07", "09", "AM")
    var f2 : Fecha = new Fecha("09", "11", "AM")
    var f3 : Fecha = new Fecha("11", "01", "AM")
    var f4 : Fecha = new Fecha("02", "04", "PM")
    var f5 : Fecha = new Fecha("04", "06", "PM")
    var f6 : Fecha = new Fecha("06", "07", "PM")

    var fechas : List[Fecha]  = List()
    fechas = f1 :: f2 :: f3 :: f4 :: f5 :: f6 :: fechas

    var horarios : List[Horario] = List()

    for (salon <- salones ) {

        var h1 : Horario = new Horario(salon, fechas)
        horarios = h1 :: horarios
    }

    var reservas : List[Reserva] = List()   

    var fecha1 : Fecha = new Fecha("11", "01", "AM")
    var fecha2 : Fecha = new Fecha("06", "07", "PM")
    var fecha3 : Fecha = new Fecha("11", "01", "AM") //TEST

    var r1 : Reserva = new Reserva(20, fecha1, s1)
    var r2 : Reserva = new Reserva(20, fecha2, s2)
    var r3 : Reserva = new Reserva(20, fecha3, s3)
    var r4 : Reserva = new Reserva(20, fecha3, s5)

    reservas = r1 :: r2 :: r3 :: r4 :: reservas    

    
    var fe1 : Fecha = new Fecha("07", "09", "AM")
    var fe2 : Fecha = new Fecha("09", "11", "AM")
    var fe3 : Fecha = new Fecha("11", "01", "AM") 
    var fe4 : Fecha = new Fecha("02", "04", "PM")
    var fe5 : Fecha = new Fecha("04", "06", "PM")
    var fe6 : Fecha = new Fecha("09", "10", "PM") 

    var cs1 : Curso =  new Curso("Matematicas Discretas", fe1, s1)
    var cs2 : Curso =  new Curso("Logica Digital", fe2, s1)
    var cs3 : Curso =  new Curso("Ecuaciones Diferenciales", fe3, s2)
    var cs4 : Curso =  new Curso("Ingles II", fe4, s2)
    var cs5 : Curso =  new Curso("POO", fe5, s3)
    var cs6 : Curso =  new Curso("Calculo Multivariable", fe6, s4)


    var cursos : List[Curso] = List()
    cursos = cs1 :: cs2 :: cs3 :: cs4 ::  cs5 :: cs6 :: cursos

    def BBDDCursos() : List[Curso] = cursos
    def BBDDReservas() : List[Reserva] = reservas
    def BBDDSalones() : List[Salon] =  salones
    def BBDDUsuarios() : List[Usuario] = datos_usuarios
    def BBDDHorarios() : List[Horario] = horarios
    
}