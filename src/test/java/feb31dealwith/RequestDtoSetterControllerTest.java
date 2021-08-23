package feb31dealwith;

import com.fasterxml.jackson.databind.ObjectMapper;
import dateSerialize.WebController;
import jdk.jshell.execution.LoaderDelegate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {RequestDtoSetterController.class, LocalDateFormatter.class})
@WebMvcTest(controllers = {RequestDtoSetterController.class, LocalDateFormatter.class})
class RequestDtoSetterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void GET_20200231_날짜도_LocalDate바인딩이_가능하다() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("date", Arrays.asList("2020-02-31"));

        mockMvc
                .perform(get("/request/setter")
                        .params(params)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"date\":\"2020-02-29\"}"));


//        ResultActions resultActions = mockMvc.perform(get("/request/setter?date=2020-02-31"));
//
//        resultActions
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json("{\"date\":\"2020-02-29\"}"));
    }

    @Test
    public void POST_20200231_날짜도_LocalDate바인딩이_가능하다() throws Exception {
        String content = "{\"date\":\"2020-02-31\"}";
        mockMvc
                .perform(post("/request/setter")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"date\":\"2020-02-29\"}"));
    }

}