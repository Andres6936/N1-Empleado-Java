package org.jabs.empleado.interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    /**
     * El comando para el botón 1
     */
    private final String OPCION_1 = "opcion1";

    /**
     * El comando para el botón 2
     */
    private final String OPCION_2 = "opcion2";

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazEmpleado interfazEmpleado;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es el botón 1
     */
    private JButton butOpcion1;

    /**
     * Es el botón 2
     */
    private JButton butOpcion2;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Construye el panel de extensiones con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyá el panel e interfazEmpleado == interfaz. <br>
     * @param interfaz Referencia a la ventana principal. interfaz != null.
     */
    public PanelExtensiones( InterfazEmpleado interfaz )
    {
        interfazEmpleado = interfaz;

        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Puntos de Extensión" ) ) );

        setLayout( new FlowLayout( ) );
        butOpcion1 = new JButton( "Opción 1" );
        butOpcion1.setActionCommand( OPCION_1 );
        butOpcion1.addActionListener( this );

        butOpcion2 = new JButton( "Opción 2" );
        butOpcion2.setActionCommand( OPCION_2 );
        butOpcion2.addActionListener( this );

        add( butOpcion1 );
        add( butOpcion2 );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Este método se llama cuando se presiona uno de los botones. <br>
     * <b>post: </b> Se ejecutá la acción correspondiente al botón presionado. <br>
     * @param evento El evento del click en el botón. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            interfazEmpleado.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            interfazEmpleado.reqFuncOpcion2( );
        }
    }
}
