package com.company;

public class ProcessadorMIPS {
    String operacao;
    String registrador1;
    String registrador2;
    String registradorSaida;

    public String getOperacao() {return operacao;}
    public void setOperacao(String operacao) {this.operacao = operacao;}

    public String getRegistrador1() {return registrador1;}
    public void setRegistrador1(String registrador1) {this.registrador1 = registrador1;}

    public String getRegistrador2() {return registrador2;}
    public void setRegistrador2(String registrador2) {this.registrador2 = registrador2;}

    public String getRegistradorSaida() {return registradorSaida;}
    public void setRegistradorSaida(String registradorSaida) {this.registradorSaida = registradorSaida;}

    public String obterOpcode(String operacao){
        if(operacao.contains("ADD")){
            return "000000";
        }else if(operacao.contains("ADDI")){
            return "000001";
        }else if(operacao.contains("SUB")){
            return "000010";
        }else{
            return "Operação desconhecida";
        }
    }

    public String converteDecimalEmBinario(Integer numero) {
        return Integer.toBinaryString(numero);
    }

    public String[] tipoRBinario(String operacao, String registrador1, String registrador2, String registradorSaida){
        String[] binario = new String[4];

        binario[0] = converteDecimalEmBinario(9);
        binario[1] = converteDecimalEmBinario(Integer.valueOf(registrador1));
        binario[2] = converteDecimalEmBinario(Integer.valueOf(registrador2));
        binario[3] = converteDecimalEmBinario(Integer.valueOf(registradorSaida));

        return binario;
    }

}
