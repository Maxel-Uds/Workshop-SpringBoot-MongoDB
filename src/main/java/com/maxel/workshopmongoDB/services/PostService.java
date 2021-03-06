package com.maxel.workshopmongoDB.services;

import com.maxel.workshopmongoDB.domain.Post;
import com.maxel.workshopmongoDB.repositories.PostRepository;
import com.maxel.workshopmongoDB.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        var post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (24 * 3600000));
        return  postRepository.fullSearch(text, minDate, maxDate);
    }
}
