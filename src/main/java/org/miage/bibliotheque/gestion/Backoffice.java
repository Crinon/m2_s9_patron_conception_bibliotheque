package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Usager;
import org.miage.bibliotheque.metier.UsagerResource;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/usagers", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Usager.class)
public class Backoffice {

    private final UsagerResource ur;

    public Backoffice(UsagerResource ur) {
        this.ur = ur;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAllUsagers() {
        return ResponseEntity.ok(ur.findAll());
    }

    // GET
    @GetMapping(value = "/{usagerId}")
    public ResponseEntity getOneUsager(@PathVariable String usagerId) {
        return Optional.of(ur.findById(usagerId)).filter(Optional::isPresent)
                .map(i -> ResponseEntity.ok(i.get()))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    @Transactional
    public ResponseEntity<?> saveUsager(@RequestBody Usager usager) {
        Usager usager2Save = new Usager(
                UUID.randomUUID().toString(),
                usager.getNom(),
                usager.getPrenom()
        );
        Usager saved = ur.save(usager2Save);
        URI location = linkTo(Backoffice.class).slash(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
