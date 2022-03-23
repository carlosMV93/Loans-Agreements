package com.bbva.pzic.loansagreements.util.orika.impl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 24/10/2017.
 *
 * @author Entelgy
 */
public class ListMapper {

    private Map<String, Integer> positions;
    private List<Object> objects;

    public ListMapper(List<Object> objects) {
        this.positions = new HashMap<>();
        this.objects = objects;
    }

    public boolean containsPosition(String position){
        return positions.containsKey(position);
    }

    public void add(String position, Object object){
        objects.add(object);
        int index = objects.indexOf(object);
        positions.put(position, index);
    }

    public Object get(String position){
        int index = positions.get(position);
        return objects.get(index);
    }

    List<Object> getObjects() {
        return objects;
    }

}
