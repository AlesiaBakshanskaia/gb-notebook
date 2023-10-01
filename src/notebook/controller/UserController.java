package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId){
        return repository.findById(userId);
    }

    public void updateUser(String userId, User update) {
//        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public boolean deliteUser(String id) {
        return repository.delete(Long.parseLong(id));
    }

    public User createUser(List<String> dataUser) {
        return repository.createNewUser(dataUser);
    }
}
