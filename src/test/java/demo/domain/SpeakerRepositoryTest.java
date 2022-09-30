package demo.domain;

import demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpeakerRepositoryTest {

    @Autowired
    private SpeakerRepository repository;

    @Test
    public void findByTwitter() throws Exception {
        Speaker dave = repository.save(new Speaker("Dave", "Syer", "david_syer"));
        assertThat(repository.findByTwitter("david_syer").getId(), is(dave.getId()));
    }
}