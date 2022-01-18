package com.maxel.workshopmongoDB.services;

import com.maxel.workshopmongoDB.domain.Post;
import com.maxel.workshopmongoDB.repositories.PostRepository;
import com.maxel.workshopmongoDB.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        var post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
