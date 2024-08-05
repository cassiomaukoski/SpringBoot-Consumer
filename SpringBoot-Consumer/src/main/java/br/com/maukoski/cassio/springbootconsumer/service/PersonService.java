package br.com.maukoski.cassio.springbootconsumer.service;

import br.com.maukoski.cassio.springbootconsumer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private WebClient webClient;

    private final String uri = "/person";

    public Person findById(int id) {
        Mono<Person> monoPerson = this.webClient.method(HttpMethod.GET).
                uri(uri + "/" + id).
                retrieve().
                bodyToMono(Person.class);
        return monoPerson.block();
    }

    public List<Person> findAll() {
        Mono<List<Person>> monoListPerson = this.webClient.method(HttpMethod.GET).
                uri(uri).
                retrieve().
                bodyToFlux(Person.class).collectList();
        return monoListPerson.block();
    }

    public Person save(Person person) {
        Mono<Person> monoUsuario = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(person)).
                retrieve().
                bodyToMono(Person.class);
        return monoUsuario.block();
    }

    public Void delete(int id) {
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + id).retrieve().bodyToMono(Void.class);
        return monoVoid.block();
    }


}
