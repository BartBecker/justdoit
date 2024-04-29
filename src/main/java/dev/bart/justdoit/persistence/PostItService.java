package dev.bart.justdoit.persistence;

import dev.bart.justdoit.domein.PostIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PostItService {

    @Autowired
    PostItRepository postItRepository;

    // view
    public Iterable<PostIt> findAllPostIts() {
        return postItRepository.findAll();
    }

    public PostIt findById(Integer id) {
        return postItRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    public PostIt createPostIt(PostIt postIt) {
        return postItRepository.save(postIt);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    public PostIt updatePostIt(PostIt postIt, Integer id) {
        if(!postItRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
         return postItRepository.save(postIt);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostIt(Integer id) {
        postItRepository.deleteById(id);
    }
}
