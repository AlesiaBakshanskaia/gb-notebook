package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    List<String> dataNewUser = getDataUser();
                    userController.saveUser(userController.createUser(dataNewUser));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    if (id.isEmpty()) {
                        throw new RuntimeException("Идентификатор не может быть пустым");
                    }
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String idd = prompt("Идентификатор пользователя: ");
                    if (userController.deliteUser(idd)) {
                        System.out.println("Пользователь удален");
                    } else {
                        System.out.println("Такого пользователя нет");
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Идентификатор пользователя: ");
                    List<String> dataCreateUser = getDataUser();
                    if (userId.isEmpty()) {
                        throw new RuntimeException("Идентификатор не может быть пустым");
                    }
                    userController.updateUser(userId, userController.createUser(dataCreateUser));
                    break;
                case LIST:
                    System.out.println(userController.getAllUsers());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private List<String> getDataUser() {
        List<String> dataUser = new ArrayList<>();
        String firstName = prompt("Имя: ").replaceAll(" ", "");
        dataUser.add(firstName);
        String lastName = prompt("Фамилия: ").replaceAll(" ", "");
        dataUser.add(lastName);
        String phone = prompt("Номер телефона: ");
        dataUser.add(phone);

        return dataUser;
    }
}
