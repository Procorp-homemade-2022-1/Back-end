package com.upc.homemade.communicationservice;

import com.upc.homemade.communicationservice.entities.Message;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.repositories.MessageRepository;
import com.upc.homemade.communicationservice.services.MessageService;
import com.upc.homemade.communicationservice.services.impls.MessageServiceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MessageServiceImplIntegrationTest {
    @MockBean
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @TestConfiguration
    static class MessageServiceImpTestConfiguration {
        @Bean
        public MessageService messageService() {
            return new MessageServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Message By Id With Valid Id Then Returns Message")
    public void whenGetMessageByIdWithValidIdThenReturnsRecipe() {
        //Arrange
        String file = "Causa de pollo";
        String description = "La mejor causa de pollo de todo Lima";
        Message message = new Message();
        message.setId(10L);
        message.setFile(file);
        message.setText(description);
        when(messageRepository.findById(10L)).thenReturn(Optional.of(message));
        //Act
        Message foundMessage = messageService.getMessageById(10L);
        //Assert
        assertThat(foundMessage.getId()).isEqualTo(10L);
    }
    @Test
    @DisplayName("When Get Message By Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetMessageByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        // Arrange
        Long id = 10L;
        String template = "Resource %s not found for %s with value %s";
        when(messageRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Message", "Id", id);
        // Act
        Throwable exception = catchThrowable(() -> {
            Message message = messageService.getMessageById(id);
        });
        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
