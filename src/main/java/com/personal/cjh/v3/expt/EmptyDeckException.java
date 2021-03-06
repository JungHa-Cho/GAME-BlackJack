/*
 * Copyright (c) 2018. JeongHa-Cho all rights reserved.
 */

package com.personal.cjh.v3.expt;

/**
 * @author JoengHa-Cho
 * @project BlackJack
 * @update 2018-04-12
 **/
public class EmptyDeckException extends RuntimeException {

    public EmptyDeckException() {
        super();
    }

    public EmptyDeckException(String message) {
        super(message);
    }
}
