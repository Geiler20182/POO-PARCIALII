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

    var c1 : Salon = new Salon("PL2.0", 35)
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
    var t8 : Salon = new Salon("TC5.7", 70)

    salones = s1 :: s2 :: s3 :: s4 :: s5 :: s6 :: s7 :: s8 :: salones
    salones = c1 :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: salones 
    salones = p1 :: p2 :: p3 :: p4 :: p5 :: p6 :: p7 :: p8 :: salones 
    salones = a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: salones 
    salones = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: salones

    
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

    while (meses <= 9 ) {

        val mes  = "0" + meses.toString     
        var dias : Int = 1

        while (dias <= 25)  {

            var dia : String = ""

            if(dias < 10)
                dia = "0" + dias.toString    

            else 
                dia = dias.toString  
            // 1 hora
            var f1 : Fecha = new Fecha("07", "08", "AM", dia, mes)
            var f2 : Fecha = new Fecha("08", "09", "AM", dia, mes)
            var f3 : Fecha = new Fecha("09", "10", "AM", dia, mes)
            var f4 : Fecha = new Fecha("10", "11", "AM", dia, mes)
            var f5 : Fecha = new Fecha("11", "12", "AM", dia, mes)
            var f6 : Fecha = new Fecha("12", "01", "PM", dia, mes)
            var f7 : Fecha = new Fecha("01", "02", "PM", dia, mes)
            var f8 : Fecha = new Fecha("02", "03", "PM", dia, mes)
            var f9 : Fecha = new Fecha("03", "04", "PM", dia, mes)
            /*var g1 : Fecha = new Fecha("04", "05", "PM", dia, mes)
            var g2 : Fecha = new Fecha("05", "06", "PM", dia, mes)
            var g3 : Fecha = new Fecha("06", "07", "PM", dia, mes)
            var g4 : Fecha = new Fecha("01", "02", "PM", dia, mes)

            // 2 horas
            var g5 : Fecha = new Fecha("07", "09", "AM", dia, mes)
            var g6 : Fecha = new Fecha("09", "11", "AM", dia, mes)
            var g7 : Fecha = new Fecha("11", "01", "AM", dia, mes)
            var g8 : Fecha = new Fecha("09", "11", "AM", dia, mes)
            var g9 : Fecha = new Fecha("11", "01", "PM", dia, mes)
            var g10 : Fecha = new Fecha("01", "02", "PM", dia, mes)
            var g11 : Fecha = new Fecha("02", "04", "PM", dia, mes)
            var g12 : Fecha = new Fecha("04", "06", "PM", dia, mes)  */

            //fechas = g10 :: g11 :: g12 :: fechas

            fechas = f1 :: f2 :: f3 :: f4 :: f5 :: f6 :: f7 :: f8 :: f9 :: fechas
            //fechas = g9 :: g8 :: g7 :: g6 :: g7 :: g6 :: g5 :: g4 :: g3 :: g2 :: g1 :: fechas
            
            dias = dias + 1
        }
        meses = meses + 1
    }

    var horarios : List[Horario] = List()

    for (salon <- salones ) {

        var h1 : Horario = new Horario(salon, fechas)
        horarios = h1 :: horarios
    }

    var reservas : List[Reserva] = List()   

    var fecha1 : Fecha = new Fecha("07", "08", "AM", "10", "05")
    var fecha2 : Fecha = new Fecha("08", "09", "AM", "10", "05")
    var r1 : Reserva = new Reserva(20, fecha1, t1)
    var r2 : Reserva = new Reserva(20, fecha2, t1)

    reservas = r1 :: r2 :: reservas    

    def BBDDReservas() : List[Reserva] = reservas
    def BBDDSalones() : List[Salon] =  salones
    def BBDDUsuarios() : List[Usuario] = datos_usuarios
    def BBDDHorarios() : List[Horario] = horarios
    
}