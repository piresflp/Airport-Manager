package Main;
import java.util.Scanner;
import Aeroporto.Aeroporto;
import ListaAeroporto.ListaAeroporto;

public class Main {
    public static void main(String[] args){
        int opcao;
        int resposta;
        final int fecharPrograma = 99;
        ListaAeroporto listaDeAeroporto = new ListaAeroporto();

        do{
            limpaTela();
            Scanner ler = new Scanner(System.in);

            System.out.println("Estrutura de gerenciamento de voos e aeroportos da ANAC\n");
            System.out.println("1: Cadastramento de um novo aeroporto");
            System.out.println("2: Cadastramento de um vôo");
            System.out.println("3: Remoção de um vôo");
            System.out.println("4: Lista de voos de um aeroporto");
            System.out.println("5: Lista de voos de todos os aeroportos");
            System.out.println("99: Fechar programa");
            System.out.printf("Digite a opção desejada: ");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    do {
                        limpaTela();
                        try {
                            System.out.println("Digite: [codigo] [nome cidade]: ");
                            String cod = ler.next();
                            String cidade = ler.nextLine();
                            Aeroporto novoAeroporto = new Aeroporto(cod, cidade);
                            listaDeAeroporto.addAeroporto(novoAeroporto);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do {
                            Scanner repeticao = new Scanner(System.in);
                            System.out.println("Deseja repetir a operação?");
                            System.out.println("Não - 0");
                            System.out.println("Sim - 1");
                            resposta = repeticao.nextInt();
                        }
                        while (resposta != 0 && resposta != 1);
                    }
                    while(resposta != 0);
                    resposta = 99;
                    break;

                case 2:
                    do{
                        limpaTela();
                        try {
                            System.out.printf("Digite: [codigoAeroportoEmbarque] [codAeroportoDesembarque] [codVôo]: ");
                            String codEmbarque = ler.next();
                            String codDesembarque = ler.next();
                            String codVoo = ler.next();
                            listaDeAeroporto.addVoo(codEmbarque, codDesembarque, codVoo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do {
                            Scanner repeticao = new Scanner(System.in);
                            System.out.println("Deseja repetir a operação?");
                            System.out.println("Não - 0");
                            System.out.println("Sim - 1");
                            resposta = repeticao.nextInt();
                        }
                        while (resposta != 0 && resposta != 1);
                    }
                    while(resposta != 0);
                    resposta = 99;
                    break;

                case 3:
                    do{
                        limpaTela();
                        try {
                            System.out.printf("Digite: [codVôo]: ");
                            String codVoo = ler.next();
                            listaDeAeroporto.removerVoo(codVoo);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do{
                            Scanner repeticao = new Scanner(System.in);
                            System.out.println("Deseja repetir a operação?");
                            System.out.println("Não - 0");
                            System.out.println("Sim - 1");
                            resposta = repeticao.nextInt();
                        }
                        while (resposta != 0 && resposta != 1);
                    }
                    while(resposta != 0);
                    resposta = 99;
                    break;

                case 4:
                    do{
                        limpaTela();
                        try {
                            System.out.printf("Digite: [codAeroporto]: ");
                            String codAeroporto = ler.next();
                            System.out.println(listaDeAeroporto.voosAeroporto(codAeroporto));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do {
                            Scanner repeticao = new Scanner(System.in);
                            System.out.println("Deseja repetir a operação?");
                            System.out.println("Não - 0");
                            System.out.println("Sim - 1");
                            resposta = repeticao.nextInt();
                        }
                        while (resposta != 0 && resposta != 1);
                    }
                    while(resposta != 0);
                    resposta = 99;
                    break;

                case 5:
                    do{
                        limpaTela();
                        try {
                            System.out.println(listaDeAeroporto.todosVoosAeroportos());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do {
                            System.out.println("Deseja repetir a operação?");
                            System.out.println("Não - 0");
                            System.out.println("Sim - 1");
                            resposta = ler.nextInt();
                        }
                        while (resposta != 0 && resposta != 1);
                    }
                    while(resposta != 0);
                    resposta = 99;
                    break;


                case 99: break;

                    default:
                        System.out.println("O valor da variavel não é nenhum dos anteriores");
            }
        }
        while(opcao != 99);
    }
    static public void limpaTela(){
        for(int count=0 ; count<200 ; count++)
            System.out.println("");
    }
}
