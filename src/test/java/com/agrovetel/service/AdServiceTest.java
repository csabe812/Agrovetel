package com.agrovetel.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.domain.Manufacturer;
import com.agrovetel.domain.User;
import com.agrovetel.repository.AdRepository;

public class AdServiceTest {

	@Autowired
	private AdService adService;

	@Mock
	private AdRepository adRepository;

	@Mock
	List<Ad> adList;
	
	Ad ad;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		adService = new AdService();
		adService.setAdRepository(adRepository);
	}

	@Test
	public void shouldReturnAdList_whenFindAllIsCalled() throws Exception {
		// Arrange
		when(adRepository.findAll()).thenReturn(adList);
		// Act
		List<Ad> retrievedAdList = (List<Ad>) adService.findAll();
		// Assert
		assertThat(retrievedAdList, is(equalTo(adList)));
	}

}
