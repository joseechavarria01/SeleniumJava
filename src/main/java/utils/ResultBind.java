package utils;

import java.util.function.Function;

public class ResultBind {

    // Método `bind` para transformar un ResultV2<T> en ResultV2<U> utilizando un método que devuelve ResultV2<U>
    public static <T, U> Result<U> bind(Result<T> r, Function<T, Result<U>> method) {
        return r.isSuccess()
                ? method.apply(r.getValue())
                : Result.failureWithErrors(r.getErrors());
    }

    // Método `map` para transformar un ResultV2<T> en ResultV2<U> utilizando un método que devuelve U
    public static <T, U> Result<U> map(Result<T> r, Function<T, U> mapper) {
        return r.isSuccess()
                ? Result.success(mapper.apply(r.getValue()))
                : Result.failureWithErrors(r.getErrors());
    }

    // Método `bindUnit` para realizar una operación que no devuelve valor (unitario)
    public static <T> Result<Result.Unit> bindUnit(Result<T> r, Function<T, Result<Result.Unit>> method) {
        return r.isSuccess()
                ? method.apply(r.getValue())
                : Result.unitFailureWithErrors(r.getErrors());
    }

    // Método `mapUnit` para realizar una operación sin valor y manejar errores
    public static <T> Result<Result.Unit> mapUnit(Result<T> r, Function<T, Void> action) {
        if (r.isSuccess()) {
            action.apply(r.getValue());
            return Result.success(); // Retorna un resultado exitoso sin valor
        } else {
            return Result.unitFailureWithErrors(r.getErrors());
        }
    }

    // Método adicional para casos donde sólo hay un error específico en forma de cadena
    public static <T, U> Result<U> mapFailure(Result<T> r, String error) {
        return r.isSuccess()
                ? Result.failureWithError(error)
                : Result.failureWithErrors(r.getErrors());
    }
}
