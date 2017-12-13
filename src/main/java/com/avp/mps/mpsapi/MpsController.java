package com.avp.mps.mpsapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value={"/api/"}, method = RequestMethod.GET)
public class MpsController {

    @RequestMapping(value={"clients"}, method = RequestMethod.GET)
    public String mainMenu(HttpServletRequest request) {
        String contents = null;
        try {
            //contents = new String(Files.readAllBytes(Paths.get("static/data/customers.json")));
            contents = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("static/data/customers.json").toURI())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Contents (Java 7) : " + contents);

        return contents;
    }
}