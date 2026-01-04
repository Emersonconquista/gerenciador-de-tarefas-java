package br.com.emerson.main;

import java.util.ArrayList;
import java.util.Scanner;
import br.com.emerson.model.Tarefa;

public class SistemaPrincipal {
    public static void main(String[] args) {
        ArrayList<Tarefa> lista = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- GERENCIADOR DO EMERSON ---");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Marcar como Concluída");
            System.out.println("4 - Remover Tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine(); 

            if (opcao == 1) {
                System.out.print("O que precisa fazer? ");
                String desc = leitor.nextLine();
                lista.add(new Tarefa(desc));
                System.out.println("Salvo com sucesso!");

            } else if (opcao == 2) {
                System.out.println("\nSUA LISTA:");
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(i + " - " + lista.get(i));
                }

            } else if (opcao == 3) {
                System.out.print("Digite o número da tarefa concluída: ");
                int index = leitor.nextInt();
                if (index >= 0 && index < lista.size()) {
                    lista.get(index).setConcluida(true);
                    System.out.println("Tarefa atualizada!");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o número da tarefa para remover: ");
                int index = leitor.nextInt();
                if (index >= 0 && index < lista.size()) {
                    lista.remove(index);
                    System.out.println("Tarefa removida!");
                }
            }
        }
        System.out.println("Programa encerrado.");
        leitor.close();
    }
}