package com.spring.professional.exam.tutorial.module04.question43.data.transfer;

import com.spring.professional.exam.tutorial.module04.question43.data.layer.FtpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.layer.HttpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataTransferAction {

    @Autowired
    FtpDataLayer ftpDataLayer;
    @Autowired
    HttpDataLayer httpDataLayer;

    public void transfer() {
        List<Person> personData = ftpDataLayer.getData();

        httpDataLayer.saveData(personData);
    }
}
