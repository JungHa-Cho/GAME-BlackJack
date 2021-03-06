/*
 * Copyright (c) 2018. JeongHa-Cho all rights reserved.
 */

package com.personal.cjh.v3.card;

import com.personal.cjh.v3.expt.EmptyDeckException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class 유닛_테스트_덱 {

    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
        deck = null;
    }

    @Test
    public void canCreate() {
        assertThat(deck == null, is(false));
    }

    @Test public void 덱_카드가_뽑히는지_테스트() throws EmptyDeckException {
        deck.shuffle();
        assertTrue(deck.drawCard() instanceof Card);
    }

    @Test(expected = EmptyDeckException.class)
    public void 덱_52장_이상_뽑혔을때_익셉션_발생_테스트() throws EmptyDeckException {
        deck.shuffle();
        for (int i = 0; i < 53; i++) {
            deck.drawCard();
        }
    }

    @Test
    public void 덱_52장_뽑았을때_중복_검사() {
        List<Card> cardList = new ArrayList<>();
        deck.shuffle();
        cardList.add(deck.drawCard());
        for (int i = 0; i < 51; i++) {
            Card card = deck.drawCard();
            duplicationCheck(cardList, card);
            cardList.add(card);
        }
    }

    private void duplicationCheck(List<Card> cardList, Card card) {
        for (int j = 0; j < cardList.size(); j++) {
            assertThat(card.isEqualUsingCard(cardList.get(j)), is(false));
            assertThat(cardList.get(j).isEqualUsingCard(card), is(false));
        }
    }
}
