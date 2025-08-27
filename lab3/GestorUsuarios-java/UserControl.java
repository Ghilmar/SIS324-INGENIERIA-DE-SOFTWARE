import java.util.ArrayList;
import java.util.List;

public class UserControl {
    private List<User> userList;

    public UserControl() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
        System.out.println("Usuario " + user.getUsername() + " agregado con éxito.");
    }

    public void removeUser(String id) {
        User userToRemove = findUserById(id);
        if (userToRemove != null) {
            userList.remove(userToRemove);
            System.out.println("Usuario con ID " + id + " eliminado con éxito.");
        } else {
            System.out.println("Error: No se encontró ningún usuario con el ID " + id + ".");
        }
    }

    public void editUser(String id, User updatedUser) {
        User userToEdit = findUserById(id);
        if (userToEdit != null) {
            userToEdit.setUsername(updatedUser.getUsername());
            userToEdit.setPassword(updatedUser.getPassword());
            userToEdit.setName(updatedUser.getName());
            userToEdit.setLastEntry(updatedUser.getLastEntry());
            userToEdit.setStatus(updatedUser.getStatus());
            System.out.println("Usuario con ID " + id + " editado con éxito.");
        } else {
            System.out.println("Error: No se encontró ningún usuario con el ID " + id + ".");
        }
    }

    public void listUser() {
        if (userList.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de Usuarios:");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    private User findUserById(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}