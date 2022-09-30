package demo.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerIntegrationTest {

    @Value("${local.server.port}")
    private int port = 8080;

    @Test
    public void runAnInvokeHome() {
        String url = "http://localhost:" + port + "/";
        String body = new RestTemplate().getForObject(url, String.class);
        assertThat("Hello devoxx", is("Hello devoxx"));
    }
}