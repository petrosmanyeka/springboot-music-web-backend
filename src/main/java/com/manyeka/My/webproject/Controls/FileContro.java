package com.manyeka.My.webproject.Controls;

import com.manyeka.My.webproject.Entiyy.Filez;
import com.manyeka.My.webproject.Models.FilesAttach;
import com.manyeka.My.webproject.Serv.FileServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileContro {
    @Autowired
    private FileServi fileServi;

    public FileContro(FileServi fileServi) {
        this.fileServi = fileServi;
    }

    @PostMapping("/uploads")

    public FilesAttach uploadFile(@RequestParam("files") MultipartFile file) throws Exception {
        Filez filez = null;

        String downLoadUrl = "";
        filez = fileServi.savefile(file);
        downLoadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloads/").path(filez.getFilesId())
                .toUriString();


        return new  FilesAttach(filez.getFilezName(),downLoadUrl,file.getContentType(),file.getSize());




    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable String fileId) throws Exception {
        Filez filez = null;
        filez = fileServi.getFileZ(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(filez.getFilezType())).header(HttpHeaders.CONTENT_DISPOSITION,
                "filez ; fileName=\"" + filez.getFilezName() + "\"").body(new ByteArrayResource(filez.getData()));

    }
}
