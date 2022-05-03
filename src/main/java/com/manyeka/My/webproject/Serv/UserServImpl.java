package com.manyeka.My.webproject.Serv;


import com.manyeka.My.webproject.Entiyy.Users;
import com.manyeka.My.webproject.Reposi.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServImpl implements  UserServ{

    @Autowired
    private UserRepo userRepo;
    @Override
    public Users storeUser(Users users) {
        return userRepo.save(users );
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users fetchById(int userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public void deleteTheUserById(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public Users updates(int userId, Users users) {
        Users check = userRepo.findById(userId).get();
        if(Objects.nonNull(users.getName())&& !"".equalsIgnoreCase(users.getName())){
            check.setName(users.getName());
        }
        if(Objects.nonNull(users.getPassW()) && !"".equalsIgnoreCase(users.getPassW())){
            check.setPassW(users.getPassW());
        }
        if(Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())){
            check.setEmail(users.getPassW());
        }

        return userRepo.save(users);
    }

    @Override
    public Users fetchByName(String name) {
        return userRepo.findByName(name);
    }


}
