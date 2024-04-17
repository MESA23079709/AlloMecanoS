package com.alibou.security.user;

import com.alibou.security.auth.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final AuthenticationService service;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }
    public User addUser(User user){
        return repository.save(user);
    }
    public List<User> FindAllUsers(){
        return repository.findAll();
    }

    public User FindUserById(Long id){
        return repository.findUserById(id).orElseThrow(()-> new UserNotFoundException("user by id "+id+"was not found"));
    }
    public User updateUser(User user){
        return repository.save(user);
    }
    @Transactional
    public void deleteUser(Long id){
        repository.deleteUserById(id);
    }

}
