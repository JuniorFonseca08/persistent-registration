package com.cadastro.persistido.utils;

import com.cadastro.persistido.model.UserModel;

import java.io.*;
import java.util.Scanner;

public class RecordUtils {

    private static final String register_users = "user.txt";
    static UserModel user;
    public static void registerUser(Scanner sc) {
        register(sc);
    }

    public static void showUsers() {
        show();
    }

    private static void register(Scanner sc){

        user = new UserModel();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃         Registrar usuário           ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.print("┣━ Digite o nome completo: ");
        user.setFullName(sc.nextLine());
        user.setAge(getValidAge(sc));
        System.out.print("┣━ Digite a profissão: ");
        user.setOccupation(sc.nextLine());
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(register_users, true))) {
            writer.write(user.getFullName() + ";" + user.getAge() + ";" + user.getOccupation());
            writer.newLine();
            System.out.println("┣━ Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("┣━ Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void show(){
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃        Usuários cadastrados:        ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");

        try (BufferedReader reader = new BufferedReader(new FileReader(register_users))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("┣━ Nome: " + dados[0] + ", Idade: " + dados[1] + ", Profissão: " + dados[2]);
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            }
        } catch (IOException e) {
            System.out.println("┣━ Erro ao visualizar usuários: " + e.getMessage());
        }
    }

    private static int getValidAge(Scanner sc) {
        int age;

        while (true) {
            System.out.print("┣━ Digite a idade: ");
            String inputAge = sc.nextLine();

            try {
                age = Integer.parseInt(inputAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("┣━ Por favor, digite um número válido para a idade.");
            }
        } return age;
    }

}
