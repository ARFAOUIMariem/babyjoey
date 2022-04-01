package com.babyjoeyBackend.controller;

import com.babyjoeyBackend.dto.RepasCreationDto;
import com.babyjoeyBackend.dto.RepasDto;
import com.babyjoeyBackend.dto.UserDto;
import com.babyjoeyBackend.entity.RepasEntity;
import com.babyjoeyBackend.service.RepasService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api_repas")
@NoArgsConstructor
public class RepasController {
    private RepasService repasService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
    @Autowired
    public RepasController(RepasService repasService) {
        this.repasService = repasService;
    }

    @GetMapping("/home")
    public String greeting() {

        return "Hello repas";
    }

    @GetMapping("/repass")
    public List<RepasEntity> getAllUsers() {

        return repasService.getAllRepas();
    }

    @GetMapping("/repas/{id_repas}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id_repas") long id_repas) {


        Optional<RepasEntity> RepasEntityOptional = repasService.getRepasByIdResponse(id_repas)
                ;
        RepasEntity repas = repasService.getRepasByID(id_repas)
                ;
        RepasDto repasDto = new RepasDto();
        if (RepasEntityOptional.isPresent()){

            repasDto.setId_repas(repas.getId_repas());
            repasDto.setNom(repas.getNom());
            repasDto.setDescription(repas.getDescription());
            repasDto.setImage(repas.getImage());

            return new ResponseEntity(repasDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("Utilisateur introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/repas/{id_repas}")
    public RepasEntity updateRepas(@PathVariable(value = "id_repas") long id_repas, @RequestBody   RepasEntity repas){
        RepasEntity foundRepas = repasService.getRepasByID(id_repas);

        //foundUser.setImage(imageService.storeFile(file));
        foundRepas.setNom(repas.getNom());
        foundRepas.setDescription(repas.getDescription());
        foundRepas.setImage(repas.getImage());



//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/downloadFile/")
//                .path(imageService.storeFile(file))
//                .toUriString();

        return repasService.addRepas(foundRepas);

    }

    @RequestMapping(value = "/newrepas", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<RepasCreationDto> addUser(@ModelAttribute   RepasEntity repas){

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
        return new ResponseEntity(new RepasCreationDto(repasService.addRepas(repas),"repas succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/repas/{id_repas}")
    public HttpStatus deleteRepasById(@PathVariable("id_repas") Long id_repas){
        LOG.debug("deleteRepasById method started {}", id_repas);
        repasService.deleteRepas(id_repas);
        ;
        return HttpStatus.FORBIDDEN;
    }
}
