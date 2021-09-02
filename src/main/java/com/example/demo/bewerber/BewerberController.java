package com.example.demo.bewerber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bewerber")
public class BewerberController {

    private final BewerberService bewerberService;

    @Autowired //dependency injection
    public BewerberController(BewerberService bewerberService) {
        this.bewerberService = bewerberService;
    }

    @GetMapping
    public List<Bewerber> getBewerber() {
        return bewerberService.getBewerber();
    }

    @PostMapping
    public void registerNewBewerber(@RequestBody Bewerber bewerber) {
        bewerberService.addNewBewerber(bewerber);
    }

    @DeleteMapping(path = "{bewerberId}")
    public void deleteBewerber(@PathVariable("bewerberId") Long bewerberId) {
        bewerberService.deleteBewerber(bewerberId);

    }

    @PutMapping(path = "{bewerberId}")
    public void updateBewerber(
        @PathVariable("bewerberId") Long bewerberId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {

        bewerberService.updateBewerber(bewerberId, name, email);
    }
}
