package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model1.Appointment;
import com.example.lab7.Model1.Doctor;
import com.example.lab7.Service.ApoimentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/apoim")
@RequiredArgsConstructor

public class ApoimentControl {
    private final ApoimentService apoimentService;

    @GetMapping("/get")
    public ResponseEntity getApoi(){
        return ResponseEntity.status(200).body(apoimentService.getApo());
    }

    @PostMapping("/add")
    public ResponseEntity addApoi(@RequestBody @Valid Appointment appointment, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          apoimentService.addAp(appointment);
        return ResponseEntity.status(200).body(new ApiResponse("Done ferom adding"));
    }

    @PutMapping("/updat/{id}")
    public ResponseEntity updateP(@RequestBody @Valid Appointment appointment, @PathVariable String id, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate=apoimentService.updataAp(appointment,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Done from update"));
        }
        return ResponseEntity.status(400).body("No id found");
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletDo(@PathVariable String id){
        boolean isDelet=apoimentService.deletApo(id);
        if(isDelet){
            return ResponseEntity.status(200).body(new ApiResponse("Done deleting"));}
        return ResponseEntity.status(400).body(new ApiResponse("Can't found Id"));
    }

    @GetMapping("/finish")
    public ResponseEntity finish(){
        ArrayList<Appointment>yet=apoimentService.finish();
        if(yet.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Appointment still there"));
        }
       return ResponseEntity.status(200).body(yet);

    }
    @GetMapping("/getF/{startApo}")
    public ResponseEntity futur(@PathVariable LocalDate startApo){
        ArrayList<Appointment>fu=apoimentService.futur(startApo);
        if(fu.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("there no Futur appointment"));
        }
        return ResponseEntity.status(200).body(fu);
    }
    @GetMapping("/getP/{endApo}")
    public ResponseEntity past(@PathVariable LocalDate endApo){
        ArrayList<Appointment>pa=apoimentService.past(endApo);
        if(pa.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("there no Futur appointment"));
        }
        return ResponseEntity.status(200).body(pa);
    }

    @PutMapping("/change/{id}")
public ResponseEntity change(@PathVariable String id){
        boolean isChanged=apoimentService.change(id);
        if(isChanged){
            return ResponseEntity.status(200).body(new ApiResponse("Done Changing for appointment state"));
        }
    return ResponseEntity.status(200).body(new ApiResponse("Can't found the appointment"));
}




}
