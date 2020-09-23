package com.thoughtworks.capability.gtb.basicquiz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.basicquiz.domain.Education;
import com.thoughtworks.capability.gtb.basicquiz.domain.User;
import com.thoughtworks.capability.gtb.basicquiz.repository.EducationRepository;
import com.thoughtworks.capability.gtb.basicquiz.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EducationRepository educationRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    private long user_id;

    @BeforeEach
    void init() {
        educationRepository.deleteAll();
        userRepository.deleteAll();
        User user = User.builder()
                .name("KAMIL")
                .age(24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, " +
                        "dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut " +
                        "fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();

        userRepository.save(user);
        user_id = user.getId();
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
        educationRepository.save(education2005);
        educationRepository.save(education2009);
    }

    @Test
    public void should_get_user_by_id() throws Exception {
        mockMvc.perform(get("/users/" + user_id))
                .andExpect(jsonPath("$.name", is("KAMIL")))
                .andExpect(jsonPath("$.age", is(24)))
                .andExpect(status().isOk());
    }



    @Nested
    public class AddUser {
        @Test
        public void should_add_user() throws Exception {
            User user = User.builder()
                    .name("Jim")
                    .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                    .description("I am a happy boy!")
                    .age(26)
                    .build();

            String jsonData = objectMapper.writeValueAsString(user);
            mockMvc.perform(post("/users")
                    .content(jsonData).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.name", is("Jim")))
                    .andExpect(jsonPath("$.avatar", is("https://inews.gtimg.com/newsapp_match/0/3581582328/0")));
        }

        @Test
        public void should_throw_badRequest_when_given_invalid_age() throws Exception {
            User user = User.builder()
                    .name("Mary")
                    .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                    .description("sad girl")
                    .age(15)
                    .build();

            String jsonData = objectMapper.writeValueAsString(user);
            mockMvc.perform(post("/users")
                    .content(jsonData).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }
    }

    @Test
    public void should_get_educations() throws Exception {
        mockMvc.perform(get("/users/" + user_id + "/educations"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].year", is(2009)))
                .andExpect(status().isOk());
    }


    @Nested
    public class AddNewEducation {
        @Test
        public void should_add_education() throws Exception {
            User user = User.builder()
                    .name("Peter")
                    .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                    .description("Work hard boy!")
                    .age(25)
                    .build();

            userRepository.save(user);
            Education education = Education.builder()
                    .user(user)
                    .year(2009)
                    .title("First level graduation in Graphic Design")
                    .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                    .build();

            String jsonData = objectMapper.writeValueAsString(education);

            mockMvc.perform(post("/users/" + user_id + "/educations")
                    .content(jsonData).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
        }

        @Test
        public void should_throw_badRequest_when_given_invalid_title() throws Exception {
            User user = User.builder()
                    .name("Nelson")
                    .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                    .description("cool boy!")
                    .age(26)
                    .build();

            userRepository.save(user);
            Education education = Education.builder()
                    .user(user)
                    .year(2009)
                    .title("Secondary school specializing in artisticdjgfljdaghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" +
                            "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                            "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
                    .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                    .build();

            String jsonData = objectMapper.writeValueAsString(education);

            mockMvc.perform(post("/users/" + user_id + "/educations")
                    .content(jsonData).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }

    }

}