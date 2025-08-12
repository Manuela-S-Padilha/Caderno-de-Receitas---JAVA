package aplicativodereceitas;

import java.util.Scanner;

public class AplicativoDeReceitas {

    public static void LimpaTela() {
        for (int linha = 1; linha < 70; linha++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opcao = 0;
        int quantidade = 0;
        int indice = -1;
        String titulo, ingredientes, modoDePreparo;
        final int MAX = 10;

        // Vetores para armazenar os dados das receitas
        String[] titulos = new String[MAX];
        String[] ingredientesList = new String[MAX];
        String[] modosDePreparo = new String[MAX];

        do {
            do { // MENU
                System.out.println("0 - Listar todas as receitas");
                System.out.println("1 - Adicionar nova receita");
                System.out.println("2 - Alterar receita");
                System.out.println("3 - Excluir receita");
                System.out.println("4 - Buscar receita");
                System.out.println("5 - Sair");
                opcao = tec.nextInt();
                tec.nextLine(); // Consumir nova linha

                if (opcao < 0 || opcao > 5) {
                    System.out.println("OPCAO INVALIDA");
                }
            } while (opcao < 0 || opcao > 5);

            LimpaTela();

            // LISTAR TODAS AS RECEITAS
            if (opcao == 0) {
                System.out.println("LISTAGEM DAS RECEITAS");
                if (quantidade == 0) {
                    System.out.println("Nenhuma receita no aplicativo.");
                } else {
                    for (int i = 0; i < quantidade; i++) {
                        System.out.println(i + " - Titulo: " + titulos[i]);
                        System.out.println("   Ingredientes: " + ingredientesList[i]);
                        System.out.println("   Modo de Preparo: " + modosDePreparo[i]);
                        System.out.println();
                    }
                }
            }

            // ADICIONAR NOVA RECEITA
            if (opcao == 1) {
                if (quantidade < MAX) {
                    System.out.println("DIGITE O TITULO DA RECEITA:");
                    titulo = tec.nextLine();

                    System.out.println("DIGITE OS INGREDIENTES DA RECEITA:");
                    ingredientes = tec.nextLine();

                    System.out.println("DIGITE O MODO DE PREPARO DA RECEITA:");
                    modoDePreparo = tec.nextLine();

                    titulos[quantidade] = titulo;
                    ingredientesList[quantidade] = ingredientes;
                    modosDePreparo[quantidade] = modoDePreparo;
                    quantidade++;

                    System.out.println("Receita adicionada com sucesso!");
                } else {
                    System.out.println("APLICATIVO CHEIO");
                }
            }

            // ALTERAR RECEITA
            if (opcao == 2) {
                System.out.println("QUAL O ÍNDICE DA RECEITA QUE VAI ALTERAR?");
                indice = tec.nextInt();
                tec.nextLine(); // Consumir nova linha
                if (indice < 0 || indice >= quantidade) {
                    System.out.println("INDICE INVALIDO");
                } else {
                    System.out.println("DIGITE O NOVO TITULO DA RECEITA:");
                    titulo = tec.nextLine();

                    System.out.println("DIGITE OS NOVOS INGREDIENTES DA RECEITA:");
                    ingredientes = tec.nextLine();

                    System.out.println("DIGITE O NOVO MODO DE PREPARO DA RECEITA:");
                    modoDePreparo = tec.nextLine();

                    titulos[indice] = titulo;
                    ingredientesList[indice] = ingredientes;
                    modosDePreparo[indice] = modoDePreparo;

                    System.out.println("Receita alterada com sucesso!");
                }
            }

            // EXCLUIR RECEITA
            if (opcao == 3) {
                System.out.println("QUAL O INDICE DA RECEITA A SER EXCLUIDA?");
                indice = tec.nextInt();
                tec.nextLine(); // Consumir a nova linha

                if (indice < 0 || indice >= quantidade) {
                    System.out.println("INDICE INVALIDO");
                } else {
                    // Move as receitas para preencher o espaço da excluída
                    for (int i = indice; i < quantidade - 1; i++) {
                        titulos[i] = titulos[i + 1];
                        ingredientesList[i] = ingredientesList[i + 1];
                        modosDePreparo[i] = modosDePreparo[i + 1];
                    }
                    // Limpa a última posição dos vetores
                    titulos[quantidade - 1] = null;
                    ingredientesList[quantidade - 1] = null;
                    modosDePreparo[quantidade - 1] = null;
                    // Reduz a quantidade
                    quantidade--;
                    System.out.println("Receita excluida com sucesso!");
                }
            }

            // BUSCAR RECEITA
            if (opcao == 4) {
                System.out.println("DIGITE O TITULO DA RECEITA PARA BUSCAR:");
                titulo = tec.nextLine();
                int achei = -1;
                for (int i = 0; i < quantidade; i++) {
                    if (titulos[i].equalsIgnoreCase(titulo)) {
                        achei = i;
                        break;
                    }
                }
                if (achei == -1) {
                    System.out.println("RECEITA NAO ENCONTRADA");
                } else {
                    System.out.println("RECEITA ENCONTRADA:");
                    System.out.println("Titulo: " + titulos[achei]);
                    System.out.println("Ingredientes: " + ingredientesList[achei]);
                    System.out.println("Modo de Preparo: " + modosDePreparo[achei]);
                }
            }

        } while (opcao != 5);

        tec.close();
        System.out.println("Saindo...");
    }
}
