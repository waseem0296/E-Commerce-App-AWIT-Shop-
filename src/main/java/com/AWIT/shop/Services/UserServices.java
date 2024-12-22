package com.AWIT.shop.Services;

import com.AWIT.shop.Models.User;

public interface UserServices {
     Boolean existsEmail(String email);
     User saveUser(User user);
}
