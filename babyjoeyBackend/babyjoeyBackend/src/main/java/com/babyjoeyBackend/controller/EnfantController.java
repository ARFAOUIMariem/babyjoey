package com.babyjoeyBackend.controller;

import com.babyjoeyBackend.dto.EnfantCreationDto;
import com.babyjoeyBackend.dto.EnfantDto;
import com.babyjoeyBackend.entity.EnfantEntity;
import com.babyjoeyBackend.service.EnfantService;
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
@RequestMapping("/api_enf")
@NoArgsConstructor
public class EnfantController {
    private EnfantService enfantService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(EnfantController.class);
    @Autowired
    public EnfantController(EnfantService enfantService) {
        this.enfantService = enfantService;
    }

    @GetMapping("/home")
    public String greeting() {

        return "Hello OnegateAfrica";
    }

    @GetMapping("/enfantss")
    public List<EnfantEntity> getAllEnfants() {

        return enfantService.getAllEnfant();
    }

    @GetMapping("/enfant/{id}")
    public ResponseEntity<EnfantDto> getEnfantById(@PathVariable(value = "id") long id) {


        Optional<EnfantEntity> enfantEntityOptional = enfantService.getEnfantByIdResponse(id)
                ;
        EnfantEntity enfant = enfantService.getEnfantByID(id);
                ;
        EnfantDto enfantDto = new EnfantDto();
        if (enfantEntityOptional.isPresent()){

            enfantDto.setId_enf(enfant.getId_enf());
            enfantDto.setNom(enfant.getNom());
            enfantDto.setImage_enf(enfant.getImage_enf());
            enfantDto.setPrenon(enfant.getPrenon());
            enfantDto.setNum_inscription(enfant.getNum_inscription());

            return new ResponseEntity(enfantDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("ENFANT introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/enfant/{id}")
    public EnfantEntity updateEnfant(@PathVariable(value = "id") long id, @RequestBody   EnfantEntity enfant){
        EnfantEntity foundEnfant = enfantService.getEnfantByID(id)
                ;

        foundEnfant.setNom(enfant.getNom());
        foundEnfant.setImage_enf(enfant.getImage_enf());
        foundEnfant.setPrenon(enfant.getPrenon());
        foundEnfant.setAllergie(enfant.isAllergie());
        foundEnfant.setType(enfant.getType());
        foundEnfant.setDescription(enfant.getDescription());


        return enfantService.addEnfant(foundEnfant);

    }

    @RequestMapping(value = "/newenfant", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<EnfantCreationDto> addEnfant(@ModelAttribute   EnfantEntity enfant){

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
        return new ResponseEntity(new EnfantCreationDto(enfantService.addEnfant(enfant),"Enfant succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/enfant/{id}")
    public HttpStatus deleteEnfantById(@PathVariable("id") Long id){
        LOG.debug("deleteEnfantById method started {}", id);
        enfantService.deleteEnfant(id)
        ;
        return HttpStatus.FORBIDDEN;
    }


}
