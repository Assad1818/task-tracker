import model.Tarefa;
import  model.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        int opcao2;
        int opcao3;
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        boolean continuar = true;
        do {
            System.out.println("----------Tarefas----------");
            System.out.println("1- Adicionar tarefa");
            System.out.println("2- Atualizar tarefa");
            System.out.println("3- Remover tarefa");
            System.out.println("4- Listar todas as tarefas");
            System.out.println("5- Sair");
            System.out.println("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do tarefa que deseja adicionar: ");
                    String nomeTarefa = sc.nextLine();
                    tarefas.add(new Tarefa(nomeTarefa));
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    listarTodas(tarefas);
                    System.out.println("Digite o nome da tarefa: ");
                    String atualziarStatus = sc.nextLine();

                    Tarefa tarefa = buscarTarefa(tarefas, atualziarStatus);
                    if (tarefa == null) {
                        System.out.println("Tarefa não encontrada!");
                        break;
                    }

                    System.out.println("1- Marcar como 'em progresso'");
                    System.out.println("2- Marcar como 'concluida'");
                    opcao2 = sc.nextInt();
                    if (opcao2 == 1) {
                        tarefa.setStatus(Status.EM_PROGRESSO);
                        System.out.println("Tarefa atualizada com sucesso!");
                        break;
                    } else if (opcao2 == 2) {
                        tarefa.setStatus(Status.CONCLUIDA);
                        System.out.println("Tarefa atualizada com sucesso!");
                        break;
                    } else {
                        System.out.println("Número inválido. Digite 1 ou 2");
                        break;
                    }
                case 3:
                    listarTodas(tarefas);
                    System.out.println("Digite o nome da tarefa que deseja remover: ");
                    String removerTarefa = sc.nextLine();
                    boolean removida = tarefas.removeIf(
                            t -> t.getNomeTarefa().equalsIgnoreCase(removerTarefa) );
                    if (removida) {
                        System.out.println("Tarefa removida com sucesso!");
                        break;
                    } else {
                        System.out.println("Não foi possível achar a tarefa!");
                    }
                    break;
                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhum tarefa encontrada!");
                    } else {
                        System.out.println("-----Escolha uma opção-----");
                        System.out.println("1- Listar todas as tarefas");
                        System.out.println("2- Listar as tarefas marcadas como 'para fazer'");
                        System.out.println("3- Listar as tarefas marcadas como 'em progesso'");
                        System.out.println("4- Listar as tarefas marcadas como 'concluídas'");
                        System.out.println("5- Listar as tarefas não concluídas");
                        opcao3 = sc.nextInt();
                        switch(opcao3){
                            case 1:
                                for (Tarefa t : tarefas) {
                                    System.out.println(t);
                                }
                                break;
                            case 2:
                                for (Tarefa t : tarefas) {
                                    if (t.getStatus().equals(Status.PARA_FAZER)) {
                                        System.out.println(t);
                                    }
                                }
                                break;
                            case 3:
                                for (Tarefa t : tarefas) {
                                    if (t.getStatus().equals(Status.EM_PROGRESSO)) {
                                        System.out.println(t);
                                    }
                                }
                                break;
                            case 4:
                                for (Tarefa t : tarefas) {
                                    if (t.getStatus().equals(Status.CONCLUIDA)) {
                                        System.out.println(t);
                                    }
                                }
                                break;
                            case 5:
                                for (Tarefa t : tarefas) {
                                    if (t.getStatus().equals(Status.PARA_FAZER) || t.getStatus().equals(Status.EM_PROGRESSO)) {
                                        System.out.println(t);
                                    }
                                }
                                break;
                    }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...!");
                    continuar = false;
                    break;
            }
            System.out.println("\n");
        } while (continuar);
        sc.close();
    }

    private static Tarefa buscarTarefa(List<Tarefa> tarefas, String nomeTarefa) {
        for (Tarefa t : tarefas) {
            if (t.getNomeTarefa().equalsIgnoreCase(nomeTarefa)) {
                return t;
            }
        }
        return null;
    }

    private static void listarTodas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhum tarefa encontrada!");
            return;
        }
        System.out.println("-----TAREFAS-----");
        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
        System.out.println("--------------------");
    }
}
