package no.ntnu.jwtsecurity.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor //The ones that are not "Entity" are from lombok and just cleans up code.
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) //@Id means that it is the primary key
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) //Makes sure that all the roles are loaded any time a user is loaded.
    private Collection<Role> roles = new ArrayList<>();
}
