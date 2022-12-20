package cloud.avions.serviceImpl;

import cloud.avions.exception.ResourceNotFoundException;
import cloud.avions.model.User;
import cloud.avions.repository.UserRepository;
import cloud.avions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User login(String email, String password) throws Exception {
        if (userRepository.findByEmailAndPassword(email, password) != null) {
            return userRepository.findByEmailAndPassword(email, password);
        }
        throw new Exception("Email or password is incorrect");

    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
