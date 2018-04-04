/*
 * Copyright (c) 2018. JeongHa-Cho all rights reserved.
 */

package com.personal.cjh.v2.rule.ace;

import com.personal.cjh.v2.card.Denomination;
import com.personal.cjh.v2.card.Suit;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * 딜러 룰
 * 버스트가 아니면 무조건 11로 계산
 * ex A 11, x 6 이라면, 버스트 가 아니기 때문에 17로 계산하고
 * 무조건 STAY 하는것을 의미
 */
public class UnlessBust implements Ace {
    @Override
    public boolean isEleven(List<Pair<Suit, Denomination>> hand) {
        int aceSum = 0;
        int noAceSum = 0;
        for (Pair<Suit, Denomination> card : hand) {
            if (card.getRight() == Denomination.ACE) {
                aceSum += 11;
                noAceSum += Denomination.ACE.getProperty();
            } else {
                aceSum += card.getRight().getProperty();
                noAceSum += card.getRight().getProperty();
            }
        }

        if (aceSum > 21)
            return false;
        else
            return true;
    }
}
