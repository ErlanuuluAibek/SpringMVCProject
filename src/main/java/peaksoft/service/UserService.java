package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    void addUser(User user,String roleName );
    void updateUser(Long userId,User user,String roleName);
    User getUserByName(String username);
    void deleteUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
