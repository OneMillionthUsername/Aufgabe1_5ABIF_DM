import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HundeschuleTest {
	Hundeschule wienerSchule, grazerSchule;
	EinzelTraining e1, e2;
	GruppenTraining g1, g2;
	
	ArrayList<HundeTraining> trainings = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws HundeTrainingException {
		wienerSchule = new Hundeschule("Wiener Schule");
		grazerSchule = new Hundeschule("Grazer Schule");
		
		e1 = new EinzelTraining(5, "Hund", "Frank Columbo", 40f);
		e2 = new EinzelTraining(16, "Hund", "Frank Columbo", 40f);
		
		g1 = new GruppenTraining(8, "Bello", "Anton Zeillinger", 40f);
		g2 = new GruppenTraining(12, "Cello", "Freddy Krüger", 150f);
		
		trainings.add(e1);
		trainings.add(e2);
		trainings.add(g1);
		trainings.add(g2);
		wienerSchule.hinzufuegen(e1);
		wienerSchule.hinzufuegen(g1);
		wienerSchule.hinzufuegen(g2);
	}
	
	@Test
	void setTrainings_nullArg_throwsException() throws HundeTrainingException {
		var ex = assertThrows(HundeTrainingException.class, () -> wienerSchule.setTrainings(null));
		assertEquals("Trainings dürfen nicht null sein.", ex.getMessage());
	}
	
	@Test
	void getTraining_IndexTooSmall_throwsException() throws HundeTrainingException {
		var ex = assertThrows(HundeTrainingException.class, () -> wienerSchule.getTraining(-1));
		assertEquals("Ungültiger Index.", ex.getMessage());
	}
	
	@Test
	void getTraining_IndexTooBig_throwsException() throws HundeTrainingException {
		var ex = assertThrows(HundeTrainingException.class, () -> wienerSchule.getTraining(99));
		assertEquals("Ungültiger Index.", ex.getMessage());
	}
	
	@Test
	void getTraining_IndexOk_returnTraining() throws HundeTrainingException {
		assertEquals(g2, wienerSchule.getTraining(2));
	}
	
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
	void hinzufuegen_tooManyTrainings_returnsFalse() throws HundeTrainingException {
		var e3 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e4 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e5 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e6 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e7 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e8 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e9 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e10 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e11 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e12 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e13 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e14 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e15 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e16 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e17 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		var e18 = new EinzelTraining(17, "Hund", "Frank Columbo", 40f);
		
		wienerSchule.hinzufuegen(e3); //4
		wienerSchule.hinzufuegen(e4); //5
		wienerSchule.hinzufuegen(e5); //6
		wienerSchule.hinzufuegen(e6); //7
		wienerSchule.hinzufuegen(e7); //8
		wienerSchule.hinzufuegen(e8); //9
		wienerSchule.hinzufuegen(e9); //10
		wienerSchule.hinzufuegen(e10); //11
		wienerSchule.hinzufuegen(e11); //12
		wienerSchule.hinzufuegen(e12); //13
		wienerSchule.hinzufuegen(e13); //14
		wienerSchule.hinzufuegen(e14); //15
		
		assertEquals(false,wienerSchule.hinzufuegen(e15));
	}
	
	@Test
	void hinzufuegen_containsTraining_returnsFalse() throws HundeTrainingException {
		assertEquals(true, wienerSchule.getTrainings().contains(e1));
		assertEquals(false,wienerSchule.hinzufuegen(e1));
	}
	
	@Test
	void hinzufuegen_validInput_returnsTrue() throws HundeTrainingException {
		var e3 = new EinzelTraining(10, "Hund", "Frank Columbo", 40f);
		assertEquals(true,wienerSchule.hinzufuegen(e3));
	}
	
	@Test
	void entfernen_null_returnsNegativeNumber() throws HundeTrainingException {
		assertEquals(-99, wienerSchule.entfernen((String)null));
	}
	
	@Test
	void entfernen_removeTrainer_returnsDecreasedNumber() throws HundeTrainingException {
		assertEquals(3, wienerSchule.getTrainings().size());
		assertEquals(1, wienerSchule.entfernen("Frank Columbo"));
	}
	
	@Test
	void entfernen_noTrainerFound_ThrowsException() {
		var ex = assertThrows(HundeTrainingException.class, () -> wienerSchule.entfernen("Michael Jordan"));
		assertEquals(ex.getMessage(), "Kein passender Trainer gefunden.");
	}
	
	@Test
	void anzahlPreisGesamt_PreisOk_returnsGruppenTrainings() throws HundeTrainingException {
		assertEquals(1, wienerSchule.anzahlPreisGesamt(45f));
	}
	
	@Test
	void anzahlPreisGesamt_negativePreis_ThrowsException() throws HundeTrainingException {
			var ex = assertThrows(HundeTrainingException.class, () -> wienerSchule.anzahlPreisGesamt(-5));
			assertEquals(ex.getMessage(), "Gesamtpreis darf nicht negativ sein.");
	}
}