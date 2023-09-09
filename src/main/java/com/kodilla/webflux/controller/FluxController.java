package com.kodilla.webflux.controller;

import com.kodilla.webflux.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class FluxController {

   @GetMapping(value = "/strings")
   public Flux<String> getStrings() {
      return Flux
         .just("a", "b", "c", "d", "e")
         .log();
   }
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Book> getBooks() {
        Book b1 = new Book("Title1", "Author1", 2000);
        Book b2 = new Book("Title2", "Author2", 2001);
        return Flux.just(b1, b2).delayElements(Duration.ofSeconds(1)).log();
    }

}