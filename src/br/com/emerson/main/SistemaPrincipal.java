package br.com.emerson.main;

import java.util.ArrayList;
import java.util.Scanner;
import br.com.emerson.model.Tarefa; // Verifique se esta linha existe!

public class SistemaPrincipal {
    public static void main(String[] args) {
        ArrayList<Tarefa> lista = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- GERENCIADOR DO EMERSON ---");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpa o teclado

            if (opcao == 1) {
                System.out.print("O que precisa fazer? ");
                String desc = leitor.nextLine();
                lista.add(new Tarefa(desc));
                System.out.println("Salvo com sucesso!");
            } else if (opcao == 2) {
                System.out.println("\nSUA LISTA:");
                for (Tarefa t : lista) {
                    System.out.println(t);
                }
            }
        }
        System.out.println("Programa encerrado.");
        leitor.close();
    }
}