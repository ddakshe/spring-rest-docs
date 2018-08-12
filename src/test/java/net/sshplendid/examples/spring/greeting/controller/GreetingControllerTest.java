package net.sshplendid.examples.spring.greeting.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;



import net.sshplendid.examples.spring.net.sshplendid.examples.spring.greeting.controller.GreetingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
public class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnJustHello() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andDo(document("home"));
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").doesNotExist())
                .andDo(document("greeting"));
    }

    @Test
    public void shouldReturnMessageWithName() throws Exception {
        String name = "Shin";
        String template = "Hello, %s!";

        this.mockMvc.perform(get("/greeting")
                             .param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.content", is(String.format(template, name))))
                .andDo(document("greeting1", responseFields(
                        fieldWithPath("id").description("Just sequence"),
                        fieldWithPath("name").description("The name of the user"),
                        fieldWithPath("content").description("The welcome message for the user.")
                )));
    }
}
