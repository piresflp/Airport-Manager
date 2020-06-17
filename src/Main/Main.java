package Main;
import java.util.Scanner;
import Aeroporto.Aeroporto;
import ListaAeroporto.ListaAeroporto;

public class Main {
    public static void main(String[] args){
        int opcao;
        int resposta;
        final int fecharPrograma = 99;

        do{
            limpaTela();
            Scanner ler = new Scanner(System.in);
            ListaAeroporto listaDeAeroporto = new ListaAeroporto();

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
                            System.out.printf("Digite: [codigo] [nome cidade]: ");
                            String cod = ler.next();
                            String cidade = ler.next();
                            Aeroporto novoAeroporto = new Aeroporto(cod, cidade);
                            listaDeAeroporto.addAeroporto(novoAeroporto);
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

                case 2:
                    do{
                        limpaTela();
                        try {
                            Aeroporto novoAeroporto = new Aeroporto("GRU", "sao paulo");
                            listaDeAeroporto.addAeroporto(novoAeroporto);
                            Aeroporto novoAeroporto2 = new Aeroporto("BSB", "Brasilia");
                            listaDeAeroporto.addAeroporto(novoAeroporto2);


                            System.out.printf("Digite: [codigoAeroportoEmbarque] [codAeroportoDesembarque] [codVôo]: ");
                            String codEmbarque = ler.next();
                            String codDesembarque = ler.next();
                            int codVôo = ler.nextInt();
                            listaDeAeroporto.addVoo(codEmbarque, codDesembarque, codVôo);
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

                case 3:
                    do{
                        limpaTela();
                        System.out.println("O valor da variavel é 3");
                        try {
                            System.out.printf("Digite: [codVôo]: ");
                            int codVôo = ler.nextInt();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        do{
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

                case 4:
                    do{
                        limpaTela();
                        try {
                            Aeroporto novoAeroporto = new Aeroporto("GRU", "sao paulo");
                            listaDeAeroporto.addAeroporto(novoAeroporto);
                            Aeroporto novoAeroporto2 = new Aeroporto("BSB", "Brasilia");
                            listaDeAeroporto.addAeroporto(novoAeroporto2);
                            listaDeAeroporto.addVoo("GRU", "BSB", 123);


                            System.out.printf("Digite: [codAeroporto]: ");
                            String codAeroporto = ler.next();
                            System.out.println(listaDeAeroporto.voosAeroporto(codAeroporto));
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

                case 5:
                    do{
                        limpaTela();
                        try {
                            Aeroporto novoAeroporto = new Aeroporto("GRU", "sao paulo");
                            listaDeAeroporto.addAeroporto(novoAeroporto);
                            Aeroporto novoAeroporto2 = new Aeroporto("BSB", "Brasilia");
                            listaDeAeroporto.addAeroporto(novoAeroporto2);
                            listaDeAeroporto.addVoo("GRU", "BSB", 123);
                            listaDeAeroporto.addVoo("GRU", "BSB", 127);
                            listaDeAeroporto.addVoo("BSB", "GRU", 321);


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
