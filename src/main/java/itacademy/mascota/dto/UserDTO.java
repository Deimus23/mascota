package itacademy.mascota.dto;

import itacademy.mascota.model.Pet;

import java.util.ArrayList;

public class UserDTO {
    private String username;
    private String password;
    private String token;
    private ArrayList<Pet> pets=new ArrayList<>();
}
