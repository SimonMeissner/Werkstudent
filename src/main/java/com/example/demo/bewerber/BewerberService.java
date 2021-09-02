package com.example.demo.bewerber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
        //check if employment is valid
        if(!checkEmployment(bewerber.getEmployment())) {
            throw new IllegalStateException("Nur Vollzeit, Teilzeit, Azubi oder Werkstudent erlaubt!");
        }
        //check if status of jobapplication is valid
        if(!checkStatusJobApplication(bewerber.getStatusjobapplication())) {
            throw new IllegalStateException("Nur Neu, Erstgespraech, Zweitgespraech, AngebotGemacht und Eingestellt erlaubt!");
        }
        bewerberRepository.save(bewerber);
    }

    public void deleteBewerber(Long bewerberId) {
        boolean exists = bewerberRepository.existsById(bewerberId);
        if(!exists) {
            throw new IllegalStateException("Bewerber mit ID " + bewerberId + " existiert nicht!");
        }
        bewerberRepository.deleteById(bewerberId);
    }

    @Transactional //Spring Data JPA
    public void updateBewerber(Long bewerberId, String name, String email, String phonenumber, String whishedposition, String employment, Integer whishedpayment, String statusjobapplication) {

        Bewerber bewerber = bewerberRepository.findById(bewerberId).orElseThrow(() -> new IllegalStateException("Bewerber mit ID " + bewerberId + " existiert nicht!"));


        if(name != null && name.length() > 0 && !Objects.equals(bewerber.getName(), name)) {
            bewerber.setName(name);
        }


        if(email != null && email.length() > 0 && !Objects.equals(bewerber.getEmail(), email)) {
            bewerber.setEmail(email);
        }


        if(phonenumber != null && phonenumber.length() > 0 && !Objects.equals(bewerber.getPhonenumber(), phonenumber)) {
            bewerber.setPhonenumber(phonenumber);
        }


        if(whishedposition != null && whishedposition.length() > 0 && !Objects.equals(bewerber.getWhishedposition(), whishedposition)) {
            bewerber.setWhishedposition(whishedposition);
        }


        if(checkEmployment(employment) && !Objects.equals(bewerber.getEmployment(), employment)) {
            bewerber.setEmployment(employment);
        }


        if(whishedpayment != null && !Objects.equals(bewerber.getWhishedpayment(), whishedpayment)) {
            bewerber.setWhishedpayment(whishedpayment);
        }


        if(checkStatusJobApplication(statusjobapplication) && !Objects.equals(bewerber.getStatusjobapplication(), statusjobapplication)) {
            bewerber.setStatusjobapplication(statusjobapplication);
        }

    }


    //Enum for the status of the jobapplication
    enum StatusJobApplication{
        Neu, Erstgespraech, Zweitgespraech, AngebotGemacht, Eingestellt
    };

    //Enum for the type of employment
    enum Employment {
        Vollzeit, Teilzeit, Azubi, Werkstudent
    };

    //check if the status of the jobapplication is allowed
    public static boolean checkStatusJobApplication(String input) {
        for(StatusJobApplication s : StatusJobApplication.values()) {
            if(s.name().equals(input)) {
                return true;
            }
        }
        return false;
    }

    //check if the type of employment is allowed
    public static boolean checkEmployment(String input) {
        for(Employment e : Employment.values()) {
            if(e.name().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
