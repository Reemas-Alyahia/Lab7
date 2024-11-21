package com.example.lab7.Service;

import com.example.lab7.Model1.Doctor;
import com.example.lab7.Model1.PatintModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DoctorService {

    ArrayList<Doctor>doctors=new ArrayList<>();

    public ArrayList<Doctor>getDoctors(){
        return doctors;
    }
    public void addDo(Doctor doctor){
        doctors.add(doctor);
    }

    public boolean updataDoc(Doctor doctor, String id){
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).getId().equalsIgnoreCase(id)){
               doctors.set(i,doctor);
                return true;
            }

        }
        return false;
    }
    public boolean deletDoct(String id){
        for (int i = 0; i <doctors.size(); i++) {
            if (doctors.get(i).getId().equalsIgnoreCase(id)){
                doctors.remove(id);
                return true;
            }

        }
        return false;
    }
    ///////////////////////
    public Doctor serch(String id){
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).getId().equalsIgnoreCase(id)){
             return doctors.get(i);
            }
        }
        return null; }
    ////
    public ArrayList<Doctor>here(){
        ArrayList<Doctor> newD=new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).isLeav()==false){
            }
        }
        if(newD.isEmpty()){
            return null;
        }
        return newD;
    }

    public ArrayList<Doctor>leav(){
        ArrayList<Doctor>newD=new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).isLeav()==true){

            }

        }
        if(newD.isEmpty()){
            return null;
        }
        return newD;
    }
    public boolean change(String id){
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).getId().equalsIgnoreCase(id)){
                if(doctors.get(i).isLeav()==false){
                    doctors.get(i).setLeav(true);
                    return true;
                }
            }

        }
        return false;
    }

}
