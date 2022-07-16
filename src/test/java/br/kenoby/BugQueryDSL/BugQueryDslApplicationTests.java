package br.kenoby.BugQueryDSL;

import br.kenoby.models.User;
import br.kenoby.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class BugQueryDslApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void createUser(@Autowired UserRepository repository) {

        User user = new User();
        user.setPassword("xaxa");
        user.setTunnel(null);
        user.setUsername("kenoby@sky");

        repository.save(user);

    }

    @Test
    void exampleTest(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/sys-admin/search")
                .exchange()
                .expectStatus().isOk();
    }

}
