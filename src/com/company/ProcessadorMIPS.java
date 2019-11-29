package com.company;

import java.util.ArrayList;

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

    /*
    * Mapear as operações
    * */
    public String obterFunc(String operacao){
        if(operacao.contains("ADD")){
            return "000000";
        }else if(operacao.contains("ADDI")){
            return "000001";
        }else if(operacao.contains("SUB")){
            return "000010";
        }else{
            return "Função informada é desconhecida";
        }
    }

    /*
    * Método para quebrar a instrução enviada
    * */
    public static String[] quebrarInstrucao(String instrucao){
        String[] instruncaoQuebrada = instrucao.split(" ");
        return instruncaoQuebrada;
    }

    public String converteDecimalEmBinario(Integer numero) {
        return Integer.toBinaryString(numero);
    }

    public String tipo(String valor){
        String saida = converteDecimalEmBinario(Integer.valueOf(valor));
        return saida;
    }

    /*
    * Método que representa o componente PC que faz o autoincremento para
    * a próxima instrução
    * */
    public String PC(String instrucao){
        int PC = 0;
        //Autoincrementa para o próximo endereço de memória
        PC = PC+4;
        //Passa a instrução para o banco de registradores
        return bancoRegistradores(instrucao);
    }

    /*
    * Método que representa o banco de registradores que podem ser utilizados
    * */
    public String bancoRegistradores(String instrucao){
        String[] instrucaoQuebrada = quebrarInstrucao(instrucao);
        String reg1 = instrucaoQuebrada[2];
        String reg2 = instrucaoQuebrada[3];

        ArrayList<BancoRegistradores> registradores = new ArrayList<>();
        BancoRegistradores zero = new BancoRegistradores();
        zero.setRegistrador("$zero");

        BancoRegistradores t0 = new BancoRegistradores();
        t0.setRegistrador("$t0");

        BancoRegistradores t1 = new BancoRegistradores();
        t1.setRegistrador("$t1");

        BancoRegistradores t2 = new BancoRegistradores();
        t2.setRegistrador("$t2");

        BancoRegistradores t3 = new BancoRegistradores();
        t3.setRegistrador("$t3");

        BancoRegistradores t4 = new BancoRegistradores();
        t4.setRegistrador("$t4");

        BancoRegistradores t5 = new BancoRegistradores();
        t5.setRegistrador("$t5");

        BancoRegistradores t6 = new BancoRegistradores();
        t6.setRegistrador("$t6");

        BancoRegistradores t7 = new BancoRegistradores();
        t7.setRegistrador("$t7");

        BancoRegistradores t8 = new BancoRegistradores();
        t8.setRegistrador("$t8");

        BancoRegistradores t9 = new BancoRegistradores();
        t9.setRegistrador("$t9");

        BancoRegistradores s0 = new BancoRegistradores();
        s0.setRegistrador("$s0");

        BancoRegistradores s1 = new BancoRegistradores();
        s1.setRegistrador("$s1");

        BancoRegistradores s2 = new BancoRegistradores();
        s2.setRegistrador("$s2");

        BancoRegistradores s3 = new BancoRegistradores();
        s3.setRegistrador("$s3");

        BancoRegistradores s4 = new BancoRegistradores();
        s4.setRegistrador("$s4");

        BancoRegistradores s5 = new BancoRegistradores();
        s5.setRegistrador("$s5");

        BancoRegistradores s6 = new BancoRegistradores();
        s6.setRegistrador("$s6");

        //Verificar se o registrador passado é um registrador válido
        for(int i=0;i<registradores.size();i++){
            if(registradores.get(i).getRegistrador().contains(reg1) ||
                    registradores.get(i).getRegistrador().contains(reg2)){
                //Proxima Instrução
                return ULA(instrucao);
            }else{
                return "O registrador passado não se encontra no banco de registradores";
            }
        }
        return ULA(instrucao);
    }

    /*
    * Método que representa a ULA, onde é identificado a operação e a instrução é encaminhada para
    * a ULA de controle.
    * */
    public String ULA(String instrucao){
        String[] instrucaoQuebrada = quebrarInstrucao(instrucao);
        String func = obterFunc(instrucao);

        if(instrucaoQuebrada[0].contains("ADD") ||
                instrucaoQuebrada[0].contains("ADD") ||
                instrucaoQuebrada[0].contains("ADD")){
            return ULAControle(func, instrucao);
        }else{
            return "Essa operação não pode ser efetuada";
        }
    }

    /*
    * Método que representa a ULA de controle, onde as operações de fato são efetuadas
    * */
    public String ULAControle(String func, String instrucao){
        String[] instrucaoQuebrada = quebrarInstrucao(instrucao);
        Integer resultado;

        String reg1Binario = String.format("%06d", Integer.valueOf(converteDecimalEmBinario(Integer.valueOf(registrador1))));
        String reg2Binario = String.format("%06d", Integer.valueOf(converteDecimalEmBinario(Integer.valueOf(registrador2))));
        String regDestinoBinario = String.format("%06d", Integer.valueOf(converteDecimalEmBinario(Integer.valueOf(registradorSaida))));;

        System.out.println("Instrução em binário: " + func + "|" + regDestinoBinario +
                "|" + reg1Binario + "|" + reg2Binario);

        if(instrucaoQuebrada[0].contains("ADD")){
            resultado = Integer.valueOf(registrador1) + Integer.valueOf(registrador2);
        }else if(instrucaoQuebrada[0].contains("ADDI")){
            resultado = Integer.valueOf(registrador1) + Integer.valueOf(registrador2);
        }else if(instrucaoQuebrada[0].contains("SUB")){
            resultado = Integer.valueOf(registrador1) - Integer.valueOf(registrador2);
        }else{
            resultado = 000000;
        }

        System.out.println("Resultado da instrução tipo R:" + resultado);

        return resultado.toString();
    }
}
