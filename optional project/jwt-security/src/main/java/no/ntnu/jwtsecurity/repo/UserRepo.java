package no.ntnu.jwtsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.ntnu.jwtsecurity.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long>{
    AppUser findByUsername(String username);
}
