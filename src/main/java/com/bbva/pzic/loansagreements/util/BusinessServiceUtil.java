package com.bbva.pzic.loansagreements.util;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Entelgy
 */
public final class BusinessServiceUtil {

    private BusinessServiceUtil() {
        // Prevent instantiation
    }

    /**
     * Expande los atributos del objeto enviado
     *
     * @param object                  objeto
     * @param possibleJoinedExpanders nombre de todos los atributos, separados por comas, que podr&aacute;n ser expandidos.
     * @param joinedExpandersReceived nombre de los atributos, separados por comas, que se quieren expandir.
     */
    @SuppressWarnings("unchecked")
    public static <T> void expand(T object, String possibleJoinedExpanders, String joinedExpandersReceived) {
        if (object != null && possibleJoinedExpanders != null) {
            if (joinedExpandersReceived != null && joinedExpandersReceived.isEmpty()) {
                throw new BusinessServiceException(Errors.EXPAND_EMPTY);
            }

            final List<String> possibleExpanders = Arrays.asList(possibleJoinedExpanders.split(","));
            final List<String> expandersReceived = joinedExpandersReceived == null
                    ? Collections.<String>emptyList()
                    : Arrays.asList(joinedExpandersReceived.split(","));

            for (final String expander : expandersReceived) {
                if (!possibleExpanders.contains(expander)) {
                    throw new BusinessServiceException(Errors.EXPAND_ERROR, expander);
                }
            }

            final List<String> expandersNotReceived = new ArrayList<>(possibleExpanders);
            expandersNotReceived.removeAll(expandersReceived);
            for (String expander : expandersNotReceived) {
                if (object instanceof Collection<?>) {
                    for (T element : (Collection<T>) object) {
                        setNullOnField(element, expander);
                    }
                } else {
                    setNullOnField(object, expander);
                }
            }
        }
    }

    private static <T> void setNullOnField(T object, String expander) {
        Field field = getFieldByName(object.getClass(), expander);
        if (field != null) {
            field.setAccessible(true);
            try {
                if (!field.getType().isPrimitive()) {
                    field.set(object, null);
                }
            } catch (IllegalAccessException e) {
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        }
    }

    private static Field getFieldByName(Class<?> clazz, String name) {
        if (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (!field.isSynthetic() && field.getName().equals(name)) {
                    return field;
                }
            }
            return getFieldByName(clazz.getSuperclass(), name);
        }
        return null;
    }
}
