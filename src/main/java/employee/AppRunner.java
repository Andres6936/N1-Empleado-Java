package employee;

import com.formdev.flatlaf.FlatIntelliJLaf;
import employee.interfaz.InterfazEmpleado;
import employee.mundo.Empleado;
import employee.mundo.Fecha;

public class AppRunner {
    
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz e inicializándola con un empleado.
     *
     * @param args Los argumentos no son utilizados.
     */
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        Fecha fechaNacimiento = new Fecha(16, 6, 1982);
        Fecha fechaIngreso = new Fecha(5, 4, 2000);

        Empleado e = new Empleado();
        e.inicializar("Pedro", "Matallana", 1, fechaNacimiento, fechaIngreso, 1500000);

        e.cambiarImagen("data/Empleado.jpg");

        InterfazEmpleado femp = new InterfazEmpleado(e);
        femp.actualizarEmpleado();
        femp.setVisible(true);
    }
}