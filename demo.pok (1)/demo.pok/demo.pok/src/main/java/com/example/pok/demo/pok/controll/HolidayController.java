package com.example.pok.demo.pok.controll;

import java.util.List;

import com.example.pok.demo.pok.DTO.HolidayRequest;
import com.example.pok.demo.pok.DTO.ProcessInstanceResponse;
import com.example.pok.demo.pok.DTO.TaskDetails;
import com.example.pok.demo.pok.Service.HolidayService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class HolidayController {

    HolidayService holidayService;

    //********************************************************** deployment endpoints **********************************************************
    @PostMapping("/deploy")
    public void deployWorkflow() {
        holidayService.deployProcessDefinition();
    }

    //********************************************************** process endpoints **********************************************************
    @PostMapping("/holiday/apply")
    public ProcessInstanceResponse applyHoliday(@RequestBody HolidayRequest holidayRequest) {
        return holidayService.applyHoliday(holidayRequest);
    }


    @GetMapping("/manager/tasks")
    public List<TaskDetails> getTasks() {
        return holidayService.getManagerTasks();
    }


    @PostMapping("/manager/approve/tasks/{taskId}/{approved}")
    public void approveTask(@PathVariable("taskId") String taskId,@PathVariable("approved") Boolean approved){
        holidayService.approveHoliday(taskId,approved);
    }

    @PostMapping("/user/accept/{taskId}")
    public void acceptHoliday(@PathVariable("taskId") String taskId){
        holidayService.acceptHoliday(taskId);
    }

    @GetMapping("/user/tasks")
    public List<TaskDetails> getUserTasks() {
        return holidayService.getUserTasks();
    }


    @GetMapping("/process/{processId}")
    public void checkState(@PathVariable("processId") String processId){
        holidayService.checkProcessHistory(processId);
    }



}