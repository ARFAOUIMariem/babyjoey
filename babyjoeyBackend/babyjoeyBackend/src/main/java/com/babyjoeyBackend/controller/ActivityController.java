package com.babyjoeyBackend.controller;

import com.babyjoeyBackend.dto.ActivityCreationDto;
import com.babyjoeyBackend.dto.ActivityDto;
import com.babyjoeyBackend.dto.UserCreationDto;
import com.babyjoeyBackend.dto.UserDto;
import com.babyjoeyBackend.entity.ActivityEntity;
import com.babyjoeyBackend.entity.UserEntity;
import com.babyjoeyBackend.service.ActivityService;
import com.babyjoeyBackend.service.ActivityServiceImpl;
import com.babyjoeyBackend.service.UserService;
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
@RequestMapping("/api")
@NoArgsConstructor
public class ActivityController {
    private ActivityService activityService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ActivityController.class);
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/homeact")
    public String greeting() {

        return "Hello OnegateAfrica";
    }

    @GetMapping("/activities")
    public List<ActivityEntity> getAllActivities() {

        return activityService.getAllActivities();
    }

    @GetMapping("activity/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable(value = "id") long id) {


        Optional<ActivityEntity> activityEntityOptional = activityService.getActivityByIdResponse(id)
                ;
        ActivityEntity activity = activityService.getActivityByID(id)
                ;
        ActivityDto activityDto = new ActivityDto();
        if (activityEntityOptional.isPresent()){

            activityDto.setId(activity.getId());
            activityDto.setNameact(activity.getNameact());
            activityDto.setType(activity.getType());
            activityDto.setDescriptionact(activity.getDescriptionact());
            activityDto.setImageact(activity.getImageact());




            return new ResponseEntity(activityDto, HttpStatus.OK) ;

        }else {
            return new ResponseEntity("Activity introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("activity/{id}")
    public ActivityEntity updateActivity(@PathVariable(value = "id") long id, @RequestBody ActivityEntity activity){
        ActivityEntity foundactivity = activityService.getActivityByID(id)
                ;

        //foundUser.setImage(imageService.storeFile(file));
        foundactivity.setNameact(activity.getNameact());
        foundactivity.setType(activity.getType());
        foundactivity.setDescriptionact(activity.getDescriptionact());
        foundactivity.setImageact(activity.getImageact());



//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/downloadFile/")
//                .path(imageService.storeFile(file))
//                .toUriString();

        return activityService.addActivity(foundactivity);

    }

    @RequestMapping(value = "/newactivity", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<ActivityCreationDto> addActivity(@ModelAttribute   ActivityEntity activity){

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
        return new ResponseEntity(new ActivityCreationDto(activityService.addActivity(activity),"activity succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("activity/{id}")
    public HttpStatus deleteactivityById(@PathVariable("id") Long id){
        LOG.debug("deleteActivityById method started {}", id);
        activityService.deleteActivity(id);
        ;
        return HttpStatus.FORBIDDEN;
    }


}



