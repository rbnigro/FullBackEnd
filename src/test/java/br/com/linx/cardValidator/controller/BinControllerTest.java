package br.com.linx.cardValidator.controller;


import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BinController.class)
public class BinControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private BinServer binServer;


    public static final String ANY_BIN_REQUEST = "ANY_BIN_REQUEST";
    public static final String ANY_BIN_RESPONSE = "ANY_BIN_RESPONSE";

    //sucesso
    @Test
    public void postSuccess() throws  Exception{
        FixtureFactoryLoader.loadTemplates("br.com.linx.cardValidator.domains");
        BinTemplate binTemplateRequest = Fixture.from(BinTemplate.class).gimme(ANY_BIN_REQUEST);
        BinTemplate binTemplateResponse = Fixture.from(BinTemplate.class).gimme(ANY_BIN_RESPONSE);
        given(this.binServer.saveBin(any(BinTemplate.class))).willReturn(binTemplateResponse);


        this.mvc.perform(post("/bin/")
                .content(this.objectMapper.writeValueAsString(binTemplateRequest)))
                .andDo(print())
                .andExpect(status().isOk());


    }
    @Test
    public void postErrorSave() {
        given(this.binServer.saveBin(any(BinTemplate.class))).willThrow(Exception.class);
    }

}
