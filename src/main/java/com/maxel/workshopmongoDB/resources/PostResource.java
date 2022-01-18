package com.maxel.workshopmongoDB.resources;

import com.maxel.workshopmongoDB.domain.Post;
import com.maxel.workshopmongoDB.resources.util.URL;
import com.maxel.workshopmongoDB.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
       var post = postService.findById(id);
       return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "searchtitle")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text) throws UnsupportedEncodingException {
        String title = URL.decodeParam(text);
        var post = postService.findByTitle(title);
        return ResponseEntity.ok().body(post);
    }

}
