package utils;

import java.util.Arrays;
import java.util.List;

public class Result<T> {

    public static final Unit UNIT = Unit.VALUE;

    private final T value;
    private final List<String> errors;
    private final boolean isSuccess;

    // Constructor para éxito
    private Result(T value) {
        this.value = value;
        this.errors = null;
        this.isSuccess = true;
    }

    // Constructor para fracaso
    private Result(List<String> errors) {
        this.value = null;
        this.errors = errors;
        this.isSuccess = false;
    }

    // Métodos estáticos para instancias de éxito y fracaso
    public static <T> Result<T> success(T value) {
        return new Result<>(value);
    }

    public static Result<Unit> success() {
        return new Result<>(UNIT);
    }

    public static <T> Result<T> failureWithErrors(List<String> errors) {
        return new Result<>(errors);
    }

    public static <T> Result<T> failureWithError(String error) {
        return new Result<>(Arrays.asList(error));
    }

    public static Result<Unit> unitFailureWithErrors(List<String> errors) {
        return new Result<>(errors);
    }

    public static Result<Unit> unitFailureWithError(String error) {
        return new Result<>(Arrays.asList(error));
    }

    // Getters para valor y errores
    public T getValue() {
        if (isSuccess) {
            return value;
        } else {
            throw new IllegalStateException("No se puede obtener el valor de un resultado fallido");
        }
    }

    public List<String> getErrors() {
        if (!isSuccess) {
            return errors;
        } else {
            throw new IllegalStateException("No se puede obtener los errores de un resultado exitoso");
        }
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    // Clase anidada para representar Unit
    public static class Unit {
        public static final Unit VALUE = new Unit();

        private Unit() {}
    }
}


