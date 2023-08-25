package funix.huutt.springcv;

import funix.huutt.springcv.controller.LoginController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ClassValidationMvcTest {

    private MockMvc mockMvc;

    @Before(value = "")
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new LoginController())
                .build();
    }

    @Test
    public void givenMatching () throws  Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/register")
                        .accept(MediaType.TEXT_HTML)
                        .param("email","")
                        .param("fullName","")
                        .param("password","")
                        .param("rePassword","")
                        .param("roleId", "0")
        )

        ;
    }
}
