import javax.swing.JOptionPane;


public class Principal {
    public static void main(String[] args) {
        ConsultarMon consulta = new ConsultarMon();

        int opcion = 0;
        while(opcion != 8) {
            String menu = "--------------------------\n" +
                    "Conversor de Monedas\n\n" +
                    "Escribe la conversión que deseas hacer\n\n"+
                    "1. Dollar a peso mexicano\n" +
                    "2. Peso mexicano a dollar\n" +
                    "3. Dollar a peso argentino\n" +
                    "4. peso argentino a dollar\n" +
                    "5. Dollar a real brasilero\n" +
                    "6. real brasilero a dollar\n" +
                    "7. Convertir moneda diferente\n" +
                    "8. Salir";

            String input = JOptionPane.showInputDialog(null, menu, "Conversor de Monedas", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                break; // Salir si el usuario cancela el diálogo
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción incorrecta, verifique", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    ConvertirMon.convertir("USD", "MXN", consulta);
                    break;
                case 2:
                    ConvertirMon.convertir("MXN", "USD", consulta);
                    break;
                case 3:
                    ConvertirMon.convertir("USD", "ARS", consulta);
                    break;
                case 4:
                    ConvertirMon.convertir("ARS", "USD", consulta);
                    break;
                case 5:
                    ConvertirMon.convertir("USD", "BRL", consulta);
                    break;
                case 6:
                    ConvertirMon.convertir("BRL", "USD", consulta);
                    break;
                case 7:
                    ConvertirMon.convertirOtraMoneda(consulta);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Terminando...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta, verifique", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

}
