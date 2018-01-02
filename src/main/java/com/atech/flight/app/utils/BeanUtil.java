package com.atech.flight.app.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility to deal with Beans.
 *
 * @author  José Júnior <joselazarosiqueira@gmail.com>
 */
public abstract class BeanUtil {

    /**
     * Copies properties from one object to another
     *
     * @param source
     * @destination
     */
    public static void copyNonNullProperties(Object source, Object destination) {
        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
    }

    /**
     * Returns an array of null properties of an object
     *
     * @param source
     * @return The names of each property.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set emptyNames = new HashSet();
        for (PropertyDescriptor pd : pds) {
            // check if value of this property is null then add it to the
            // collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

}
