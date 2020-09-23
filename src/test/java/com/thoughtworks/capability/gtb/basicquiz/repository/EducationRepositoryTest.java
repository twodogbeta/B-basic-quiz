package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domain.Education;
import com.thoughtworks.capability.gtb.basicquiz.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class EducationRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EducationRepository educationRepository;

    @Test
    public void should_find_all_by_userId() {
        User user = User.builder()
                .name("KAMIL")
                .age(26)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, " +
                        "dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut " +
                        "fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        entityManager.persistAndFlush(user);
        Long userId = user.getId();
        Education education2005 = Education.builder()
                .user(user)
                .year(2005)
                .title("Secondary school specializing in artistic")
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        Education education2009 = Education.builder()
                .user(user)
                .year(2009)
                .title("First level graduation in Graphic Design")
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .build();
        entityManager.persistAndFlush(education2005);
        entityManager.persistAndFlush(education2009);

        List<Education> educations = educationRepository.findAllByUserId(userId);
        assertEquals(2, educations.size());
        assertEquals(2005, educations.get(0).getYear());
        assertEquals(2009, educations.get(1).getYear());

    }
}

