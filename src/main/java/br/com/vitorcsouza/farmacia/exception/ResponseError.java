package br.com.vitorcsouza.farmacia.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(String Message, HttpStatus Status, LocalDateTime Time) {
}
