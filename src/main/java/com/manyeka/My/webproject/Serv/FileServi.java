package com.manyeka.My.webproject.Serv;


import com.manyeka.My.webproject.Entiyy.Filez;
import org.springframework.web.multipart.MultipartFile;

public interface FileServi {


  public Filez savefile(MultipartFile file) throws Exception;

   public   Filez getFileZ(String fileId) throws Exception;
}
