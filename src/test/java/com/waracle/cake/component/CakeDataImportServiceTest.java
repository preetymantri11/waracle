package com.waracle.cake.component;

import com.waracle.cake.domain.Cake;
import com.waracle.cake.repository.CakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CakeDataImportServiceTest.TestConfig.class})
public class CakeDataImportServiceTest {

    @Configuration
    public static class TestConfig {

        @Bean
        public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
            final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
            ppc.setLocations(new ClassPathResource("/application.properties"));
            return ppc;
        }

        @Bean
        public CakeDataImportService cakeDataImportService() {
            return new CakeDataImportService();
        }

        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }

        @Bean
        public CakeRepository cakeRepository() {
            return Mockito.mock(CakeRepository.class);
        }

    }

    @Inject
    CakeDataImportService cakeDataImportService;

    @Inject
    RestTemplateBuilder restTemplateBuilder;

    @MockBean CakeRepository cakeRepository;

    @Test
    public void initalizeCakeData() {
        cakeDataImportService.initalizeCakeData();
        Mockito.verify(cakeRepository, Mockito.times(40)).save(Mockito.any(Cake.class));
    }
}