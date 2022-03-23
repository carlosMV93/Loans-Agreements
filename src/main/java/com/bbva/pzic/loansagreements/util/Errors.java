package com.bbva.pzic.loansagreements.util;

/**
 * @author Entelgy
 */
public final class Errors {

    /**
     * Lanzado cuando se especifican parámetros cuyos valores son incorrectos en referencia a su sintaxis, tipo de dato, etc.
     */
    public static final String WRONG_PARAMETERS = "wrongParameters";
    /**
     * Lanzado cuando se ha realizado una solicitud en la que hay parámetros obligatorios en la entrada y no se han especificado.
     */
    public static final String MANDATORY_PARAMETERS_MISSING = "mandatoryParametersMissing";
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y no se le asigna un valor.
     */
    public static final String EXPAND_EMPTY = "expandEmpty";
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y el elemento que queremos expandir no es una subentidad de la entidad reflejada en la uri.
     */
    public static final String EXPAND_ERROR = "expandError";
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "filter" y el elemento por el que queremos filtrar no existe.
     */
    public static final String INEXISTENT_FILTER = "inexistentFilter";
    /**
     * Lanzado cuando el formato del filtro de una solicitud es incorrecto en formato.
     */
    public static final String INVALID_FILTER_FORMAT = "invalidFilterFormat";
    /**
     * Lanzado cuando en el servicio se considera que se ha producido un error técnico.
     */
    public static final String TECHNICAL_ERROR = "technicalError";

    private Errors() {
        // Prevent instantiation
    }
}
