package com.manyeka.My.webproject.Reposi;

import com.manyeka.My.webproject.Entiyy.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <Users,Integer> {
public Users findByName(String name);
}
