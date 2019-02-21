package com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddressServiceTests {

    @Autowired
    WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;

    private ChromeDriver browser;

    @Before
    public void testBefore() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
        browser = new ChromeDriver();
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @WithUserDetails()
    public void testindex() throws Exception {
        mockMvc.perform((get("/hzh")))
                .andExpect(status().isOk())
                .andExpect(view().name("hzh"));
                //.andExpect(model().attribute("books", is(empty())));
    }

    @Test
    public void pageNotFound() {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://localhost/hzh", String.class);
    }

    @Test
    public void addBookToEmptyList() {
        String baseUrl = "http://localhost/hzh/hzh:";
        browser.get(baseUrl);
    }

    @After
    public void closeBrowser() {
        browser.quit();
    }

}

