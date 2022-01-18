package com.maxel.workshopmongoDB.resources;

import com.maxel.workshopmongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User max = new User("1", "maxel", "maxellopes32@gmail.com");
        User joao = new User("2", "joão", "joao32@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(max, joao));
        return ResponseEntity.ok().body(list);
    }
}
