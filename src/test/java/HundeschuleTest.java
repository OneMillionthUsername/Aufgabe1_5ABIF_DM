import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HundeschuleTest {
	Hundeschule wienerSchule, grazerSchule;
	EinzelTraining e1, e2;
	GruppenTraining g1, g2;
	
	ArrayList<HundeTraining> trainings = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws HundeException {
		wienerSchule = new Hundeschule("Wiener Schule");
		grazerSchule = new Hundeschule("Grazer Schule");
		
		e1 = new EinzelTraining(5, "Hund", "Frank Columbo", 40f);
		e2 = new EinzelTraining(16, "Hund", "Frank Columbo", 40f);
		
		g1 = new GruppenTraining(8, "Bello", "Anton Zeillinger", 50f);
		g2 = new GruppenTraining(12, "Cello", "Freddy Krüger", 150f);
		
		trainings.add(e1);
		trainings.add(e2);
		trainings.add(g1);
		trainings.add(g2);
		wienerSchule.hinzufuegen(e1);
		wienerSchule.hinzufuegen(g1);
		wienerSchule.hinzufuegen(g2);
	}
	
//	@Test
//	void getTrainings() {
//		assertEquals(3, wienerSchule.getTrainings().size());
//	}
//
//	@Test
//	void setTrainings() {
//		assertEquals(0, grazerSchule.getTrainings().size());
//		grazerSchule.setTrainings(trainings);
//		assertEquals(4, grazerSchule.getTrainings().size());
//	}
//
//	@Test
//	void getTraining() {
//		assertEquals(g2, wienerSchule.getTraining(2));
//		assertEquals(e1, wienerSchule.getTraining(0));
//	}
	
	@Test
	void hinzufuegen() {
		assertEquals(true, wienerSchule.hinzufuegen(e2));
		assertEquals(4, wienerSchule.getTrainings().size());
	}
	
	@Test
	void hinzufuegen_Null_returnsFalse() {
		assertEquals(false,wienerSchule.hinzufuegen(null));
	}
	
	@Test
	void hinzufuegen_sizeTooBig_returnsFalse() throws HundeException {
		var e3 = new EinzelTraining(16, "Hund", "Frank Columbo", 40f);
		assertEquals(false,wienerSchule.hinzufuegen(e3));
	}
	
	void hinzufuegen_containsTraining_returnsFalse() throws HundeException {
		assertEquals(false,wienerSchule.hinzufuegen(e2));
	}
	
	void hinzufuegen_validInput_returnsTrue() throws HundeException {
		var e3 = new EinzelTraining(10, "Hund", "Frank Columbo", 40f);
		assertEquals(true,wienerSchule.hinzufuegen(e3));
	}
	
	@Test
	void entfernen_null_returnsNegativeNumber() {
		assertEquals(-99, wienerSchule.entfernen((String)null));
	}
	
	@Test
	void entfernen_increaseSize_returnsDecreasedNumber() {
		assertEquals(3, wienerSchule.getTrainings().size());
		assertEquals(1, wienerSchule.entfernen("Frank Columbo"));
	}
}