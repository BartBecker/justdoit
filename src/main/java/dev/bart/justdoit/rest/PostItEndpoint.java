package dev.bart.justdoit.rest;

import dev.bart.justdoit.domein.PostIt;
import dev.bart.justdoit.persistence.PostItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class PostItEndpoint {
    @Autowired
    PostItService postItService;

    @GetMapping("postits")
    public Iterable<PostIt> allPostIts() {
        return postItService.findAllPostIts();
    }

    @GetMapping("postit/{id}")
    public PostIt postIt(@PathVariable Integer id) {
        return postItService.findById(id);
    }

    @PostMapping("createPostIt")
    public PostIt createPostIt(@RequestBody PostIt postIt) {
        return postItService.createPostIt(postIt);
    }

    @PutMapping("updatePostIt/{id}")
    public PostIt updatePostIt(@RequestBody PostIt postIt, @PathVariable Integer id) {
        return postItService.updatePostIt(postIt, id);
    }

    @DeleteMapping("deletePostIt/{id}")
    public void deletePostIt(@PathVariable Integer id) {
        postItService.deletePostIt(id);
    }
}
