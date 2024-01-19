package org.example.exception;

public class PasswordMatchException extends RuntimeException{
    public PasswordMatchException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
