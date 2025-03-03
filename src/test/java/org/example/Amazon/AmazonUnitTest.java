package org.example.Amazon;

import org.example.Amazon.Cost.PriceRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AmazonUnitTest {

    ShoppingCart cart;
    Database db;
    PriceRule rule;
    Amazon amazon;

    @BeforeEach
    void init() {

        List<PriceRule> ruleList = new ArrayList<>();
        rule = mock(PriceRule.class);
        ruleList.add(rule);
        db = mock(Database.class);
        cart = new ShoppingCartAdaptor(db);
        amazon = new Amazon(cart, ruleList);
    }

    @Test
    @DisplayName("Specification-based test")
    void emptyCart() {

        List<Item> l = new ArrayList<>();
        when(rule.priceToAggregate(cart.getItems())).thenReturn(0.0);
        assertEquals(0, amazon.calculate());
    }

    @Test
    @DisplayName("Specification-based test")
    void notEmptyCart() {

        List<Item> l = new ArrayList<>();
        when(rule.priceToAggregate(cart.getItems())).thenReturn(10.0);
        assertEquals(10, amazon.calculate());
    }

    @Test
    @DisplayName("Specification-based test")
    void emptyRules() {
        List<PriceRule> noRules = new ArrayList<>();
        Amazon a = new Amazon(cart, noRules);
        assertEquals(0, a.calculate());
    }

    @Test
    @DisplayName("Specification-based test")
    void notEmptyRules() {

        List<Item> l = new ArrayList<>();
        when(rule.priceToAggregate(cart.getItems())).thenReturn(10.0);
        assertEquals(10, amazon.calculate());
    }

}