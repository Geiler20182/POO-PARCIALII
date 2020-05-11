package Sistema

class Usuario (nuevo_nombre : String, nuevo_usuario : String, nueva_contrasena : String, nuevo_tipo : String) {

    private var _nombre :  String = nuevo_nombre
    private var _usuario :  String = nuevo_usuario
    private var _contrasena : String = nueva_contrasena
    private var _tipo_usuario : String = nuevo_tipo

    def getNombre() : String = _nombre
    def getUsuario() : String = _usuario
    def getContrasena() : String = _contrasena
    def getTipo() : String = _tipo_usuario
    
}