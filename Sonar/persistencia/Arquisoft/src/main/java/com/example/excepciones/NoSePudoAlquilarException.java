package com.example.excepciones;

public class NoSePudoAlquilarException extends Exception
{

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public NoSePudoAlquilarException( String mensaje )
    {
        super( mensaje );
    }
}