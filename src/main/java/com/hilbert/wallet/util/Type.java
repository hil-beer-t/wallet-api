package com.hilbert.wallet.util;

public enum Type {
    EN("ENTRADA"),
    SD("SAÍDA");

    private final String value;

    Type(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static Type getEnum(String value){
        for (Type t : values()) {
            if (value.equals(t.getValue())){
                return t;
            }
        }
        return null;
    }

}
