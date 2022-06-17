package com.upc.homemade.communicationservice;

import com.upc.homemade.communicationservice.entities.Comment;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.repositories.CommentRepository;
import com.upc.homemade.communicationservice.services.CommentService;
import com.upc.homemade.communicationservice.services.impls.CommentServiceImplementation;
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
public class CommentServiceImplIntegrationTest {
    @MockBean
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @TestConfiguration
    static class CommentServiceImpTestConfiguration {
        @Bean
        public CommentService commentService() {
            return new CommentServiceImplementation();
        }
    }

    @Test
    @DisplayName("When Get Comment By Id With Valid Id Then Returns Comment")
    public void whenGetCommentByIdWithValidIdThenReturnsComment() throws ParseException {
        //Arrange
        String description = "La mejor causa de pollo de todo Lima";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("28/10/2020");
        Comment comment = new Comment();
        comment.setId(10L);
        comment.setLikes(10);
        comment.setText(description);
        comment.setDate(date);

        when(commentRepository.findById(10L)).thenReturn(Optional.of(comment));
        //Act
        Comment foundComment = commentService.getCommentById(10L);

        //Assert
        assertThat(foundComment.getId()).isEqualTo(10L);
    }
    @Test
    @DisplayName("When Get Comment By Id With Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetCommentByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        // Arrange
        Long id = 10L;
        String template = "Resource %s not found for %s with value %s";
        when(commentRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Comment", "Id", id);
        // Act
        Throwable exception = catchThrowable(() -> {
            Comment comment = commentService.getCommentById(id);
        });
        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
