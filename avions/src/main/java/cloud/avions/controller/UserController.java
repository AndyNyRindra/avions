package cloud.avions.controller;


import cloud.avions.model.User;
import cloud.avions.model.UserToken;
import cloud.avions.service.UserService;
import cloud.avions.service.UserTokenService;
import cloud.avions.utils.MyError;
import cloud.avions.utils.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService tokenService;

//    @PostMapping("/login")
//    public MyJson login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
//        MyJson json = new MyJson();
//        try {
//            System.out.println(email + " " + password);
//            User user = userService.login(email, password);
//            tokenService.disableTokenByUser(user);
//            UserToken token = new UserToken(user);
//            tokenService.saveUserToken(token);
//            json.setData(token);
//
//        } catch (Exception e) {
//            MyError error = new MyError();
//            error.setCode(HttpStatus.UNAUTHORIZED.toString());
//            error.setMessage(e.getMessage());
//            json.setError(error);
//        }
//        return json;
//    }

    @PostMapping("/login")
    public MyJson login(@RequestBody User u) {
        MyJson json = new MyJson();
        try {
            User user = userService.login(u.getEmail(), u.getPassword());
            tokenService.disableTokenByUser(user);
            UserToken token = new UserToken(user);
            tokenService.saveUserToken(token);
            json.setData(token);

        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.UNAUTHORIZED.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @GetMapping("/token/check")
    public MyJson checkToken(@RequestHeader(value = "user_token") String value) {
        MyJson json = new MyJson();
        try {
            UserToken userToken = tokenService.getByToken(value);
            json.setData(userToken);

        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.UNAUTHORIZED.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }

    @GetMapping("/token/disable")
    public MyJson disableTokenByToken(@RequestHeader(value = "user_token") String value) {
        MyJson json = new MyJson();
        try {
            tokenService.disableTokenByToken(value);
            json.setData("Disconnect successfully");

        } catch (Exception e) {
            MyError error = new MyError();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMessage(e.getMessage());
            json.setError(error);
        }
        return json;
    }
}
