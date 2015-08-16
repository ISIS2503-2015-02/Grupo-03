package com.mycompany.arquisoft.excepciones;

public class OperacionInvalidaException extends Exception
{

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public OperacionInvalidaException( String mensaje )
    {
        super( mensaje );
    }
}