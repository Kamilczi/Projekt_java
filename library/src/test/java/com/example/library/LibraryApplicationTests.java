package com.example.library;

import com.example.library.controller.LibraryController;
import com.example.library.model.Author;
import com.example.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class LibraryApplicationTests {

	@InjectMocks
	private LibraryController libraryController;

	@Mock
	private LibraryService libraryService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateAuthor() {
		// Given
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Doe");

		// When
		when(libraryService.addAuthor(any(Author.class))).thenReturn(author);

		// Then
		Author createdAuthor = libraryController.createAuthor(author);

		// Assertions
		assertEquals("John", createdAuthor.getFirstName());
		assertEquals("Doe", createdAuthor.getLastName());

		// Verify that the service method was called
		verify(libraryService).addAuthor(author);
	}
}