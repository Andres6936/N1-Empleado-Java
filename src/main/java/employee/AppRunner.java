package employee;

import com.formdev.flatlaf.FlatIntelliJLaf;
import employee.interfaz.InterfazEmpleado;
import employee.mundo.Empleado;
import employee.mundo.Fecha;

import java.awt.*;

public class AppRunner {
    
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz e inicializándola con un empleado.
     *
     * @param args Los argumentos no son utilizados.
     */
    public static void main(final String[] args) {

        // The property way of create a Swing-based program, this ways is
        // because Swing is not thread-safe. Although this might sound scary,
        // it simply means that all access to Swing components need to be done
        // from a single-thread the event dispatch thread.
        // If you want your Swing GUI creation to be thread-safe, you should
        // follow this pattern with all of your Swing code.
        EventQueue.invokeLater(() -> {
            // Beautiful theme for Swing, not need for logic of application
            FlatIntelliJLaf.install();

            Fecha fechaNacimiento = new Fecha(16, 6, 1982);
            Fecha fechaIngreso = new Fecha(5, 4, 2000);

            Empleado e = new Empleado();
            e.inicializar("Pedro", "Matallana", 1, fechaNacimiento, fechaIngreso, 1500000);

            e.cambiarImagen("data/Empleado.jpg");

            InterfazEmpleado femp = new InterfazEmpleado(e);
            femp.actualizarEmpleado();
            femp.setVisible(true);
        });
    }
}