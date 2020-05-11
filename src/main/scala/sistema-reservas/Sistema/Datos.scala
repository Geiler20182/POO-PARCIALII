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
    var s7 : Salon = new Salon("LA1.6", 25)
    var s8 : Salon = new Salon("LA1.7", 25)

    /*var c1 : Salon = new Salon("PL2.0", 35)
    var c2 : Salon = new Salon("PL2.1", 35)
    var c3 : Salon = new Salon("PL2.2", 35)
    var c4 : Salon = new Salon("PL2.3", 35)
    var c5 : Salon = new Salon("PL2.4", 35)
    var c6 : Salon = new Salon("PL2.5", 35)
    var c7 : Salon = new Salon("PL2.6", 35)
    var c8 : Salon = new Salon("PL2.7", 35)

    var p1 : Salon = new Salon("ED3.0", 45)
    var p2 : Salon = new Salon("ED3.1", 45)
    var p3 : Salon = new Salon("ED3.2", 45)
    var p4 : Salon = new Salon("ED3.3", 45)
    var p5 : Salon = new Salon("ED3.4", 45)
    var p6 : Salon = new Salon("ED3.5", 45)
    var p7 : Salon = new Salon("ED3.6", 45)
    var p8 : Salon = new Salon("ED3.7", 45)

    var a1 : Salon = new Salon("AL4.0", 60)
    var a2 : Salon = new Salon("AL4.1", 60)
    var a3 : Salon = new Salon("AL4.2", 60)
    var a4 : Salon = new Salon("AL4.3", 60)
    var a5 : Salon = new Salon("AL4.4", 60)
    var a6 : Salon = new Salon("AL4.5", 60)
    var a7 : Salon = new Salon("AL4.6", 60)
    var a8 : Salon = new Salon("AL4.7", 60)

    var t1 : Salon = new Salon("TC5.0", 70)
    var t2 : Salon = new Salon("TC5.1", 70)
    var t3 : Salon = new Salon("TC5.2", 70)
    var t4 : Salon = new Salon("TC5.3", 70)
    var t5 : Salon = new Salon("TC5.4", 70)
    var t6 : Salon = new Salon("TC5.5", 70)
    var t7 : Salon = new Salon("TC5.6", 70)
    var t8 : Salon = new Salon("TC5.7", 70)*/

    salones = s1 :: s2 :: s3 :: s4 :: s5 :: s6 :: s7 :: s8 :: salones
    //salones = c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: salones 
    /*salones = p1 :: p2 :: p3 :: p4 :: p5 :: p6 :: p7 :: p8 :: salones 
    salones = a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: salones 
    salones = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: salones*/

    
    var datos_usuarios : List[Usuario] = List()

    var e1 : Usuario = new Usuario("Geiler Hipia", "geiler", "123", "ESTUDIANTE")
    var e2 : Usuario = new Usuario("Jhon eduard", "jhon", "123", "ESTUDIANTE")
    var e3 : Usuario = new Usuario("Isabella nuñez", "isabella", "123", "ESTUDIANTE")
    var e4 : Usuario = new Usuario("Alejandra less", "aleja", "123", "ESTUDIANTE")
    var e5 : Usuario = new Usuario("July gallego", "july", "123", "ESTUDIANTE")

    var ad1 : Usuario = new Usuario("Julian Perez", "root", "root", "ADMINISTRADOR")
    var ad2 : Usuario = new Usuario("Camilo Toro", "camilo", "123", "ADMINISTRADOR")

    datos_usuarios = e1 :: e2 :: e3 :: e4 :: e5 :: ad1 :: ad2 :: datos_usuarios


    var fechas : List[Fecha] = List()
    var meses : Int = 5

/*    while (meses <= 9 ) {

        val mes  = "0" + meses.toString     
        var dias : Int = 1

        while (dias <= 25)  {

            var dia : String = ""

            if(dias < 10)
                dia = "0" + dias.toString    

            else 
                dia = dias.toString */

            var f1 : Fecha = new Fecha("07", "09", "AM", "10", "05")// dia, mes)
            var f2 : Fecha = new Fecha("09", "11", "AM", "10", "05")//dia, mes)
            var f3 : Fecha = new Fecha("11", "01", "AM", "10", "05")//dia, mes)
            var f4 : Fecha = new Fecha("02", "04", "PM", "10", "05")//dia, mes)
            var f5 : Fecha = new Fecha("04", "06", "PM", "10", "05")//dia, mes)
            var f6 : Fecha = new Fecha("06", "07", "PM", "10", "05")//dia, mes)

            fechas = f1 :: f2 :: f3 :: f4 :: f5 :: f6 :: fechas
            //dias = dias + 1
       /* }
        meses = meses + 1
    }*/

    var horarios : List[Horario] = List()

    for (salon <- salones ) {

        var h1 : Horario = new Horario(salon, fechas)
        horarios = h1 :: horarios
    }

    var reservas : List[Reserva] = List()   

    var fecha1 : Fecha = new Fecha("07", "09", "AM", "10", "05")
    var fecha2 : Fecha = new Fecha("09", "11", "AM", "10", "05")
    var fecha3 : Fecha = new Fecha("11", "01", "AM", "10", "05") //TEST

    var r1 : Reserva = new Reserva(20, fecha1, s1)
    var r2 : Reserva = new Reserva(20, fecha2, s1)
    var r3 : Reserva = new Reserva(20, fecha3, s1)

    reservas = r1 :: r2 :: r3 :: reservas    

    
    var fe1 : Fecha = new Fecha("07", "09", "AM", "10", "06")
    var fe2 : Fecha = new Fecha("09", "11", "AM", "10", "06")
    var fe3 : Fecha = new Fecha("11", "01", "AM", "10", "06") 
    var fe4 : Fecha = new Fecha("02", "04", "PM", "10", "06")
    var fe5 : Fecha = new Fecha("04", "06", "PM", "10", "06")
    var fe6 : Fecha = new Fecha("06", "07", "PM", "10", "06") 

    var cs1 : Curso =  new Curso("Matematicas Discretas", fe1, s1)
    var cs2 : Curso =  new Curso("Logica Digital", fe2, s1)
    var cs3 : Curso =  new Curso("Ecuaciones Diferenciales", fe3, s3)
    var cs4 : Curso =  new Curso("Ingles II", fe4, s4)
    var cs5 : Curso =  new Curso("POO", fe5, s5)
    var cs6 : Curso =  new Curso("Calculo Multivariable", fe6, s6)

    var cursos : List[Curso] = List()
    cursos = cs1 :: cs2 :: cs3 :: cs4 ::  cs5 :: cs6 :: cursos

    def BBDDCursos() : List[Curso] = cursos
    def BBDDReservas() : List[Reserva] = reservas
    def BBDDSalones() : List[Salon] =  salones
    def BBDDUsuarios() : List[Usuario] = datos_usuarios
    def BBDDHorarios() : List[Horario] = horarios
    
}