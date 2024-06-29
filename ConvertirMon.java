
import javax.swing.JOptionPane;

public class ConvertirMon {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMon consulta) {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaTarget);
        JOptionPane.showMessageDialog(null, "Tasa de conversión del día\n1 " + monedaBase + " = " + monedas.conversion_rate() + " " + monedaTarget, "Tasa de Conversión", JOptionPane.INFORMATION_MESSAGE);

        String cantidadStr = JOptionPane.showInputDialog(null, "Escriba la cantidad de " + monedaBase, "Cantidad", JOptionPane.QUESTION_MESSAGE);

        if (cantidadStr == null) {
            return; // Salir si el usuario cancela el diálogo
        }

        try {
            cantidad = Double.parseDouble(cantidadStr);
            cantidadConvertida = cantidad * monedas.conversion_rate();
            JOptionPane.showMessageDialog(null, cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedas.target_code(), "Resultado de la Conversión", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad incorrecta, verifique", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void convertirOtraMoneda(ConsultarMon consulta) {
        String monedaBase = JOptionPane.showInputDialog(null, "Escribe el código de la moneda base:", "Moneda Base", JOptionPane.QUESTION_MESSAGE).toUpperCase();
        if (monedaBase == null) {
            return; // Salir si el usuario cancela el diálogo
        }

        String monedaObjetivo = JOptionPane.showInputDialog(null, "Ingrese el objetivo de la moneda:", "Moneda Objetivo", JOptionPane.QUESTION_MESSAGE).toUpperCase();
        if (monedaObjetivo == null) {
            return; // Salir si el usuario cancela el diálogo
        }

        convertir(monedaBase, monedaObjetivo, consulta);
    }
}
