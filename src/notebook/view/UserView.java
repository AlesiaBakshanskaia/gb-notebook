package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

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
                    User u = createUser();
                    userController.saveUser(u);
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
                    userController.deliteUser(idd);
                    break;
                case UPDATE:
                    String userId = prompt("Идентификатор пользователя: ");
                    if (userId.isEmpty()) {
                        throw new RuntimeException("Идентификатор не может быть пустым");
                    }
                    userController.updateUser(userId, createUser());
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

    private User createUser() {
        String firstName = prompt("Имя: ");
//        if (firstName.isEmpty()) {
//            throw new RuntimeException("Поле ИМЯ не может быть пустым");
//        }
        String lastName = prompt("Фамилия: ");
//        if (lastName.isEmpty()) {
//            throw new RuntimeException("Поле ФАМИЛИЯ не может быть пустым");
//        }
        String phone = prompt("Номер телефона: ");
//        if (phone.isEmpty()) {
//            throw new RuntimeException("Поле ТЕЛЕФОН не может быть пустым");
//        }
        return new User(firstName.replaceAll(" ", ""), lastName.replaceAll(" ", ""), phone);
    }
}
