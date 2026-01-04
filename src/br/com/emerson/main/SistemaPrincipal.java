package br.com.emerson.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.emerson.model.Tarefa;

public class SistemaPrincipal {
    private static final String ARQUIVO = "tarefas.txt";

    public static void main(String[] args) {
        ArrayList<Tarefa> lista = carregarTarefas();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- GERENCIADOR COM MEMÓRIA ---");
            System.out.println("1 - Adicionar | 2 - Listar | 3 - Concluir | 4 - Remover | 5 - Sair");
            System.out.print("Escolha: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            if (opcao == 1) {
                System.out.print("Tarefa: ");
                lista.add(new Tarefa(leitor.nextLine()));
                salvarTarefas(lista);
            } else if (opcao == 2) {
                for (int i = 0; i < lista.size(); i++) System.out.println(i + " - " + lista.get(i));
            } else if (opcao == 4) {
                System.out.print("Índice para remover: ");
                int idx = leitor.nextInt();
                if (idx >= 0 && idx < lista.size()) {
                    lista.remove(idx);
                    salvarTarefas(lista);
                }
            }
        }
        leitor.close();
    }

    private static void salvarTarefas(ArrayList<Tarefa> lista) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Tarefa t : lista) {
                writer.println(t.paraArquivo());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar!");
        }
    }

    private static ArrayList<Tarefa> carregarTarefas() {
        ArrayList<Tarefa> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return lista;

        try (Scanner s = new Scanner(file)) {
            while (s.hasNextLine()) {
                String[] partes = s.nextLine().split(";");
                Tarefa t = new Tarefa(partes[0]);
                t.setConcluida(Boolean.parseBoolean(partes[1]));
                lista.add(t);
            }
        } catch (FileNotFoundException e) {
            return lista;
        }
        return lista;
    }
}