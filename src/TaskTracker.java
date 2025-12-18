import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTracker {

    public enum Status{
        PARA_FAZER,
        EM_PROGRESSO,
        CONCLUIDA
    }

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

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do tarefa que deseja adicionar: ");
                    break;
                case 2:
                    System.out.println("-----Escolha uma opção-----");
                    System.out.println("1- Marcar como 'em progesso'");
                    System.out.println("2- Marcar como 'concluída'");
                    opcao2 = sc.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Digite o nome do tarefa: ");
                        String nomeBusca = sc.next();

                    } else if (opcao2 == 2) {
                        System.out.println("Digite o nome do tarefa: ");
                    } else {
                        System.out.println("Valor inadequado. Digite 1 ou 2");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome da tarefa que deseja atualizar: ");
                    break;
                case 4:
                    System.out.println("-----Escolha uma opção-----");
                    System.out.println("1- Listar todas as tarefas");
                    System.out.println("2- Listar as tarefas marcadas como 'para fazer'");
                    System.out.println("3- Listar as tarefas marcadas como 'em progesso'");
                    System.out.println("4- Listar as tarefas marcadas como 'concluídas'");
                    System.out.println("5- Listar as tarefas não concluídas");
                    opcao3 = sc.nextInt();

                    switch(opcao3){
                        case 1:
                            //listar todas as tarefas
                            break;
                        case 2:
                            //listar para fazer
                            break;
                        case 3:
                            //listar em progesso
                            break;
                        case 4:
                            //listar concluidas
                            break;
                        case 5:
                            //listar n concluidas (para fazer e em progesso)
                            break;

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
}
