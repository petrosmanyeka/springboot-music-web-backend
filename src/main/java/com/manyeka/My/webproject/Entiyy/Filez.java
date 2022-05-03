package com.manyeka.My.webproject.Entiyy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Filez {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name =  "uuid",strategy = "uuid2")

    private  String filesId;
    private String filezName;
    private String filezType;
    @Lob
    private  byte[] data;

    public Filez(String fileName, String filezType, byte[] data) {
        this.filezName = fileName;
        this.filezType = filezType;
        this.data = data;
    }
}
