package com.apps.waziup.helper;

import com.google.common.base.Strings;

import java.util.Collection;
import java.util.UUID;

public class Validator {

    public static boolean isValidUUID(String check) {
        try {
            UUID.fromString(check);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    public static void requireValidUuid(String uuid, String message) throws IllegalArgumentException {
        requireNotNull(uuid, "Object can't be null");
        if (!isValidUUID(uuid)) throw new IllegalArgumentException(message);
    }

    public static void requireValidUuid(String uuid) throws IllegalArgumentException {
        requireValidUuid(uuid, uuid + ": not a valid UUID");
    }

    public static void requireNotNull(Object obj, String message) throws NullPointerException {
        if (obj == null) throw new NullPointerException(message);
    }

    public static void requireNotNullNotEmpty(String obj, String message) throws IllegalArgumentException {
        if (Strings.isNullOrEmpty(obj)) throw new IllegalArgumentException(message);
    }

    public static void requireNotNullNotEmpty(Collection obj, String message) throws IllegalArgumentException {
        if (obj == null || obj.isEmpty()) throw new IllegalArgumentException(message);
    }

    public static void requireNotNullNotEmpty(Object[] array, String message) throws IllegalArgumentException {
        if (array == null || array.length <= 0) throw new IllegalArgumentException(message);
    }

    public static void requireAscii(String text, String message) throws IllegalArgumentException {
        requireNotNull(text, "String can't be null or empty");
        if (!text.matches("\\A\\p{ASCII}*\\z")) throw new IllegalArgumentException(message);
    }

    public static void requireAboveZero(Number num, String message) throws IllegalArgumentException {
        if (num == null || num.doubleValue() <= 0) throw new IllegalArgumentException(message);
    }
}
