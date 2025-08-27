package exercicio7;

import java.util.Scanner;

public class media {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura das entradas
        System.out.print("Digite a nota da P1: ");
        double P1 = sc.nextDouble();

        System.out.print("Digite a nota da E1: ");
        double E1 = sc.nextDouble();

        System.out.print("Digite a nota da E2: ");
        double E2 = sc.nextDouble();

        System.out.print("Digite a nota das Atividades Extras (X): ");
        double X = sc.nextDouble();

        System.out.print("Digite a nota da Prova Substitutiva (SUB): ");
        double SUB = sc.nextDouble();

        System.out.print("Digite a nota da API: ");
        double API = sc.nextDouble();

        // Cálculo da Base (A)
        double A = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);

        // Cálculo da Média
        double media;
        if (A <= 5.9) {
            media = 0.5 * A; // sem considerar a API
        } else {
            media = (0.5 * A) + (0.5 * API);
        }

        // Saída
        System.out.println("Base (A): " + String.format("%.2f", A));
        System.out.println("Média Final: " + String.format("%.2f", media));

        sc.close();
    }
}
