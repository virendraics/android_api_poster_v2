package com.android.poster.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Generic class which is used in JsonReflection
 * @author Virendra
 * @since 21/08/24
 */
public class TypeOfList<T> implements ParameterizedType
{
    private Class<?> wrapped;

    /**
     * Pass the requested class
     * @param wrapped
     */
    public TypeOfList(Class<T> wrapped)
    {
        this.wrapped = wrapped;
    }

    /**
     * Returns an array of Type objects representing the actual type arguments to this type.
     * @return Returns an array of Type objects representing the actual type arguments to this type.
     */
    @Override
    public Type[] getActualTypeArguments() {
        return new Type[0];
    }

    /**
     * Returns the Type object representing the class or interface that declared this type.
     * @return the Type object representing the class or interface that declared this type
     */
    @Override
    public Type getRawType() {
        return null;
    }

    /**
     * Return null in case of owner type
     * @return Return null in case of owner type
     */
    @Override
    public Type getOwnerType() {
        return null;
    }
}
