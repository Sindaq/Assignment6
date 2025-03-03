package org.example.Amazon;

import org.example.Amazon.Cost.PriceRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AmazonIntegrationTest {

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
    void emptyRuleEmptyCart() {
        List<PriceRule> noRules = new ArrayList<>();
        Amazon a = new Amazon(cart, noRules);
        assertEquals(0, a.calculate());
    }

    @Test
    @DisplayName("Specification-based test")
    @Disabled
    void emptyRuleNotEmptyCart() {

        List<PriceRule> noRules = new ArrayList<>();
        Amazon a = new Amazon(cart, noRules);
        List<Item> l = new ArrayList<>();
        when(rule.priceToAggregate(cart.getItems())).thenReturn(10.0);
        assertTrue(a.calculate() > 0);
        //Should return the price of the cart if there's no rules
    }

    @Test
    @DisplayName("Specification-based test")
    void notEmptyRuleEmptyCart() {
        when(rule.priceToAggregate(cart.getItems())).thenReturn(0.0);
        assertEquals(0, amazon.calculate());
    }

    @Test
    @DisplayName("Specification-based test")
    void notEmptyRuleNotEmptyCart() {

        when(rule.priceToAggregate(cart.getItems())).thenReturn(10.0);
        assertEquals(10, amazon.calculate());
    }

}