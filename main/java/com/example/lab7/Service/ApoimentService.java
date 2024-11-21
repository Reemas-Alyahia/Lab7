package com.example.lab7.Service;

import com.example.lab7.Model1.Appointment;
import com.example.lab7.Model1.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ApoimentService {
    ArrayList<Appointment>appointments=new ArrayList<>();

    public ArrayList<Appointment>getApo(){
        return appointments;
    }
    public void addAp(Appointment appointment){
      appointments.add(appointment);    }

    public boolean updataAp(Appointment appointment, String id){
        for (int i = 0; i < appointments.size(); i++) {
            if(appointments.get(i).getId().equalsIgnoreCase(id)){
                appointments.set(i,appointment);
                return true;
            }

        }
        return false;
    }

    public boolean deletApo(String id){
        for (int i = 0; i <appointments.size(); i++) {
            if (appointments.get(i).getId().equalsIgnoreCase(id)){
                appointments.remove(id);
                return true;
            }

        }
        return false;
    }

    ////////////////////////

    public ArrayList<Appointment> finish(){
        ArrayList<Appointment>yet=new ArrayList<>();
        for (int i = 0; i <appointments.size() ; i++) {
            if(appointments.get(i).isFinish()==false){
                yet.add(appointments.get(i));
            }
        }
        if(yet.isEmpty()){
            return null;
        }
        return yet;
    }


    public ArrayList<Appointment>futur(LocalDate startApo){
        ArrayList<Appointment>newF=new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < appointments.size(); i++) {
            if(appointments.get(i).getNextAppointment().isAfter(today)){
                newF.add(appointments.get(i));
            }
        }
        if(newF.isEmpty()){
            return null;
        }
        return newF;
    }
public ArrayList<Appointment>past(LocalDate endApo){
        ArrayList<Appointment>pas=new ArrayList<>();
        LocalDate today=LocalDate.now();
    for (int i = 0; i < appointments.size(); i++) {
        if(appointments.get(i).getPastAppointment().isBefore(today)){
            pas.add(appointments.get(i));

        }
    } if(pas.isEmpty()){
        return null;
    }
    return pas;
}


public boolean change(String id){
    for (int i = 0; i < appointments.size(); i++) {
        if(appointments.get(i).getId().equalsIgnoreCase(id)){
            if(appointments.get(i).isFinish()==false){
                appointments.get(i).setFinish(true);
                return true;
            }
        }

    }
    return false;

}

}
