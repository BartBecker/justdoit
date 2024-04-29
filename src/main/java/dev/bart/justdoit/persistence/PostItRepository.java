package dev.bart.justdoit.persistence;

import dev.bart.justdoit.domein.PostIt;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostItRepository extends ListCrudRepository<PostIt, Integer> {
}
