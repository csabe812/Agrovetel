package com.agrovetel.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.agrovetel.service.AdService;

@RunWith(SpringRunner.class)
@WebMvcTest(AdController.class)
public class AdControllerTest {
	
	private final String PATH_ADS = "/ads";
	private final String VIEW_ADS = "ads";
	
	@Autowired
    private MockMvc mockMvc;
   
    @MockBean
    private AdService adService;
    
    @Test
    public void testAds() throws Exception{
           this.mockMvc.perform(get(PATH_ADS))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_ADS))
                .andDo(print());
    }
    
    
    
}
