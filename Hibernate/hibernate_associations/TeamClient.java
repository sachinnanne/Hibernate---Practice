import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.aspire.domains.Player;
import edu.aspire.domains.Team;

public class TeamClient {
	public static void main(String ar[]) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate_one_to_many.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Team t1 = new Team();
		t1.setId(1);
		t1.setName("Cricket");

		Player p1 = new Player();
		p1.setId(1);
		p1.setName("Kohli");
		p1.setAge((byte)25);
		//p1.setTeam(t1); //required if inverse="true"

		Player p2 = new Player();
		p2.setId(2);
		p2.setName("Dhoni");
		p2.setAge((byte)32);
		//p2.setTeam(t1); //required if inverse="true"
		
		Player p3 = new Player(); //duplicate player
		p3.setId(2);
		p3.setName("Dhoni");
		p3.setAge((byte)32);
		//p3.setTeam(t1); //required if inverse="true"
		
		Set<Player> players = new HashSet<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		
		//one-to-many
		t1.setPlayers(players);
		
		session.save(t1);
		session.save(p1);
		session.save(p2);
		
		session.flush();
		tx.commit();
		session.close();
		
		//Adding new Player
		/*Team t = (Team)session.get(Team.class, new Integer(1));
		Player p3 = new Player();
		p3.setId(3);
		p3.setName("Yuvraj");
		p3.setAge((byte)34);
		p3.setTeam(t);	//Many-to-one
		session.save(p3);
		tx.commit();*/
		
		//Retrieve records using parent table primary key with different lazy attribute values 	
		/*Team t= (Team)session.get(Team.class, new Integer(1));
		System.out.println("*******");
		Set<Player> players = t.getPlayers();
		System.out.println("size::::::::"+players.size());
		session.flush();
		tx.commit();*/
	}
}
