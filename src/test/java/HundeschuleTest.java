import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HundeschuleTest {
	private EinzelTraining e1;
	private GruppenTraining g1;
	private GruppenTraining g2;
	
	@BeforeEach
	void setUp() throws HundeException {
		Hundeschule schule = new Hundeschule(12, "Bella", "Albert Einstein", "Cambridge Dog school");
		e1 = new EinzelTraining(5, "Hund", "Frank Columbo", 40f);
		g1 = new GruppenTraining(8, "Bello", "Anton Zeilinger", 50f);
		g2 = new GruppenTraining(12, "Cello", "Freddy Krüger", 150f);
		schule.hinzufuegen(e1);
		schule.hinzufuegen(g1);
		schule.hinzufuegen(g2);
	}
	
	@AfterEach
	void tearDown() {
	}
	
	@Test
	void getTrainings() {
	}
	
	@Test
	void setTrainings() {
	}
	
	@Test
	void getTraining() {
	}
	
	@Test
	void hinzufuegen() {
	}
	
	@Test
	void entfernen() {
	}
	
	@Test
	void testEntfernen() {
	}
	
	@Test
	void anzahlPreisGesamt() {
	}
}