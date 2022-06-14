package com.upc.homemade.communicationservice;

import com.upc.homemade.communicationservice.entities.Publication;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.repositories.PublicationRepository;
import com.upc.homemade.communicationservice.services.PublicationService;
import com.upc.homemade.communicationservice.services.impls.PublicationServiceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PublicationServiceImplIntegrationTest {
    @MockBean
    private PublicationRepository publicationRepository;

    @Autowired
    private PublicationService publicationService;

    @TestConfiguration
    static class  PublicationServiceImpTestConfiguration {
        @Bean
        public PublicationService publicationService(){
            return new PublicationServiceImplementation();
        }
    }


    @Test
    @DisplayName("When Get Publication By Id With Valid Id Then Returns Publication")
    public void whenGetPublicationByIdWithValidIdThenReturnsPublication() throws ParseException {
        //Arrange
        Publication publication = new Publication();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("28/10/2020");
        publication.setId(1L);
        publication.setText("Me encanta la paguina homemade");
        publication.setDate(date);
        when(publicationRepository.findById(1L)).thenReturn(Optional.of(publication));
        //Act
        Publication foundPublication = publicationService.getPublicationById(1L);
        //Assert
        assertThat(foundPublication.getId()).isEqualTo(1L);
    }
    @Test
    @DisplayName("When Get Publication By Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetPublicationByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(publicationRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Publication", "Id", id);
        //Act
        Throwable exception = catchThrowable(()->{
            Publication publication = publicationService.getPublicationById(id);
        });
        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }
}
