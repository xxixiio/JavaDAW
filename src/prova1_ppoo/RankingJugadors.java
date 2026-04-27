package prova1_ppoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class RankingJugadors {
    static class Jugador {
        private String nom;
        private int puntuacio;

        public Jugador(String nom, int puntuacio) {
            setNom(nom);
            setPuntuacio(puntuacio);
        }

        public void setNom(String nom) { this.nom = nom; }
        public String getNom() { return this.nom; }

        public void setPuntuacio(int puntuacio) { this.puntuacio = puntuacio; }
        public int getPuntuacio() { return this.puntuacio; }
    }

    public static void main(String[] args) throws IOException {
        String CAMI_INPUT = "src/prova1_ppoo/jugadors.txt";
        String CAMI_OUTPUT = "src/prova1_ppoo/ranking.txt";

        if (!comprovacioFitxer(CAMI_INPUT)) {
            System.out.println("Fixer inexistent");
            return;
        }

        int nombreJugadors = comptarJugadors(CAMI_INPUT);
        Jugador[] llistaJugadors = new Jugador[nombreJugadors];

        llegirDades(CAMI_INPUT, llistaJugadors);
        escriuDades(CAMI_OUTPUT, llistaJugadors);
    }

    public static boolean comprovacioFitxer(String cami) throws IOException {
        File fitxer = new File(cami);
        return fitxer.exists();
    }

    public static int comptarJugadors(String cami) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(cami));
        int comptador = 0;
        input.readLine(); // ignora capçalera

        while (true) {
            String linia = input.readLine();
            if (linia == null) break;
            comptador += 1;
        }

        input.close();
        return comptador;
    }

    public static void llegirDades(String cami, Jugador[] llista) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(cami));
        int comptador = 0;
        input.readLine(); // ignora capçalera

        while (true) {
            String linia = input.readLine();
            if (linia == null) break;

            String[] dades = linia.split(":");
            llista[comptador] = new Jugador(dades[0], Integer.parseInt(dades[1]));
            comptador += 1;
        }

        input.close();
    }

    public static void escriuDades(String cami, Jugador[] llista) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(cami));
        int puntuacioTotal = 0;

        output.write("Nom - Rang");
        output.newLine();

        for (Jugador j : llista) {
            puntuacioTotal += j.getPuntuacio();
            String linia = String.format("%s - %s", j.getNom(), determinaRang(j.getPuntuacio()));
            output.write(linia);
            output.newLine();
        }

        float mitjana = (float) puntuacioTotal / llista.length;
        output.write("Puntuació mitjana: " + mitjana);

        output.close();
    }

    public static String determinaRang(int puntuacio) {
        if (puntuacio < 4000) return "Bronze";
        else if (puntuacio < 6000) return "Silver";
        else return "Gold";
    }
}