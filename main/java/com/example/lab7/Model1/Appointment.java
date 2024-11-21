package com.example.lab7.Model1;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Appointment {
@NotEmpty(message ="ID for Appointment cannot be Empty!" )
@Size(min = 3,message = "The size must be more than 3 ")
    private String id;

@NotNull(message =" Start Appointment cannot be Empty!")
@Future(message = "Appointment Start date must be in the Future")
 @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate nextAppointment;

    @NotNull(message =" Start Appointment cannot be Empty!")
   @PastOrPresent(message = "Appointment Start date must be in the present or the Past")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate pastAppointment;

    private boolean isFinish=false;



}
