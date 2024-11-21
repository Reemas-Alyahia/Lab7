package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model1.Doctor;
import com.example.lab7.Model1.PatintModel;
import com.example.lab7.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor

public class DocortControl {
    private final DoctorService doctorService;
    private final View error;
@GetMapping("/get")
    public ResponseEntity getDoctor(){
        return ResponseEntity.status(200).body(doctorService.getDoctors());
    }

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody @Valid  Doctor doctor, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        doctorService.addDo(doctor);
        return ResponseEntity.status(200).body(new ApiResponse("Done ferom adding"));
    }
@PutMapping("/updat/{id}")
    public ResponseEntity updateDo(@RequestBody @Valid Doctor doctor, @PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate=doctorService.updataDoc(doctor, id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Done from update"));
        }
        return ResponseEntity.status(400).body("No id found");
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletDo(@PathVariable String id){
        boolean isDelet=doctorService.deletDoct(id);
        if(isDelet){
            return ResponseEntity.status(200).body(new ApiResponse("Done deleting"));}
        return ResponseEntity.status(400).body(new ApiResponse("Can't found Id"));
    }

    /////////////////
    @GetMapping("/search")
    public ResponseEntity serch(@PathVariable String id){
    Doctor doctor=doctorService.serch(id);
    if(doctor==null){
        return ResponseEntity.status(400).body(new ApiResponse("Can't Found The id for doctor"));
    }
    return ResponseEntity.status(200).body(doctor);
    }
    ///
    @GetMapping("/here")
    public ResponseEntity here(){
        ArrayList<Doctor>newD=doctorService.here();
        if(newD.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("No one here :( "));
        }
    return ResponseEntity.status(200).body(newD);
    }
    @GetMapping("/leav")
    public ResponseEntity leav(){
        ArrayList<Doctor>newD=doctorService.leav();
        if(newD.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Every Thing is good all my doctor here"));
        }
        return ResponseEntity.status(200).body(newD);
    }
    ////////////////////
    @PutMapping("/chang/{id}")
    public ResponseEntity change(@PathVariable String id){
    boolean isChanged=doctorService.change(id);
    if(isChanged){
        return ResponseEntity.status(200).body(new ApiResponse("Done From Changing"));
    }
        return ResponseEntity.status(400).body(new ApiResponse("Can't Found The id for doctor"));

    }


}
