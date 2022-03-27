package no.ntnu.jwtsecurity.service;

import java.util.List;

import no.ntnu.jwtsecurity.model.AppUser;
import no.ntnu.jwtsecurity.model.Role;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename); //Assumes that username is unique.
    AppUser getUser(String username);
    List<AppUser> getUsers(); //Is not a good method to have in final project because of unnecessary strain.
}
