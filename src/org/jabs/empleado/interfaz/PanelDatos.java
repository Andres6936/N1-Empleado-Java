package org.jabs.empleado.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Etiqueta del nombre
     */
    private JLabel labNombre;

    /**
     * Etiqueta del apellido
     */
    private JLabel labApellido;

    /**
     * Etiqueta de la fecha de ingreso
     */
    private JLabel labFIngreso;

    /**
     * Etiqueta de la fecha de nacimiento
     */
    private JLabel labFNacimiento;

    /**
     * Etiqueta del sexo
     */
    private JLabel labSexo;

    /**
     * Campo de texto para el nombre
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el apellido
     */
    private JTextField txtApellido;

    /**
     * Campo de texto para la fecha de Ingreso
     */
    private JTextField txtFIngreso;

    /**
     * Campo de texto para la fecha de nacimiento
     */
    private JTextField txtFNacimiento;

    /**
     * Campo de texto para el sexo
     */
    private JTextField txtSexo;

    /**
     * Etiqueta donde se muestra la imagen
     */
    private JLabel labImagen;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Construye el de Datos del empleado.
     */
    public PanelDatos( )
    {
        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Datos Personales" ) ) );

        GridBagConstraints gbc;

        labNombre = new JLabel( "Nombre: " );
        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labNombre, gbc );

        labApellido = new JLabel( "Apellido: " );
        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labApellido, gbc );

        labSexo = new JLabel( "Sexo: " );
        gbc = new GridBagConstraints( 0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labSexo, gbc );

        labFNacimiento = new JLabel( "Fecha de Nacimiento: " );
        gbc = new GridBagConstraints( 0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labFNacimiento, gbc );

        labFIngreso = new JLabel( "Fecha de Ingreso: " );
        gbc = new GridBagConstraints( 0, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labFIngreso, gbc );

        txtNombre = new JTextField( 15 );
        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtNombre, gbc );
        txtNombre.setEnabled( false );

        txtApellido = new JTextField( 15 );
        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtApellido, gbc );
        txtApellido.setEnabled( false );

        txtSexo = new JTextField( 2 );
        gbc = new GridBagConstraints( 1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSexo, gbc );
        txtSexo.setEnabled( false );

        txtFNacimiento = new JTextField( 10 );
        gbc = new GridBagConstraints( 1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtFNacimiento, gbc );
        txtFNacimiento.setEnabled( false );

        txtFIngreso = new JTextField( 10 );
        gbc = new GridBagConstraints( 1, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtFIngreso, gbc );
        txtFIngreso.setEnabled( false );

        labImagen = new JLabel( );
        gbc = new GridBagConstraints( 2, 0, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labImagen, gbc );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Actualiza los campos del panel con la información del empleado. <br>
     * <b>post: </b>Los campos muestran la nueva información. <br>
     * @param nombre Nombre. nombre != null.
     * @param apellido Apellido. apellido != null.
     * @param sexo Sexo del empleado. sexo pertenece a {"m","f"}.
     * @param fechaI Fecha de Ingreso. fechaI != null.
     * @param fechaN Fecha de Nacimiento. fechaN != null.
     * @param imagen Ruta donde se encuentra la imagen. imagen != null.
     */
    public void actualizarCampos( String nombre, String apellido, String sexo, String fechaI, String fechaN, String imagen )
    {
        txtNombre.setText( nombre );
        txtApellido.setText( apellido );
        txtSexo.setText( sexo );
        txtFIngreso.setText( fechaI );
        txtFNacimiento.setText( fechaN );

        try
        {
            remove( labImagen );
            labImagen = new JLabel( new ImageIcon( cargarImagen( imagen ) ) );
            GridBagConstraints gbc = new GridBagConstraints( 2, 0, 1, 5, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
            add( labImagen, gbc );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "La imagen no se pudo cargar: " + e.getMessage( ) );
            e.printStackTrace( );
        }
    }

    /**
     * Este método se usa para cargar la información de la imagen. Si no se leen los bytes de la imagen, entonces se depende del MediaTracker.
     * @param imagen Ruta donde se encuentra la imagen. imagen!=null y imagen corresponde a la ruta de una imagen.
     * @return Retorna la imagen.
     * @throws IOException Se lanza esta excepción si no se puede leer la imagen.
     */
    private byte[] cargarImagen( String imagen ) throws IOException
    {

        ByteArrayOutputStream baos = new ByteArrayOutputStream( );
        FileInputStream fin = new FileInputStream( imagen );
        int data = 0;
        while( data != -1 )
        {
            data = fin.read( );
            baos.write( data );
        }

        return baos.toByteArray( );
    }
}
