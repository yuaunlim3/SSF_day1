package vttp.ssf.day1.controller;


import java.io.File;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day1.controller.Constants;

//make this a request handler
@Controller
//handles the photo resource
@RequestMapping
public class PhotoController {
        //This method to handle GET /time
        @GetMapping({"/", "/index.html"})

        //inject the model into handler
        public String getPicOfDay(Model model){    
            //Bind data to model
            model.addAttribute("image",getPhoto());
    
            //Display the template
            return "photo";
        }

        private String getPhoto(){
            Random rand = new SecureRandom();
            int index = rand.nextInt(Constants.PICTURES.length);
            return String.format("/images/%s",vttp.ssf.day1.controller.Constants.PICTURES[index]);
        }
}
