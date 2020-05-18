package zawadka.adam.covid19.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import zawadka.adam.covid19.exceptions.ValidationException;
import zawadka.adam.covid19.model.UserInfo;
import zawadka.adam.covid19.repository.UserInfoRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Tag(name = "UserInfo", description = "API for userinfo")
@RestController
public class UserInfoController {

    final
    private UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Operation(summary = "Create a new user",
            description = "Create a new user with username , fullname and password", tags = {"userinfo"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserInfo.class),examples = {
                            @ExampleObject(
                                    name = "Default Response",
                                    value = "{\n" +
                                            "\t\"username\": \"swagger@gmail.com\",\n" +
                                            "\t\"password\": \"1234\",\n" +
                                            "\t\"fullname\": \"swagger\"\n" +
                                            "}",
                                    summary = "Create a new user Example"
                            )
                    })))
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "successful operation")})

    @PostMapping(value = "/user", consumes = {"application/json"})
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {

        String username = body.get("username");
        if (userInfoRepository.existsByUsername(username)) {

            throw new ValidationException("Username already existed");
        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        String fullname = body.get("fullname");
        userInfoRepository.save(new UserInfo(username, encodedPassword, fullname));
        return true;
    }
}
