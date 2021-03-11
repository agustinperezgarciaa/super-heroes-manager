package superheroManager.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import superheroManager.dto.User;
import superheroManager.exceptionHandler.UnauthorizedException;
import superheroManager.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("authUser")
    public User login(@RequestParam("user") String username, @RequestParam("password") String password) {
        validateUser(username, password);
        String token = getJWTToken(username);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setToken(token);
        return user;
    }

    private void validateUser(String username, String password) {
        List<superheroManager.model.User> users = userRepository.findByNameAndPassword(username, password);
        if (users.isEmpty()) {
            throw new UnauthorizedException("Incorrect user or password");
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}