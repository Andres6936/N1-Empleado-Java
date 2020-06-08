package employee.interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelSalario extends JPanel implements ActionListener
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    /**
     * Es el comando para el botón de modificar el salario
     */
    private final static String BUT_MODIFICAR_SALARIO = "MODIFICAR SALARIO";

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Es una referencia a la interfaz de la aplicación
     */
    private final InterfazEmpleado interfazEmpleado;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es el campo de texto para el salario
     */
    private final JTextField txtSalario;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicación <br>
     * <b>post: </b> Construyá el panel e interfazEmpleado == interfaz. <br>
     * @param interfaz - Referencia a la ventana principal. interfaz != null.
     */
    public PanelSalario( InterfazEmpleado interfaz )
    {
        interfazEmpleado = interfaz;

        setLayout(new FlowLayout());

        // Etiqueta para el salario
        JLabel labSalario = new JLabel("Salario: ");
        add(labSalario);

        txtSalario = new JTextField(10);
        add(txtSalario);

        // Es el botón para modificar el salario
        JButton botonModificarSalario = new JButton();
        botonModificarSalario.setText("Modificar");
        botonModificarSalario.setActionCommand(PanelSalario.BUT_MODIFICAR_SALARIO);
        botonModificarSalario.addActionListener(this);

        add(botonModificarSalario);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder("Salario")));

        txtSalario.setEnabled(false);
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
        String command = evento.getActionCommand( );

        if( command.equals( BUT_MODIFICAR_SALARIO ) )
        {
            interfazEmpleado.modificarSalario( );
        }
    }

    /**
     * Actualiza el salario que se muestra. <br>
     * <b>post: </b> Se cambiá el salario mostrado. <br>
     * @param salario Nuevo salario a mostrar.
     */
    public void actualizarSalario( int salario )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$###,###.##" );
        txtSalario.setText( df.format( salario ) );
    }
}
