package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Informe a instrunção a ser executada: ");
        Scanner dado = new Scanner(System.in);

        String instrucao = dado.nextLine();
        String[] instrucaoQuebrada = quebrarInstrucao(instrucao);

        //Obtendo valores dos registradores
        System.out.println("Informe o valor para " + instrucaoQuebrada[1] + ":");
        String reg1 = dado.nextLine();
        System.out.println("Informe o valor para " + instrucaoQuebrada[2] + ":");
        String reg2 = dado.nextLine();

        ProcessadorMIPS processador = new ProcessadorMIPS();
        processador.setOperacao(instrucaoQuebrada[0]);
        processador.setRegistrador1(reg1);
        processador.setRegistrador2(reg2);
        processador.setRegistradorSaida(reg1+reg2);

        System.out.println(processador.getRegistradorSaida());
        //System.out.println(processador.converteDecimalEmBinario(Integer.valueOf(reg1)));
        String[] tipoR = processador.tipoRBinario(processador.getOperacao(), processador.getRegistrador1(),
                processador.getRegistrador2(), processador.getRegistradorSaida());
        System.out.println("["+tipoR[0]+"|"+tipoR[1]+"|"+tipoR[2]+"|"+tipoR[3]+"]");
    }

    public static String[] quebrarInstrucao(String instrucao){
        String[] instruncaoQuebrada = instrucao.split(" ");
        return instruncaoQuebrada;
    }

    /*
    * Fluxo de dados:
    * PC: endereço da próxima instrução a ser buscadana memória, atualizar pc para a próxima instrução(+4)
    * Leitura dos registradores(Banca de Registradores)
    * ULA de Controle para identificar o tipo de operação e enviar essa operação para a ULA executar de fato
    * Usar ULA para calcular: resultado aritmetico e salvar resultado no registrador de destino
    * Após isso o resultado é enviado para o banco de registradores com o registrador de destino
    * */
}
