package com.AWIT.shop.RestAPI;

import com.AWIT.shop.Models.User;
//import com.AWIT.shop.Services.imp.User_Services;
import com.AWIT.shop.Services.UserServices;
import com.AWIT.shop.Services.imp.User_ServicesImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserServices userService;

    @PostMapping(path = "/saveUser")
    public String saveUser(@RequestBody User user, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {

        Boolean existsEmail = userService.existsEmail(user.getEmail());

        if (existsEmail) {
            session.setAttribute("errorMsg", "Email already exist");
        } else {
            String imageName = file.isEmpty() ? "default.jpg" : file.getOriginalFilename();
            user.setProfileImage(imageName);
            User saveUser = userService.saveUser(user);

            if (!ObjectUtils.isEmpty(saveUser)) {
                if (!file.isEmpty()) {
                    File saveFile = new ClassPathResource("static/img").getFile();

                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "profile_img" + File.separator
                            + file.getOriginalFilename());

//					System.out.println(path);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }
                session.setAttribute("succMsg", "Register successfully");
            } else {
                session.setAttribute("errorMsg", "something wrong on server");
            }
        }
        return "User registered successfully";
//        return "redirect:/register";
    }
}



//        try {
//            return userServices.saveUser();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return new ResponseEntity<String>("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }


