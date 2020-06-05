package com.teste.ibm.letras;

public class SeachString {

    public static void main(String args[]) {
        SeachString seachString = new SeachString();
        seachString.SeachString("dabbcabcd", ("abcd"));
        seachString.SeachString("bab", ("ab"));
        seachString.SeachString("bcaacbc", ("bca"));
    }


    public String SeachString(String valor1, String valor2) {
        if (!valor1.matches("^[a-zA-Z]*$") && !valor2.matches("^[a-zA-Z]*$"))
            return "";

        if (!(valor1.length() <= Math.pow(10, 5)))
            return "";

        if (!valor1.contains(valor2))
            return "";

        String valorAux = "";
        for (int a = 0; a < valor1.length(); a++) {
            if (valor1.substring(0, a).contains(valor2) && valor1.substring(0, a).equals(valor2)) {
                valorAux = valor1.substring(0, a);
                break;
            }
            if (valor1.substring(a).contains(valor2) && valor1.substring(a).equals(valor2)) {
                valorAux = valor1.substring(a);
                break;
            }
        }

        System.out.println(valorAux + "-" + valorAux.length());
        return valorAux;
    }

}
