package com.bigcorp.pokemon.model;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void sayHello() {
        System.out.println("Hello " + prenom);
    }
}