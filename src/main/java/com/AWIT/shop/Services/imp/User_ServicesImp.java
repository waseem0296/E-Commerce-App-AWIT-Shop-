package com.AWIT.shop.Services.imp;

import com.AWIT.shop.Models.User;
import com.AWIT.shop.Repository.UserRepository;
import com.AWIT.shop.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class User_ServicesImp implements UserServices {


    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


//
//    public Revc  sponseEntity<String> signUp(Map<String, String> requestMap) {
//        try {
//            if (validateSignUp(requestMap)) {
//                User user = userDao.findByEmailId(requestMap.get("name"));
//                if (Objects.isNull(user)) {
//
//                    userDao.save(getUserFromMap(requestMap));
//                    return new ResponseEntity<>("User successfully signed up.", HttpStatus.OK);
//                } else {
//                    return new ResponseEntity<String>("name already exist", HttpStatus.BAD_GATEWAY);
//                }
//
//            } else {
//                return new ResponseEntity<String>("Invalid data", HttpStatus.BAD_REQUEST);
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return new ResponseEntity<String>("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    //    ----validate the signup values
    ///////////////////////////////////////////////
//    private boolean validateSignUp(Map<String, String> requestMap) {
//        return requestMap.containsKey("name") ;
////                requestMap.containsKey("contactNumber") &&
////                requestMap.containsKey("email") &&
////                requestMap.containsKey("password");
//    }

    //---get user data from the map
//    private User getUserFromMap(Map<String,String> requestMap){
//        User user=new User();
//
//        user.setName(requestMap.get("name"));
////        user.setContactNumber(requestMap.get("contactNumber"));
////        user.setEmail(requestMap.get("email"));
////        user.setPassword(requestMap.get("password"));
////        user.setStatus("false");
////        user.setRole("user");
//        return user;
//    }

    public User saveUser(User user) {
        user.setRole("ROLE_USER");
        user.setAccountNonLocked(true);
        user.setFailedAttempt(0);
        user.setIsEnable(true);
        String passwordEncode=passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        User userSave=userRepository.save(user);
        return userSave;

    }

    public Boolean existsEmail(String email) {
        if(userRepository.existsByEmail(email)){
            return true;
        }
        return false;
    }
}
