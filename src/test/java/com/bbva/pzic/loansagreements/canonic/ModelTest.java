package com.bbva.pzic.loansagreements.canonic;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.affirm.Affirm;
import org.junit.Test;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Entelgy
 */
public class ModelTest {

    @Test
    public void wadlRequirementsTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final StringBuilder result = new StringBuilder();

        List<PojoClass> canonics = PojoClassFactory.getPojoClasses(this.getClass().getPackage().getName(), new FilterTestClasses());
        for (PojoClass canonic : canonics) {
            this.implementsSerializableCheck(result, canonic);
            this.fieldSerialVersionUIDCheck(result, canonic);
            this.annotationXmlRootElementCheck(result, canonic);
            this.annotationXmlTypeCheck(result, canonic);
        }

        Affirm.affirmTrue(result.toString(), result.toString().isEmpty());
    }

    private void implementsSerializableCheck(StringBuilder result, PojoClass canonic) {
        boolean discriminator = false;
        for (Class i : canonic.getClazz().getInterfaces()) {
            if (i.getName().equalsIgnoreCase(Serializable.class.getName())) {
                discriminator = true;
                break;
            }
        }

        if (!discriminator) {
            result.append(String.format("\n\t%s not implement Serializable class", canonic.getClazz().getName()));
        }
    }

    private void fieldSerialVersionUIDCheck(StringBuilder result, PojoClass canonic) {
        boolean discriminator = false;
        for (PojoField field : canonic.getPojoFields()) {
            if (field.getName().equalsIgnoreCase("serialVersionUID")) {
                discriminator = true;
                break;
            }
        }

        if (!discriminator) {
            result.append(String.format("\n\t%s not contain serialVersionUID property", canonic.getClazz().getName()));
        }
    }

    private void annotationXmlRootElementCheck(StringBuilder result, PojoClass canonic) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        XmlRootElement xmlRootElement = canonic.getClazz().getAnnotation(XmlRootElement.class);
        if (xmlRootElement != null) {
            this.nameCheck(result, canonic, xmlRootElement);
            this.nameSpaceCheck(result, canonic, xmlRootElement);
        } else {
            result.append(String.format("\n\t%s not contain annotation @XmlRootElement", canonic.getClazz().getName()));
        }
    }

    private void annotationXmlTypeCheck(StringBuilder result, PojoClass canonic) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        XmlType xmlRootElement = canonic.getClazz().getAnnotation(XmlType.class);
        if (xmlRootElement != null) {
            this.nameCheck(result, canonic, xmlRootElement);
            this.nameSpaceCheck(result, canonic, xmlRootElement);
        } else {
            result.append(String.format("\n\t%s not contain annotation @XmlType", canonic.getClazz().getName()));
        }
    }

    private <T> void nameCheck(StringBuilder result, PojoClass canonic, T annotation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expect = canonic.getClazz().getSimpleName();
        String actual = (String) annotation.getClass().getMethod("name").invoke(annotation);
        if (!expect.equalsIgnoreCase(actual)) {
            System.out.println(annotation.getClass().getName());
            result.append(
                    String.format("\n\t%s invalid name in the @%s annotation",
                            canonic.getClazz().getName(),
                            ((Annotation) annotation).annotationType().getSimpleName()));
        }
    }

    private <T> void nameSpaceCheck(StringBuilder result, PojoClass canonic, T annotation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String actual = (String) annotation.getClass().getMethod("namespace").invoke(annotation);
        String expect = "urn:".concat(canonic.getClazz().getPackage().getName().replace(".", ":"));
        if (!expect.equalsIgnoreCase(actual)) {
            result.append(
                    String.format("\n\t%s invalid namespace in the @%s annotation",
                            canonic.getClazz().getName(),
                            ((Annotation) annotation).annotationType().getSimpleName()));
        }
    }

    private static class FilterTestClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/");
        }
    }
}
