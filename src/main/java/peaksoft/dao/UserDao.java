package peaksoft.dao;

import peaksoft.entities.User;

import java.util.List;

public interface UserDao {
    void addUser(User user,String roleName );
    void updateUser(Long userId,User user,String roleName);
    User getUserByName(String username);
    void deleteUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
