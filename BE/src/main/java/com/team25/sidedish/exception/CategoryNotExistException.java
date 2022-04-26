package com.team25.sidedish.exception;

public class CategoryNotExistException extends NotExistException {

    public CategoryNotExistException() {
        super("해당 아이디의 카테고리가 존재하지 않습니다");
    }
}
