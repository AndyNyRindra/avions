package cloud.avions.serviceImpl;

import cloud.avions.model.User;
import cloud.avions.model.UserToken;
import cloud.avions.repository.UserTokenRepository;
import cloud.avions.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;


    @Override
    public UserToken saveUserToken(UserToken userToken) {
        return userTokenRepository.save(userToken);
    }

    @Override
    public UserToken getByToken(String value) throws Exception {
        UserToken token = userTokenRepository.getUserTokenByToken(value);
        System.out.println(token.getValue());
        if (token != null) return token;
        else throw new Exception("Your token has expired, please try to reconnect");
    }

    @Override
    public void disableTokenByUser(User user) throws Exception {
        userTokenRepository.disableTokenByUser(user.getId());
    }

    @Override
    public void disableTokenByToken(String value) throws Exception {
        userTokenRepository.disableTokenByToken(value);
    }


}
