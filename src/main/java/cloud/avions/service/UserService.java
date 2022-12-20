package cloud.avions.service;

import cloud.avions.model.User;

public interface UserService {
    User login(String email, String password) throws Exception;
    User findUserById(long id);
}
