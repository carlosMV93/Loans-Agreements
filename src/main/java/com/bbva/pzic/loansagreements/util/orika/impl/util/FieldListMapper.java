package com.bbva.pzic.loansagreements.util.orika.impl.util;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 24/10/2017.
 *
 * @author Entelgy
 */
public class FieldListMapper {

    private Map<String, ListMapper> fieldMapper;

    public FieldListMapper() {
        this.fieldMapper = new HashMap<>();
    }

    public void setObjects(String field, List<Object> objects) {
        ListMapper listMapper = new ListMapper(objects);
        fieldMapper.put(field, listMapper);
    }

    /**
     *
     * @param field Identificador del campo de listado
     * @param position Posicion de mapeo
     * @return Si existe objeto en la posicion del campo de listado
     */
    public boolean containsField(String field, String position) {
        if(fieldMapper.containsKey(field)){
            ListMapper listMapper = fieldMapper.get(field);
            return listMapper.containsPosition(position);
        }
        return Boolean.FALSE;
    }

    public void add(String field, String position, Object object) {
        ListMapper listMapper = fieldMapper.get(field);
        listMapper.add(position, object);
    }

    public Object get(String field, String position) {
        ListMapper listMapper = fieldMapper.get(field);
        return listMapper.get(position);
    }

    List<?> getObjects(String field) {
        ListMapper listMapper = fieldMapper.get(field);
        return listMapper.getObjects();
    }
}
