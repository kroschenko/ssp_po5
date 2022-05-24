package com.spp.labs.lab11;

import java.lang.NullPointerException;
import java.io.*;
import java.util.Objects;

public class StringUtils {
    
    public static String substringBetween(String str, String open, String close) {
        String result = null;
        
        if (str == null && open == null && close == null)
            throw new NullPointerException();
        else if (str == null || open == null || close == null)
            return null;
        else if (!Objects.isNull(str) && open.equals("") && close.equals(""))
            return "";
        
        int openIndex = str.indexOf(open);
        int closeIndex = str.indexOf(close);
        
        if (openIndex < 0 || closeIndex < 0)
            return null;
        else if (closeIndex < openIndex)
            return null;
        else if (openIndex == closeIndex)
            return "";
        
        result = str.substring(openIndex + 1, closeIndex);
        
        return result;
    }
}
