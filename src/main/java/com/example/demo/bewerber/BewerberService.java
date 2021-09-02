package com.example.demo.bewerber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BewerberService {

    private final BewerberRepository bewerberRepository;

    @Autowired
    public BewerberService(BewerberRepository bewerberRepository) {
        this.bewerberRepository = bewerberRepository;
    }

    public List<Bewerber> getBewerber() {
        return bewerberRepository.findAll();

    }

    public void addNewBewerber(Bewerber bewerber) {
        Optional<Bewerber> bewerberOptional = bewerberRepository.findBewerberByEmail(bewerber.getEmail());
        if (bewerberOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        bewerberRepository.save(bewerber);
    }

    public void deleteBewerber(Long bewerberId) {
        boolean exists = bewerberRepository.existsById(bewerberId);
        if(!exists) {
            throw new IllegalStateException("bewerber with id " + bewerberId + " does not exists");
        }
        bewerberRepository.deleteById(bewerberId);
    }

    @Transactional //Spring Data JPA
    public void updateBewerber(Long bewerberId, String name, String email) {
        Bewerber bewerber = bewerberRepository.findById(bewerberId).orElseThrow(() -> new IllegalStateException("bewerber with id " + bewerberId + " does not exists"));

        if(name != null && name.length() > 0 && !Objects.equals(bewerber.getName(), name)) {
            bewerber.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(bewerber.getEmail(), email)) {
            Optional<Bewerber> bewerberOptional = bewerberRepository.findBewerberByEmail(email);
            if (bewerberOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            bewerber.setEmail(email);
        }
    }
}
