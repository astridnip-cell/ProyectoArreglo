import javax.swing.JOptionPane;

public class ArregloUnidimensional {

    public static void main(String[] args) {
        // Definimos el arreglo de tamaño 10 tal como lo pide la guía
        int[] arreglo = new int[10];
        
        // Inicializamos las posiciones en 0 por defecto
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }

        int opcion = 0;

        do {
            String menu = "=== MENÚ PRINCIPAL - ARREGLO UNIDIMENSIONAL ===\n\n"
                        + "1. Agregar Dato\n"
                        + "2. Borrar Dato (por posición)\n"
                        + "3. Limpiar Arreglo\n"
                        + "4. Consultar Arreglo\n"
                        + "5. Calcular Promedio\n"
                        + "6. Salir\n\n"
                        + "Seleccione una opción:";

            String inputOpcion = JOptionPane.showInputDialog(null, menu, "Gestión de Arreglos", JOptionPane.QUESTION_MESSAGE);
            
            // Si el usuario presiona cancelar o cierra la ventana, salimos
            if (inputOpcion == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(inputOpcion);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1: // Agregar Dato
                    try {
                        String inputPos = JOptionPane.showInputDialog(null, "Ingrese la posición (0 al 9):", "Agregar Dato", JOptionPane.QUESTION_MESSAGE);
                        if (inputPos == null) break;
                        int posicion = Integer.parseInt(inputPos);

                        if (posicion >= 0 && posicion < arreglo.length) {
                            String inputNum = JOptionPane.showInputDialog(null, "Ingrese el número a guardar en la posición " + posicion + ":", "Agregar Dato", JOptionPane.QUESTION_MESSAGE);
                            if (inputNum == null) break;
                            int numero = Integer.parseInt(inputNum);

                            arreglo[posicion] = numero;
                            JOptionPane.showMessageDialog(null, "Dato guardado con éxito.", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Posición fuera de rango. Debe ser entre 0 y 9.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos enteros válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2: // Borrar Dato (coloca 0 en la posición indicada)
                    try {
                        String inputPos = JOptionPane.showInputDialog(null, "Ingrese la posición del dato a borrar (0 al 9):", "Borrar Dato", JOptionPane.QUESTION_MESSAGE);
                        if (inputPos == null) break;
                        int posicion = Integer.parseInt(inputPos);

                        if (posicion >= 0 && posicion < arreglo.length) {
                            arreglo[posicion] = 0;
                            JOptionPane.showMessageDialog(null, "Dato en la posición " + posicion + " borrado (reiniciado a 0).", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Posición fuera de rango. Debe ser entre 0 y 9.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar una posición numérica válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3: // Limpiar Arreglo
                    for (int i = 0; i < arreglo.length; i++) {
                        arreglo[i] = 0;
                    }
                    JOptionPane.showMessageDialog(null, "Se han limpiado todos los datos del arreglo (reiniciados a 0).", "Limpiar Arreglo", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4: // Consultar Arreglo
                    StringBuilder sbConsulta = new StringBuilder("Contenido actual del arreglo:\n\n");
                    for (int i = 0; i < arreglo.length; i++) {
                        sbConsulta.append("Posición [").append(i).append("] = ").append(arreglo[i]).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbConsulta.toString(), "Consultar Arreglo", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 5: // Calcular Promedio
                    int suma = 0;
                    for (int i = 0; i < arreglo.length; i++) {
                        suma += arreglo[i];
                    }
                    // El promedio se calcula dividiendo entre el tamaño total del arreglo (10)
                    double promedio = (double) suma / arreglo.length;
                    JOptionPane.showMessageDialog(null, "La suma total es: " + suma + "\nEl promedio de los números en el arreglo es: " + promedio, "Calcular Promedio", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 6: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Buen trabajo!", "Finalizar", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
            }

        } while (opcion != 6);
    }
}