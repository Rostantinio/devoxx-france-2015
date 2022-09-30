package demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.Collections;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

    @RestResource(path = "by-twitter")
    Speaker findByTwitter(@Param("id") String twitter);

    Collection<Speaker> findByLastName(String lastName);
}
