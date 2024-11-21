package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model1.PatintModel;
import com.example.lab7.Service.Patient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/patint")
@RequiredArgsConstructor

public class PatintControle {
    private final Patient patientsSer;

    public ResponseEntity getP(){
        return ResponseEntity.status(200).body(patientsSer.getPatintModels());
    }

    @PostMapping("/add")
    public ResponseEntity addP(@RequestBody @Valid PatintModel patient, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        patientsSer.addPatint(patient);

       return ResponseEntity.status(200).body(new ApiResponse("Done from adding"));
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateP(@RequestBody @Valid PatintModel patient, @PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate=patientsSer.updataPatint(patient,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Done from update"));
        }
         return ResponseEntity.status(400).body("No id found");
    }
@DeleteMapping("/delet/{id}")
    public ResponseEntity deletPat(@PathVariable String id){
        boolean isDelet=patientsSer.deletPatint(id);
        if(isDelet){
        return ResponseEntity.status(200).body(new ApiResponse("Done deleting"));}
        return ResponseEntity.status(400).body(new ApiResponse("Can't found Id"));
    }

    @PutMapping("/chang/{id}")
    public ResponseEntity change(@PathVariable String id){
        boolean isChanged= patientsSer.change(id);
        if(isChanged){
            return ResponseEntity.status(200).body(new ApiResponse("Done From Changing"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Can't Found The id for patient"));

    }
    @GetMapping("/list/{typeUser}")
    public ResponseEntity list(@PathVariable String typeUser){
        ArrayList<PatintModel> newL=patientsSer.list(typeUser);
        if(newL.isEmpty())    {
            return ResponseEntity.status(400).body(new ApiResponse("No patient here"));
    }
        return ResponseEntity.status(200).body(newL);
}

@GetMapping("/rang/{min}/{max}")

public ResponseEntity rang(@PathVariable int min,@PathVariable int max){
    ArrayList<PatintModel> newL=patientsSer.rang(min,max);
    if(newL.isEmpty())    {
        return ResponseEntity.status(400).body(new ApiResponse("No patient here"));
    }
    return ResponseEntity.status(200).body(newL);
}





    }




