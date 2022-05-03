package com.manyeka.My.webproject.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilesAttach {

    private  String fileName;
    private  String downLoadUrl;
    private  String fileType;
    private Long fileSize;
}

