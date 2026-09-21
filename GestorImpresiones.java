import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GestorImpresiones {

    public static void main(String[] args) {
        // Use Deque<String> para ambas variables
        Deque<String> pendientes = new ArrayDeque<>();
        Deque<String> historial = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ: GESTOR DE IMPRESIONES ===");
            System.out.println("1. Registrar documento (pendientes)");
            System.out.println("2. Imprimir siguiente (pasa al historial)");
            System.out.println("3. Recuperar última impresión (vuelve a pendientes)");
            System.out.println("4. Ver estado de las listas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación básica de entrada
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del documento: ");
                        String nombre = scanner.nextLine();
                        // offerLast: Entra al final
                        pendientes.offerLast(nombre);
                        System.out.println("-> Registrado: " + nombre);
                        break;
                    case 2:
                        // Validar estructura vacía antes de retirar
                        if (!pendientes.isEmpty()) {
                            // pollFirst: Sale el más antiguo
                            String documento = pendientes.pollFirst();
                            System.out.println("-> Imprimiendo: " + documento);
                            // push: Queda en la cima
                            historial.push(documento);
                        } else {
                            System.out.println("-> Error: No hay documentos pendientes para imprimir.");
                        }
                        break;
                    case 3:
                        // Validar estructura vacía antes de retirar
                        if (!historial.isEmpty()) {
                            // pop: Saca de la cima del historial
                            String recuperado = historial.pop();
                            // addFirst: Vuelve al frente de pendientes
                            pendientes.addFirst(recuperado);
                            System.out.println("-> Recuperado: " + recuperado + " (Ha vuelto al inicio de pendientes)");
                        } else {
                            System.out.println("-> Error: El historial está vacío, no hay nada que recuperar.");
                        }
                        break;
                    case 4:
                        System.out.println("\n--- ESTADO ACTUAL ---");
                        System.out.println("Pendientes (Cola): " + pendientes);
                        System.out.println("Historial (Pila): " + historial);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("-> Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("-> Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        } while (opcion != 5);

        scanner.close();
    }
}
