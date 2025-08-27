import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserControl userControl = new UserControl();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        // Agregar los datos del estudiante
        User studentUser = new User("101", "estudiante123", "pass123", "Nombre Estudiante", dtf.format(LocalDateTime.now()), "Activo");
        userControl.addUser(studentUser);

        int option;
        do {
            System.out.println("\n--- Menú de Control de Usuarios ---");
            System.out.println("1. Adicionar usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.println("--- Adicionar Usuario ---");
                    System.out.print("ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Nombre de usuario: ");
                    String addUsername = scanner.nextLine();
                    System.out.print("Contrase: ");
                    String addPassword = scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String addName = scanner.nextLine();
                    System.out.print("Estado (Activo/Inactivo): ");
                    String addStatus = scanner.nextLine();
                    
                    User newUser = new User(addId, addUsername, addPassword, addName, dtf.format(LocalDateTime.now()), addStatus);
                    userControl.addUser(newUser);
                    break;
                case 2:
                    System.out.println("--- Modificar Usuario ---");
                    System.out.print("Ingrese el ID del usuario a modificar: ");
                    String editId = scanner.nextLine();
                    
                    System.out.print("Nuevo nombre de usuario: ");
                    String editUsername = scanner.nextLine();
                    System.out.print("Nueva contraseña: ");
                    String editPassword = scanner.nextLine();
                    System.out.print("Nuevo nombre completo: ");
                    String editName = scanner.nextLine();
                    System.out.print("Nuevo estado (Activo/Inactivo): ");
                    String editStatus = scanner.nextLine();
                    
                    User editedUser = new User(editId, editUsername, editPassword, editName, dtf.format(LocalDateTime.now()), editStatus);
                    userControl.editUser(editId, editedUser);
                    break;
                case 3:
                    System.out.println("--- Eliminar Usuario ---");
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    String removeId = scanner.nextLine();
                    userControl.removeUser(removeId);
                    break;
                case 4:
                    userControl.listUser();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (option != 5);
        
        scanner.close();
    }
}