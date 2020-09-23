package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
}
/*public class UserRepository {
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
        if ((user == null)){
            throw new UserNotFoundException("User does not exist!");
        }else{
            return user;
        }
    }
}*/
