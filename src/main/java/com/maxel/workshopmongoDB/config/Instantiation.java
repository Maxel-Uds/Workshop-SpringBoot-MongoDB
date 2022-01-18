package com.maxel.workshopmongoDB.config;

import com.maxel.workshopmongoDB.domain.Post;
import com.maxel.workshopmongoDB.domain.User;
import com.maxel.workshopmongoDB.repositories.PostRepository;
import com.maxel.workshopmongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User max = new User(null, "Maxel Udson", "maxel@gmail.com");
        User ademar = new User(null, "Ademar Silva", "ademar@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu viagem!", "Vou viajar para SP abraços!", maria);
        Post post2 = new Post(null, sdf.parse("27/03/2022"), "Bom dia!", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob, max, ademar));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
