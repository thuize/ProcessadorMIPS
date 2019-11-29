package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Informe a instrunção a ser executada: ");
        Scanner dado = new Scanner(System.in);

        String instrucao = dado.nextLine();
        String[] instrucaoQuebrada = ProcessadorMIPS.quebrarInstrucao(instrucao);

        //Obtendo valores dos registradores
        System.out.println("Informe o valor para " + instrucaoQuebrada[2] + ":");
        String reg1 = dado.nextLine();
        System.out.println("Informe o valor para " + instrucaoQuebrada[3] + ":");
        String reg2 = dado.nextLine();
        System.out.println("Informe o valor para o registrador de destino " + instrucaoQuebrada[1] + ":");
        String regDestino = dado.nextLine();

        ProcessadorMIPS processador = new ProcessadorMIPS();
        processador.setOperacao(instrucaoQuebrada[0]);
        processador.setRegistrador1(reg1);
        processador.setRegistrador2(reg2);
        processador.setRegistradorSaida(regDestino);
        processador.PC(instrucao);
    }
}
