package com.matrix.controller;

import java.util.Scanner;

import com.matrix.model.Persona;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
	private static Persona[] persone = new Persona[10]; // [null,null,null,...,null]

	public static void main(String[] args) {
		boolean continua = true;
		while (continua) {
			stampaMenu();
			int scelta = leggiScelta();
			switch (scelta) {
			case 0:
				continua = false;
				break;
			case 1:
				inserimentoPersona();
				break;
			case 2:
				stampaPersone();
				break;
			case 3:
                modificaPersona();
				break;
			case 4:
                eliminaPersona();
				break;
			}
		}
	}

	private static void eliminaPersona() {
        System.out.print("Inserisci codice fiscale ->\t");
        String codiceFiscale = scanner.nextLine();
        boolean cancellato = false;
        for(int i = 0; i < persone.length; i++) {
            if(persone[i].getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                persone[i] = null;
                cancellato = true;
                break;
            }
        }
        if(cancellato) {
            System.out.println("Persona cancellata!");
        } else {
            System.out.println("Persona non trovata!");
        }
    }

    private static void modificaPersona() {
        System.out.print("Inserisci codice fiscale ->\t");
        String codiceFiscale = scanner.nextLine();
        boolean trovato = false;
        for(int i = 0; i < persone.length; i++) {
            if(persone[i].getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {

                System.out.print("Inserisci nuovo nome -> \t");
                String nuovoNome = scanner.nextLine();

                System.out.print("Inserisci nuovo cognome -> \t");
                String nuovoCognome = scanner.nextLine();

                System.out.print("Inserisci nuovo codice fiscale -> \t");
                String nuovoCodiceFiscale= scanner.nextLine();

                persone[i] = new Persona(nuovoNome, nuovoCognome, nuovoCodiceFiscale);
                trovato = true;
            }
        }
        if(!trovato) {
            System.out.println("L'utente non è stato trovato!");
        }
    }

    private static void stampaPersone() {
		System.out.println("=== ELENCO PERSONE ===");
		for (Persona persona : persone) {
			if (persona != null)
				System.out.println(persona);
		}
	}

	private static void inserimentoPersona() {
		System.out.println("=== INSERIMENTO PERSONA ===");

		System.out.println("Inserisci codice fiscale:");
		String codiceFiscale = scanner.nextLine();
		System.out.println("Inserisci nome:");
		String nome = scanner.nextLine();
		System.out.println("Inserisci cognome:");
		String cognome = scanner.nextLine();

		Persona persona = new Persona(nome, cognome, codiceFiscale);

		for (int i = 0; i < persone.length; i++) {
			if (persone[i] == null) {
				persone[i] = persona;
				break;
			}
		}
	}

	private static void stampaMenu() {
		System.out.println("=== MENU ===");
		System.out.println("0. per uscire");
		System.out.println("1. per inserire una persona");
		System.out.println("2. per stampare le persone");
		System.out.println("3. per modificare una persona");
		System.out.println("4. per eliminare una persona");
	}

	private static int leggiScelta() {
		System.out.println("Inserisci scelta:");
		int scelta = Integer.parseInt(scanner.nextLine());
		while (scelta < 0 || scelta > 4) {
			System.out.println("Errore...inserisci scelta:");
			scelta = Integer.parseInt(scanner.nextLine());
		}
		return scelta;
	}
    
}
