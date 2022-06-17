package com.upc.homemade.communicationservice;

import com.upc.homemade.communicationservice.entities.Chat;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.repositories.ChatRepository;
import com.upc.homemade.communicationservice.services.ChatService;
import com.upc.homemade.communicationservice.services.impls.ChatServiceImplementation;
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
public class ChatServiceImplIntegrationTest {
    @MockBean
    private ChatRepository chatRepository;

    @Autowired
    private ChatService chatService;

    @TestConfiguration
    static class ChatServiceImpTestConfiguration {
        @Bean
        public ChatService chatService() {
            return new ChatServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Chat By Id With Valid Id Then Returns Chats")
    public void whenGetChatByIdWithValidIdThenReturnsChat() throws ParseException {
        //Arrange
        String title = "Ají amarillo";
        Chat chat = new Chat();
        chat.setId(5L);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("28/10/2020");
        chat.setDate(date);
        when(chatRepository.findById(5L)).thenReturn(Optional.of(chat));
        //Act
        Chat foundChat = chatService.getChatById(5L);
        //Assert
        assertThat(foundChat.getId()).isEqualTo(5L);
    }

    @Test
    @DisplayName("When Get Chat Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetChatByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        //Arrange
        Long id = 5L;
        String template = "Resource %s not found for %s with value %s";
        when(chatRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Chat", "Id", id);

        //Act
        Throwable exception = catchThrowable(() -> {
            Chat chat = chatService.getChatById(id);
        });

        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }
}
