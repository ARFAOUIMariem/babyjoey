package com.babyjoeyBackend.controller;

import com.babyjoeyBackend.dto.UserCreationDto;
import com.babyjoeyBackend.controller.UserController;
import com.babyjoeyBackend.entity.UserEntity;
import com.babyjoeyBackend.service.UserService;
import com.babyjoeyBackend.dto.UserDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class UserController {
    private UserService userService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String greeting() {

        return "Hello OnegateAfrica";
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") long id) {


        Optional<UserEntity> userEntityOptional = userService.getUserByIdResponse(id)
                ;
        UserEntity user = userService.getUserByID(id)
                ;
        UserDto userDto = new UserDto();
        if (userEntityOptional.isPresent()){

            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setRole(user.getRole());

            return new ResponseEntity(userDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("Utilisateur introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("user/{id}")
    public UserEntity updateUser(@PathVariable(value = "id") long id, @RequestBody   UserEntity user){
        UserEntity foundUser = userService.getUserByID(id)
                ;

        //foundUser.setImage(imageService.storeFile(file));
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setRole(user.getRole());



//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/downloadFile/")
//                .path(imageService.storeFile(file))
//                .toUriString();

        return userService.addUser(foundUser);

    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<UserCreationDto> addUser(@ModelAttribute   UserEntity user){

//        if (userService.getUserByUserName(user.getUserName())!=null){
//            return new ResponseEntity(new UserCreationDto(user,"null","this "),HttpStatus.BAD_REQUEST);
//        }
//        String fileName = imageService.storeFile(file);
//        String profileImageName = imageService.storeFile(profileImageFile);

//        String profileImageName = null;

//        user.setImage(ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/downloadFile/")
//                .path(fileName)
//                .toUriString());
//        user.setProfileImage(ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/downloadFile/")
//                .path(profileImageName)
//                .toUriString());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity(new UserCreationDto(userService.addUser(user),"user succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("user/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id){
        LOG.debug("deleteEmployeeById method started {}", id);
        userService.deleteUser(id)
        ;
        return HttpStatus.FORBIDDEN;
    }


}

