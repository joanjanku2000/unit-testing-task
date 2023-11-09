package org.ikubinfo.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ikubinfo.testing.dao.UserDAO;
import org.ikubinfo.testing.dto.UserDTO;
import org.ikubinfo.testing.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TestingApplicationTests {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserDAO userDAO;

    @Test
    public void save() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("joan.janku@ikubinfo.al");
        userDTO.setUsername("joan.janku@ikubinfo.al");
        userDTO.setPassword("joan.janku@ikubinfo.al");

        mockMvc
                .perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO))
                ).andExpect(status().is2xxSuccessful());

        User user = userDAO.findById(1).orElseThrow(); // assumed
        log.info("USER DAO - {} ", user);
        Assertions.assertEquals(user.getId(), 1);
        Assertions.assertEquals(user.getEmail(), "joan.janku@ikubinfo.al");
        Assertions.assertEquals(user.getPassword(), "joan.janku@ikubinfo.al");
    }

}
