package com.manyeka.My.webproject.Controls;

import com.manyeka.My.webproject.Entiyy.Users;
import com.manyeka.My.webproject.Serv.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserContr {

    @Autowired
    private UserServ userServ;

   @PostMapping
    public Users storeUsers(@RequestBody Users users){
        return userServ.storeUser(users);
   }
   
   @GetMapping

    public List<Users> getUsers(){
       return userServ.getUsers();
   }

    @GetMapping("/mv/{id}")

    public  Users fetchById(@PathVariable("id") int userId){
       return  userServ.fetchById(userId);
    }
    @DeleteMapping("/mp/{id}")

    public String deleteTheUserById(@PathVariable ("id") int userId){
       userServ.deleteTheUserById(userId);
       return "the user is deleted";
    }
        @PutMapping("/up/{id}")
    public Users updates(@PathVariable("id") int userId ,@RequestBody Users users){
       return userServ.updates(userId,users);
    }
    @GetMapping("/nam/{name}")

    private  Users fetchByName(@PathVariable("name") String name){
       return userServ.fetchByName(name);
    }
}
