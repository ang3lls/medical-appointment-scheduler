package com.angelinatraining.patientregistration.service;

public class ValidaCPF {
    public static boolean ok(String cpf){

        int index;
        int primeiroDigito = getPrimeiroDigito(cpf);
        int segundoDigito = getSegundoDigito(cpf);

        return isEquals(cpf, primeiroDigito, segundoDigito);
    }

    private static boolean isEquals(String cpf, int primeiroDigito, int segundoDigito) {
        return cpf.substring(9, 11).equals(Integer.toString(primeiroDigito).concat(Integer.toString(segundoDigito)));
    }

    private static int getSegundoDigito(String cpf) {
        int index;
        String  verificaSegundoDigito = cpf.substring(0,10);
        int segundoDigito = 0;
        index = -1;
        for (int i = 11; i > 1; i--) {
            segundoDigito += Character.getNumericValue(verificaSegundoDigito.charAt(++index))*i;
        }
        segundoDigito = segundoDigito % 11;
        if(segundoDigito > 9){
            segundoDigito = 0;
        }
        segundoDigito = 11 - segundoDigito;
        return segundoDigito;
    }

    private static int getPrimeiroDigito(String cpf) {
        String  verificaPrimeiroDigito = cpf.substring(0,9);
        int primeiroDigito = 0;
        int index = -1;
        for (int i = 10; i > 1; i--) {
            primeiroDigito += Character.getNumericValue(verificaPrimeiroDigito.charAt(++index))*i;
        }
        primeiroDigito = primeiroDigito % 11;
        if(primeiroDigito > 9){
            primeiroDigito = 0;
        }
        primeiroDigito = 11 - primeiroDigito;
        return primeiroDigito;
    }
}
