package org.example.exception;

public class EntityValueNullCheckException extends RuntimeException{
    public EntityValueNullCheckException() {
        super("데이터를 찾을 수 없습니다.");
    }
}
