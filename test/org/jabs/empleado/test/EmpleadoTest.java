package org.jabs.empleado.test;

import org.jabs.empleado.mundo.Empleado;
import org.jabs.empleado.mundo.Fecha;
import junit.framework.TestCase;

public class EmpleadoTest extends TestCase
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Empleado 1 de prueba
     */
    private Empleado empleado1;
    /**
     * Empleado 2 de prueba
     */
    private Empleado empleado2;
    /**
     * Empleado 3 de prueba
     */
    private Empleado empleado3;


    //-----------------------------------
    // Constructor
    //-----------------------------------

    public EmpleadoTest()
    {
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Preparar el escenario 1
     */
    private void setupEscenario1( )
    {
        empleado1 = new Empleado( );
        Fecha fechaNacimiento = new Fecha( );
        fechaNacimiento.inicializar( 14, 11, 1982 );
        Fecha fechaIngreso = new Fecha( );
        fechaIngreso.inicializar( 6, 10, 2002 );
        empleado1.inicializar( "Pedro", "Pérez", 1, fechaNacimiento,  fechaIngreso, 1600000);
    }

    /**
     * Preparar el escenario 2
     */
    private void setupEscenario2( )
    {
        empleado2 = new Empleado( );
        Fecha fechaNacimiento = new Fecha( );
        fechaNacimiento.inicializar( 27, 4, 1975 );
        Fecha fechaIngreso = new Fecha( );
        fechaIngreso.inicializar( 2, 12, 2004 );

        empleado2.inicializar( "María", "Rojas", 2, fechaNacimiento, fechaIngreso, 2000000 );

        Fecha fecha = new Fecha( );
        fecha.inicializar( 7, 6, 2004 );
        empleado2.cambiarFechaIngreso( fecha );
        empleado2.cambiarSalario( 1000000 );
    }

    /**
     * Preparar el escenario 3
     */
    private void setupEscenario3( )
    {
        empleado3 = new Empleado( );
        Fecha fechaNacimiento = new Fecha( );
        fechaNacimiento.inicializar( 27, 4, 1975 );
        Fecha fechaIngreso = new Fecha( );
        fechaIngreso.inicializar( 6, 8, 2000 );
        empleado3.inicializar( "Juan", "Rojas", 1, fechaNacimiento, fechaIngreso, 2500000  );
        empleado3.cambiarImagen( "./imagenes/JuanRojas" );
    }

    /**
     * Verificar que la fecha de ingreso se modifique correctamente
     */
    public void testCambiarFechaIngreso( )
    {
        setupEscenario1( );
        setupEscenario2( );

        Fecha fIngreso = new Fecha( );
        fIngreso.inicializar( 10, 10, 2004 );

        // Cambiar la fecha de ingreso de un empleado sin fecha de ingreso
        empleado1.cambiarFechaIngreso( fIngreso );
        assertEquals( "La fecha de ingreso del empleado 1 debe ser " + fIngreso, fIngreso.toString( ), empleado1.darFechaIngreso( ) );

        // Cambiar la fecha de ingreso de un empleado con fecha de ingreso
        empleado2.cambiarFechaIngreso( fIngreso );
        assertEquals( "La fecha de ingreso del empleado 2 debe ser " + fIngreso, fIngreso.toString( ), empleado2.darFechaIngreso( ) );
    }

    /**
     * Verificar que la ruta de la imagen se verifique correctamente
     */
    public void testCambiarImagen( )
    {
        setupEscenario1( );
        setupEscenario3( );

        String rutaNueva = "./img/empleado.jpg";

        // Cambiar la ruta de un empleado sin imagen
        empleado1.cambiarImagen( rutaNueva );
        assertEquals( "La ruta de la imagen del empleado 1 debe ser " + rutaNueva, rutaNueva, empleado1.darImagen( ) );

        // Cambiar la ruta de un empleado con imagen
        empleado3.cambiarImagen( rutaNueva );
        assertEquals( "La ruta de la imagen del empleado 3 debe ser " + rutaNueva, rutaNueva, empleado3.darImagen( ) );
    }

    /**
     * Verificar que el salario se modifique correctamente
     */
    public void testCambiarSalario( )
    {
        setupEscenario1( );
        setupEscenario2( );

        int salario = 2000000;

        // Cambiar el salario de un empleado sin salario
        empleado1.cambiarSalario( salario );
        assertEquals( "El salario del empleado 1 debe ser " + salario, salario, empleado1.darSalario( ) );

        // Cambiar el salario de un empleado con salario
        empleado2.cambiarSalario( salario );
        assertEquals( "El salario del empleado 2 debe ser " + salario, salario, empleado2.darSalario( ) );
    }

    /**
     * Verificar que los atributos básicos (nombre, apellido, sexo, fecha de nacimiento) se retornen correctamente
     */
    public void testDarAtributos( )
    {
        setupEscenario1( );
        Fecha fecha1 = new Fecha( );
        fecha1.inicializar( 14, 11, 1982 );

        assertEquals( "El nombre del empleado 1 es Pedro", "Pedro", empleado1.darNombre( ) );
        assertEquals( "El apellido del empleado 1 es Pérez", "Pérez", empleado1.darApellido( ) );
        assertEquals( "El sexo del empleado 1 es masculino", 1, empleado1.darSexo( ) );
        assertEquals( "La fecha de nacimiento del empleado 1 es " + fecha1, fecha1.toString( ), empleado1.darFechaNacimiento( ) );

        setupEscenario2( );
        Fecha fecha2 = new Fecha( );
        fecha2.inicializar( 27, 4, 1975 );

        assertEquals( "El nombre del empleado 2 es María", "María", empleado2.darNombre( ) );
        assertEquals( "El apellido del empleado 2 es Rojas", "Rojas", empleado2.darApellido( ) );
        assertEquals( "El sexo del empleado 2 es femenino", 2, empleado2.darSexo( ) );
        assertEquals( "La fecha de nacimiento del empleado 2 es " + fecha2, fecha2.toString( ), empleado2.darFechaNacimiento( ) );
    }

    /**
     * Sirve para verificar que la antigüedad se calcule correctamente
     */
    public void testDarAntiguedad( )
    {
        setupEscenario1( );
        setupEscenario2( );

        Fecha hoy = new Fecha( );
        hoy.inicializarHoy( );
        Fecha fechaIngreso = new Fecha( );
        fechaIngreso.inicializar( 7, 6, 2004 );
        int antiguedad = fechaIngreso.darDiferenciaEnMeses( hoy ) / 12;

        // Verificar la antigüedad de un empleado con fecha de ingreso
        assertEquals( "El cálculo de la antigüedad está equivocado", antiguedad, empleado2.darAntiguedad( ) );


    }

    /**
     * Verificar que la fecha de ingreso se retorne correctamente
     */
    public void testDarFechaIngreso( )
    {
        setupEscenario1( );
        setupEscenario2( );

        Fecha fIngreso = new Fecha( );
        fIngreso.inicializar( 7, 6, 2004 );

        // Verificar la fecha de ingreso de un empleado con fecha de ingreso
        assertEquals( "La fecha de ingreso del empleado 2 debe ser " + fIngreso, fIngreso.toString( ), empleado2.darFechaIngreso( ) );


    }

    /**
     * Verificar que la ruta de la imagen se retorne correctamente
     */
    public void testDarImagen( )
    {
        setupEscenario1( );
        setupEscenario3( );

        String ruta = "./imagenes/JuanRojas";

        assertEquals( "La ruta del empleado 3 debe ser " + ruta, ruta, empleado3.darImagen( ) );

        assertNull( "La ruta del empleado 1 debe ser null", empleado1.darImagen( ) );
    }

    /**
     * Verificar que las prestaciones se calculen correctamente
     */
    public void testDarPrestaciones( )
    {
        setupEscenario2( );

        double esperadas = ( empleado2.darAntiguedad( ) * empleado2.darSalario( ) ) / 12.0;
        double prestaciones = empleado2.darPrestaciones( );

        assertEquals( "El cálculo de las prestaciones está equivocado: fue " + prestaciones + " en lugar de " + esperadas, prestaciones, esperadas, 0 );
    }

    /**
     * Prueba la información del salario
     */
    public void testDarSalario( )
    {
        setupEscenario1( );
        setupEscenario2( );

        assertEquals( "El salario del empleado 1 debe ser 1600000", 1600000, empleado1.darSalario( ) );
        assertEquals( "El salario del empleado 2 debe ser 100000", 1000000, empleado2.darSalario( ) );
    }
}
