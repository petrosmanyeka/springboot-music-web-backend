package com.manyeka.My.webproject.Serv;

import com.manyeka.My.webproject.Entiyy.Filez;
import com.manyeka.My.webproject.Reposi.FilesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiImple implements FileServi{

    @Autowired
    private FilesRepo filesRepo;

    public FileServiImple(FilesRepo filesRepo) {
        this.filesRepo = filesRepo;
    }


    @Override
    public Filez savefile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new Exception("the file contains contains invalide content" + fileName);

            }

            Filez filez = new Filez(fileName,file.getContentType(),file.getBytes());
            return filesRepo.save(filez);
        } catch(Exception e){
            throw new Exception("could not save the file");

        }



    }

    @Override
    public Filez getFileZ(String fileId) throws Exception {
        return filesRepo.findById(fileId).orElseThrow(() ->new Exception("file not found " + fileId));
    }


}

