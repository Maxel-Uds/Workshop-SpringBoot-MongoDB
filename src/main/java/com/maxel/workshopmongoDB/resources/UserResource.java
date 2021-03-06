package com.maxel.workshopmongoDB.resources;

import com.maxel.workshopmongoDB.domain.Post;
import com.maxel.workshopmongoDB.dto.UserDTO;
import com.maxel.workshopmongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = userService.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO user = new UserDTO(userService.findById(id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        var user = userService.insert(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        userService.update(userDTO, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findAllposts(@PathVariable String id) {
        var user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
