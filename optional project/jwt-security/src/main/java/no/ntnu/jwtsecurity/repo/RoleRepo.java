package no.ntnu.jwtsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.ntnu.jwtsecurity.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String rolename);
}
