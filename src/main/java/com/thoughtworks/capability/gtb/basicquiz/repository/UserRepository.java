package com.thoughtworks.capability.gtb.basicquiz.repository;
import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
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
        EducationRepository.educationMap.put(user.getId(),new ArrayList<>());
        userId++;
        return responseUserId;
    }

    public User getUserById(long userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        // GTB: 这个写法可以简化
        if ((user == null)){
            throw new UserNotFoundException("User does not exist!");
        }else{
            return user;
        }
    }
}
