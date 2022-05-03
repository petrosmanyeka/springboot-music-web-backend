package com.manyeka.My.webproject.Serv;

import com.manyeka.My.webproject.Entiyy.Users;

import java.util.List;

public interface UserServ {
   public Users storeUser(Users users);

  public List<Users> getUsers();


   public Users fetchById(int userId);

    public void deleteTheUserById(int userId);

   public Users updates(int userId, Users users);

   public Users fetchByName(String name);
}
