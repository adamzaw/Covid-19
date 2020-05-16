package zawadka.adam.covid19.controller;


import io.swagger.annotations.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zawadka.adam.covid19.exceptions.ValidationException;
import zawadka.adam.covid19.model.UserInfo;
import zawadka.adam.covid19.repository.UserInfoRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Map;


@Api(tags = { "userinfo" })
@RestController
public class UserInfoController {


    final
    private UserInfoRepository userInfoRepository;



    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @ApiOperation(value = "Create a new user", notes = "Create a new user with username , fullname and password", tags = { "userinfo" })

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })

    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {

        String username = body.get("username");
        if (userInfoRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        String fullname = body.get("fullname");
        userInfoRepository.save(new UserInfo(username, encodedPassword, fullname));
        return true;
    }

}
