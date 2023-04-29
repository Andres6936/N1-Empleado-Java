package employee.interfaz;

import employee.mundo.Empleado;

import javax.swing.*;
import java.awt.*;


public class InterfazEmpleado extends JFrame
{

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * El empleado que se está mostrando
     */
    private final Empleado empleado;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Es el panel que contiene los elementos para mostrar los datos del empleado
     */
    private final PanelDatos panelDatos;

    /**
     * Es el panel que contiene los elementos para ver y modificar el salario del empleado
     */
    private final PanelSalario panelSalario;

    /**
     * Es el panel que contiene los elementos para realizar consultas sobre el empleado
     */
    private final PanelConsultas panelConsultas;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Construye una nueva interfaz inicializada con los datos de una empleado particular. <br>
     * <b>post: </b> El objeto InterfazEmpleado está inicializado y empleado == e.
     * @param e Empleado con el que se inicializa la interfaz. e != null.
     */
    public InterfazEmpleado( Empleado e )
    {
        setTitle("Sistema de Empleados");

        // construir los paneles
        JPanel panelCentral = new JPanel();
        panelDatos = new PanelDatos();
        panelSalario = new PanelSalario(this);
        panelConsultas = new PanelConsultas();

        // Es el panel que contiene los elementos para ejecutar las extensiones a la aplicación
        PanelExtensiones panelExtensiones = new PanelExtensiones(this);

        // organizar el panel principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelDatos, BorderLayout.NORTH);
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelExtensiones, BorderLayout.SOUTH);

        // organizar el panel central
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelSalario, BorderLayout.NORTH);
        panelCentral.add( panelConsultas, BorderLayout.CENTER );

        setSize( 530, 530 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        empleado = e;
        panelConsultas.cambiarEmpleado( e );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Este método sirve para actualizar los campos de la forma con los datos actuales del empleado. <br>
     * <b>post: </b>Los campos de la ventana contienen la información del empleado. <br>
     */
    public void actualizarEmpleado( )
    {
        String nombre, apellido, sexo, fechaI, fechaN, imagen;
        int salario;

        nombre = empleado.darNombre( );
        apellido = empleado.darApellido( );

        int iSexo = empleado.darSexo( );
        if( iSexo == 1 )
            sexo = "m";
        else
            sexo = "f";

        fechaI = empleado.darFechaIngreso( );
        fechaN = empleado.darFechaNacimiento( );
        salario = empleado.darSalario( );
        imagen = empleado.darImagen( );

        panelDatos.actualizarCampos( nombre, apellido, sexo, fechaI, fechaN, imagen );
        panelSalario.actualizarSalario( salario );

        panelConsultas.limpiarCampos( );

        validate( );
    }

    /**
     * En este método se solicita al usuario que ingrese el nuevo salario del empleado y se actualiza su información. <br>
     * <b>post: </b> Se actualizá el salario del empleado y se presentá la información actualizada. <br>
     */
    public void modificarSalario( )
    {
        String strSalario = JOptionPane.showInputDialog( this, "Introduzca el nuevo salario" );
        if( strSalario != null )
        {
            try
            {
                int nuevoSalario = Integer.parseInt( strSalario );
                empleado.cambiarSalario( nuevoSalario );
                panelSalario.actualizarSalario( empleado.darSalario( ) );
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( this, "El salario indicado no es válido." );
            }
        }
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método 1 de extensión del ejemplo
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = empleado.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método 2 de extensión del ejemplo
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = empleado.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }
}
