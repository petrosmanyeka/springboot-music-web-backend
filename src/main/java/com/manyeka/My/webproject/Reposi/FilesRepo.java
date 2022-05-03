package com.manyeka.My.webproject.Reposi;

import com.manyeka.My.webproject.Entiyy.Filez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FilesRepo extends JpaRepository <Filez,String> {
}
