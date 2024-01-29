package com.cadastro.persistido.utils;

import java.util.Scanner;

public class MenuUtils {

    public static void menu(){

        Scanner scanner = new Scanner(System.in);
        displayMenuBanner();
        while (true) {
            displayMenuOptions();

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    RecordUtils.registerUser(scanner);
                    break;
                case 2:
                    RecordUtils.showUsers();
                    break;
                case 3:
                    System.out.println("┣━ Encerrando o programa. Até mais!");
                    System.exit(0);
                default:
                    System.out.println("┣━ Opção inválida. Tente novamente.");
            }
        }
    }

    private static void displayMenuBanner() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       SISTEMA DE CADASTRO       ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃   Bem-vindo ao sistema de       ┃");
        System.out.println("┃   cadastro. Por favor, forneça  ┃");
        System.out.println("┃   as informações necessárias    ┃");
        System.out.println("┃   para continuar:               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    private static void displayMenuOptions() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ [1] - Cadastrar novo usuário    ┃");
        System.out.println("┃ [2] - Visualizar usuários       ┃");
        System.out.println("┃ [3] - Sair                      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┣━ Escolha uma opção: ");
    }
}

