package cloud.avions.service;

import cloud.avions.model.User;
import cloud.avions.model.UserToken;

public interface UserTokenService {
    UserToken saveUserToken(UserToken userToken);
    UserToken getByToken(String value) throws Exception;

    void disableTokenByUser(User user) throws Exception;

    void disableTokenByToken(String value) throws Exception;
}
