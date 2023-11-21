
//У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
// Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    void findBookByIdTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1", "Title", "Author");

        when(bookRepository.findById("1")).thenReturn(book1);

        // проверяю, что при обращении к методу findBookById в BookService, возвращается книга с заданным ID
        assertThat(bookService.findBookById("1")).isEqualTo(book1);
        // проверяю, что метод вызывался один раз
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    void findAllBooksTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        List<Book> books = new ArrayList<>();
        Book book1 = new Book("1", "Title1", "Author1");
        Book book2 = new Book("2", "Title2", "Author2");
        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);

        assertThat(bookService.findAllBooks()).isEqualTo(books);
        assertThat(bookService.findAllBooks().size()).isEqualTo(2);
    }



}
