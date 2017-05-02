package edu.aspire.domains;
import java.io.Serializable;
import java.util.Set;

public class Team implements Serializable {
	private int id;
	private String name;
	private Set<Player> players; //collection property

	public Team() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}
