package com.maxel.workshopmongoDB.repositories;

import com.maxel.workshopmongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    public List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ title : { $regex: ?0, $options: 'i' } }") //O ?0 representa o primeiro parâmetro da requisição
    public List<Post> searchTitle(String text);

    @Query("{ $and : [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or : [ { title: { $regex: ?0, $options: 'i' } },  { body: { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    public List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
