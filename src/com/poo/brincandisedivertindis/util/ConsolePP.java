package com.poo.brincandisedivertindis.util;

import java.util.Scanner;

public class ConsolePP {
    private Scanner scanner;

    public ConsolePP() {
        this.scanner = new Scanner(System.in);
    }

    public Integer leInteiro() {
        do {
            try {
                Integer valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (Exception ex) {
                escreve("Valor inteiro inválido");
                scanner.nextLine();
            }
        } while (true);
    }

    public Double leDouble() {
        do {
            try {
                Double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } catch (Exception ex) {
                escreve("Valor double inválido");
                scanner.nextLine();
            }
        } while (true);
    }

    public String leLinha() {
        return scanner.nextLine();
    }

    public void escreve(String textoASerEscrito) {
        System.out.println(textoASerEscrito);
    }

    public void escreve(Integer numeroASerEscrito) {
        System.out.println(numeroASerEscrito);
    }

    public void escreve(Double numeroASerEscrito) {
        System.out.println(numeroASerEscrito);
    }
}
