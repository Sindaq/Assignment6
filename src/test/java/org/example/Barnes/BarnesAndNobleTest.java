package org.example.Barnes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarnesAndNobleTest {

    BookDatabase db;
    BuyBookProcess p;
    BarnesAndNoble b;

    @BeforeEach
    void createObjects() {
        db = mock(BookDatabase.class);
        p = mock(BuyBookProcess.class);
        b = new BarnesAndNoble(db, p);
    }

    @Test
    @DisplayName("Specification-based testing")
    void testNull() {

        assertNull(b.getPriceForCart(null));
    }

    @Test
    @DisplayName("Specification-based testing")
    void testEmpty() {
        HashMap<String, Integer> empty = new HashMap<>();

        assertTrue(b.getPriceForCart(empty).getUnavailable().isEmpty());
    }

    @Test
    @DisplayName("Specification-based testing")
    void testValidISBNEnoughBooks() {

        Book book = new Book("1234567890123", 10, 1);
        when(db.findByISBN("1234567890123")).thenReturn(book);
        HashMap<String, Integer> books = new HashMap<>();
        books.put("1234567890123", 1);

        assertFalse(b.getPriceForCart(books).getUnavailable().containsKey(book));

    }

    @Test
    @DisplayName("Specification-based testing")
    void testInvalidISBN() {

        when(db.findByISBN("1234567890123")).thenReturn(null);
        HashMap<String, Integer> books = new HashMap<>();
        books.put("1234567890123", 1);

        assertThrows(NullPointerException.class, () -> b.getPriceForCart(books).getUnavailable());

    }

    @Test
    @DisplayName("Specification-based testing")
    void testValidISBNNotEnoughBooks() {

        Book book = new Book("1234567890123", 10, 0);
        when(db.findByISBN("1234567890123")).thenReturn(book);
        HashMap<String, Integer> books = new HashMap<>();
        books.put("1234567890123", 1);

        b.getPriceForCart(books);
        assertEquals(1, b.getPriceForCart(books).getUnavailable().get(book));


    }
}