/*
 * Copyright (c) 2018. JeongHa-Cho all rights reserved.
 */

package com.personal.cjh.v1

import com.personal.cjh.v1.card.Deck
import com.personal.cjh.v1.card.Denomination
import com.personal.cjh.v1.card.Suit
import spock.lang.Specification

class DeckTestBySpock extends Specification {
    def "덱 클래스에서 카드를 받았을때 PAIR 쌍의 인스턴스 검사"() {
        given:
        Deck deck = new Deck()

        when:
        def card = deck.drawDeck()

        then:
        card.check().left instanceof Suit
        card.check().right instanceof Denomination
    }

    def "덱 클래스에서 덱을 받았을때 덱 개수 검사"() {
        given:
        Deck deck = new Deck()

        when:
        def cardDeck = deck.getDeck()

        then:
        cardDeck.size() == 52
    }
}

