package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post users";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get users=" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update users=" + userId;
    }

    @DeleteMapping("/{userId}")
    public String delteteUser(@PathVariable String userId) {
        return "delete users=" + userId;
    }
}
