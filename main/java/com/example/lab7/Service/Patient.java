package com.example.lab7.Service;

import com.example.lab7.Model1.PatintModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Patient {

    ArrayList<PatintModel>patintModels=new ArrayList<>();

    public ArrayList<PatintModel>getPatintModels(){
        return patintModels;
    }


    public void addPatint(PatintModel patintModel){
         patintModels.add(patintModel);
    }


public boolean updataPatint(PatintModel patintModel,String id){
    for (int i = 0; i < patintModels.size(); i++) {
        if(patintModels.get(i).getId().equalsIgnoreCase(id)){
            patintModels.set(i,patintModel);
            return true;
        }

    }

    return false;
}

public boolean deletPatint(String id){
    for (int i = 0; i <patintModels.size() ; i++) {
        if (patintModels.get(i).getId().equalsIgnoreCase(id)){
            patintModels.remove(id);
            return true;
        }

    }
    return false;
}
////////////////////////////
public boolean change(String id){
    for (int i = 0; i < patintModels.size(); i++) {
        if(patintModels.get(i).getId().equalsIgnoreCase(id)){
            if(patintModels.get(i).isADHD()==false){
                patintModels.get(i).setADHD(true);
                return true;
            }
        }

    }
    return false;
}

public ArrayList<PatintModel>list(String typeUser){
        ArrayList<PatintModel>newL=new ArrayList<>();
    for (int i = 0; i < patintModels.size(); i++) {
        if(patintModels.get(i).getTypeUser().equalsIgnoreCase(typeUser)){
            newL.add(patintModels.get(i));
        }
    }
    if(newL.isEmpty()){
        return null;
    }
    return newL;
}
public ArrayList<PatintModel>rang(int min,int max){
        ArrayList<PatintModel>newL=new ArrayList<>();
    for (int i = 0; i < patintModels.size(); i++) {
        if(patintModels.get(i).getAge()>=min&&patintModels.get(i).getAge()<=max){
            newL.add(patintModels.get(i));
        }
    }
    if(newL.isEmpty()){
        return null;
    }
    return newL;
}


}
