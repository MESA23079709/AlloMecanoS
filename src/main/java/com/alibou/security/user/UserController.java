package com.alibou.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


//    @PostMapping("/add")
//    public ResponseEntity<User> addUserAuthentication(@RequestBody User user){
//        User newUser=service.addUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.OK);
//    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getALLUsers(){
//        List<User> user =service.FindAllUsers();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> getALLUserById(@PathVariable("id") Long id ){
//        User user =service.FindUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestBody User user){
//        User newUser=service.addUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//        User updateUser=service.updateUser(user);
//        return new ResponseEntity<>(updateUser, HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
//        service.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
