package de.ait.com.service;

import de.ait.com.module.Conversion;

public interface Converter {
    Conversion convert(String from, String to, double amount);
}
