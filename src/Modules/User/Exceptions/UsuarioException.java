package Modules.User.Exceptions;

import Modules.User.Errors.UsuarioErros;

public class UsuarioException extends Exception {
    public UsuarioException(String frase) {
        super(frase);
    }
}
