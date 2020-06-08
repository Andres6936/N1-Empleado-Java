package employee.mundo;

public class Empleado
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Nombre
     */
    private String nombre;

    /**
     * Apellido
     */
    private String apellido;

    /**
     * Sexo o genero
     */
    private int sexo;

    /**
     * Fecha de nacimiento
     */
    private Fecha fechaNacimiento;

    /**
     * Fecha de ingreso
     */
    private Fecha fechaIngreso;

    /**
     * Ruta de la imagen
     */
    private String imagen;

    /**
     * Salario
     */
    private int salario;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa un empleado con la información básica. <br>
     * <b>post: </b> El objeto empleado tiene sus datos básicos asignados.
     * @param pNombre El nombre del empleado. pNombre != null.
     * @param pApellido El apellido del empleado. pApellido != null.
     * @param pSexo El sexo del empleado. pSexo pertenece a {1,2}.
     * @param pFechaN La fecha de nacimiento del empleado. pFechaN != null.
     */
    public void inicializar( String pNombre, String pApellido, int pSexo, Fecha pFechaN, Fecha pFechaI, int pSalario )
    {
        nombre = pNombre;
        apellido = pApellido;
        sexo = pSexo;
        fechaNacimiento = pFechaN;
        fechaIngreso = pFechaI;
        imagen = null;
        salario = pSalario;
    }

    /**
     * Retorna el apellido del empleado
     * @return apellido
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna la fecha de ingreso del empleado en una cadena
     * @return fechaIngreso
     */
    public String darFechaIngreso( )
    {
        String strFecha = fechaIngreso.toString( );
        return strFecha;
    }

    /**
     * Retorna la fecha de nacimiento del empleado en una cadena
     * @return fechaNacimiento
     */
    public String darFechaNacimiento( )
    {
        String strFecha = fechaNacimiento.toString( );
        return strFecha;
    }

    /**
     * Retorna la ruta donde se encuentra la imagen del empleado
     * @return imagen
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el nombre del empleado
     * @return nombre
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el salario del empleado
     * @return salario
     */
    public int darSalario( )
    {
        return salario;
    }

    /**
     * Retorna el sexo del empleado.
     * @return sexo. sexo pertenece a {1 , 2 }
     */
    public int darSexo( )
    {
        return sexo;
    }

    /**
     * Retorna la edad de la persona en años.
     * @return Edad de la persona
     */
    public int darEdad( )
    {
        // Obtiene la fecha actual
        Fecha hoy = new Fecha( );
        hoy.inicializarHoy( );

        //Calcula la diferencia de años
        int edad = fechaNacimiento.darDiferenciaEnMeses( hoy ) / 12;

        return edad;
    }

    /**
     * Retorna la antigüedad del empleado en años.
     * @return Antigüedad del empleado
     */
    public int darAntiguedad( )
    {
        // Obtiene la fecha actual
        Fecha hoy = new Fecha( );
        hoy.inicializarHoy( );

        //Calcula la diferencia de años
        int antiguedad = fechaIngreso.darDiferenciaEnMeses( hoy ) / 12;

        return antiguedad;
    }

    /**
     * Este método sirve para saber las prestaciones del empleado usando la fórmula: p = (a * s)/12 (p: prestaciones, a: antigüedad, s: salario). <br>
     * La antigüedad que se utiliza está dada en años, así que si un empleado lleva menos de un año en la empresa, sus prestaciones serán 0.
     * @return Prestaciones a las que tiene derecho
     */
    public double darPrestaciones( )
    {
        int antiguedad = darAntiguedad( );
        double prestaciones = ( ( double ) ( antiguedad * salario ) ) / 12;
        return prestaciones;
    }

    /**
     * Cambia la fecha de ingreso del empleado. <br>
     * <b>post: </b> fechaIngreso == pFechaIngreso.
     * @param pFechaIngreso La nueva fecha de ingreso del empleado. pFechaIngreso != null.
     */
    public void cambiarFechaIngreso( Fecha pFechaIngreso )
    {
        fechaIngreso = pFechaIngreso;
    }

    /**
     * Cambia la ruta donde está la imagen del empleado. <br>
     * <b>post: </b> imagen == pImagen.
     * @param pImagen La nueva ruta de la imagen del empleado. pImagen != null.
     */
    public void cambiarImagen( String pImagen )
    {
        imagen = pImagen;
    }

    /**
     * Cambia el salario del empleado. <br>
     * <b>post: </b> salario == pSalario.
     * @param pSalario El nuevo salario del empleado.
     */
    public void cambiarSalario( int pSalario )
    {
        salario = pSalario;
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método de extensión 1
     * @return Resultado de la operación
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método de extensión 2
     * @return Resultado de la operación
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
