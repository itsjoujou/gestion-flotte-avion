package application.controller;

import application.model.Login;
import application.repository.LoginRepository;
import application.util.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class LoginController {
    @Autowired
    private final LoginRepository repository;

    public LoginController(LoginRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/authentificate")
    public Data signIn(@RequestBody Login login) {
        Data data = new Data();
        data.setData(repository.findByUsernameAndPassword(login.getUsername(), login.getPassword()));
        repository.generateTokenNativeQuery(login.getUsername(), login.getPassword());

        return data;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Login login) {
        repository.save(login);
        return "User registered!";
    }

    @PostMapping("/{token}")
    public String singOut(@PathVariable String token) {
        repository.signOut(token);
        return "User disconnected!";
    }

    @GetMapping()
    public Data all() {
        Data data = new Data();
        data.setData(repository.findAll());

        return data;
    }
}