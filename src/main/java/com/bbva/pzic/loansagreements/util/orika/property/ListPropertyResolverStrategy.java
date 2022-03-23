package com.bbva.pzic.loansagreements.util.orika.property;


import com.bbva.pzic.loansagreements.util.orika.MappingException;
import com.bbva.pzic.loansagreements.util.orika.metadata.ClassMapBuilderForArrays;
import com.bbva.pzic.loansagreements.util.orika.metadata.ClassMapBuilderForLists;
import com.bbva.pzic.loansagreements.util.orika.metadata.NestedProperty;
import com.bbva.pzic.loansagreements.util.orika.metadata.Property;
import com.bbva.pzic.loansagreements.util.orika.metadata.Type;

/**
 * Created on 18/10/2017.
 * Permite la interpretacion de [#] para los listados, referencia:
 * ma.glasnost.orika.property.PropertyResolver v1.4.5
 *
 * @author Entelgy
 */
public class ListPropertyResolverStrategy extends IntrospectorPropertyResolver {

    @Override
    protected Property getProperty(java.lang.reflect.Type type, String expression, boolean isNestedLookup) throws MappingException {

        if (hasIndexElementExpression(expression)) {
            return getIndividualElementProperty(type, expression);
        }

        return super.getProperty(type, expression, isNestedLookup);
    }

    /**
     * Determines whether the provided string is a valid element property
     * expression by index
     *
     * @param expression the expression to evaluate
     * @return true if the expression represents an element property by index
     */
    private boolean hasIndexElementExpression(String expression) {
        return expression.contains("[") && expression.endsWith("]");
    }

    /**
     * @param type
     * @param expression
     * @return the Property represented by the specified element property
     * expression
     * TODO: Revisar la creacion del Property para la expresion [n], este contiene la expresion y metodos getters/setters
     */
    @SuppressWarnings("unchecked")
    private Property getIndividualElementProperty(java.lang.reflect.Type type, String expression) {

        String[] splittedExpression = expression.split("\\[", 2);
        String elementPropertyExpression = splittedExpression[1].substring(0, splittedExpression[1].length() - 1);

        Property owningProperty = getProperty(type, splittedExpression[0]);

        Property elementProperty;
        if (owningProperty.isCollection()) {
            try {
                elementProperty = getPropertyForLists(elementPropertyExpression, owningProperty.getType());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'" + expression + "' is not a valid element property for " + type);
            }
        } else if (owningProperty.isArray()) {
            try {
                elementProperty = getPropertyForArray(elementPropertyExpression, owningProperty.getType());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'" + expression + "' is not a valid element property for " + type);
            }
        } else {
            throw new IllegalArgumentException("'" + expression + "' is not a valid element property for " + type);
        }

        if (!"".equals(owningProperty.getName())) {
            elementProperty = new NestedProperty(expression, elementProperty, new Property[]{owningProperty}, owningProperty);
        }
        return elementProperty;

    }

    private Property getPropertyForLists(String elementPropertyExpression, Type<?> elementType) {
        Property elementProperty;
        int index = Integer.valueOf(elementPropertyExpression.replaceAll("[\\[\\]]", ""));
        elementProperty = new ClassMapBuilderForLists.ListElementProperty(index, elementType.getNestedType(0));
        return elementProperty;
    }

    private Property getPropertyForArray(String elementPropertyExpression, Type<?> elementType) {
        Property elementProperty;
        int index = Integer.valueOf(elementPropertyExpression);
        elementProperty = new ClassMapBuilderForArrays.ArrayElementProperty(index, elementType.getComponentType());
        return elementProperty;
    }

}
