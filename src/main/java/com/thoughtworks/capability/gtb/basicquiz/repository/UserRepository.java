package com.thoughtworks.capability.gtb.basicquiz.repository;
import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Long userId = 1L;
    public static Map<Long, User> userMap = new HashMap<>();

    public long createNewUser(User user){
        long responseUserId = userId;
        user.setId(userId);
        userMap.put(user.getId(),user);
        userId++;
        return responseUserId;
    }
}
