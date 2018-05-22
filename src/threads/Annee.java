package src.threads;

import java.util.ArrayList;

import src.Player;

public class Annee extends Thread {

	private ArrayList<Tournoi> tournois = new ArrayList<Tournoi>();
	private ArrayList<Player> players;
	private ArrayList<Player> fPlayers;
	
	public Annee(ArrayList<Player> players) {
		super();
		this.players = players; //on cree 6 tournois pour tout le long de l'annee
		this.tournois.add(new Tournoi("tournoi 1",this.players, this.fPlayers)); //fait a l'arrache
		this.tournois.add(new Tournoi("tournoi 2",this.players, this.fPlayers)); //voir si ca peut pas etre plus propre
		this.tournois.add(new Tournoi("tournoi 3",this.players, this.fPlayers));
		this.tournois.add(new Tournoi("tournoi 4",this.players, this.fPlayers));
		this.tournois.add(new Tournoi("tournoi 5",this.players, this.fPlayers));
		this.tournois.add(new Tournoi("tournoi 6",this.players, this.fPlayers));
	}



	@Override
	public void run() {
		//remettre les classements � 1 pour le d�but d'ann�e
		for (Player elt: this.players) {
            elt.setRank(1);
        }
		for (Player elt: this.fPlayers) {
            elt.setRank(1);
        }
		//lancer tout les tournois 1 a 1
		//requete nouveau tournoi
		//attendre fin d'un tournoi pour lancer le prochain
		for(int i = 0; i < 6; i++) {
			this.tournois.get(i).start();
			try {
				this.tournois.get(i).join();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
