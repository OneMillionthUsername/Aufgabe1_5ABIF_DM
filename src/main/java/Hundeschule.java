import java.util.ArrayList;

public class Hundeschule {
	private String name;
	private ArrayList<HundeTraining> trainings;
	
	public Hundeschule(String name) throws HundeTrainingException {
		setName(name);
		trainings = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws HundeTrainingException {
		if(name == null || name.isBlank())
			throw new HundeTrainingException("Name darf nicht leer sein.");
		this.name = name;
	}
	
	public ArrayList<HundeTraining> getTrainings() {
		return trainings;
	}
	
	public void setTrainings(ArrayList<HundeTraining> trainings) throws HundeTrainingException {
		if (trainings == null)
			throw new HundeTrainingException("Trainings dürfen nicht null sein.");
		this.trainings = trainings;
	}
	
	public HundeTraining getTraining(int index) throws HundeTrainingException {
		if (index < 0 || index >= trainings.size()) {
			throw new HundeTrainingException("Ungültiger Index.");
		}
		return trainings.get(index);
//		if (index < 0)
//			return null;
//
//		Iterator<HundeTraining> it = trainings.iterator();
//		int i = 0;
//
//		while(it.hasNext()) {
//			var t = it.next();
//			if(i == index) {
//				return t;
//			}
//			i++;
//		}
//		return null;
	}
	
	public boolean hinzufuegen(HundeTraining training) {
		if(training == null)
			return false;
		if(trainings.size() >= 15)
			return false;
		if(trainings.contains(training))
			return false;
		trainings.add(training);
		return true;
	}
	
	public boolean entfernen(HundeTraining training) throws HundeTrainingException {
		if(training == null)
			// laut Angabe:
			// null darf nicht übergeben werden. Das Objekt muss vorhanden sein.
			throw new HundeTrainingException("Training darf nicht null sein.");
		if(trainings.contains(training)) {
			trainings.remove(training);
			return true;
		}
		return false;
	}
	
	public int entfernen(String trainer) throws HundeTrainingException {
		if(trainer == null || trainer.isBlank())
			return -99;
		
		int vorher = trainings.size();
		trainings.removeIf(t -> t.getTrainer().equals(trainer));
		if(trainings.size() == vorher)
			throw new HundeTrainingException("Kein passender Trainer gefunden.");
		return vorher - trainings.size();
		
//		int i = 0;
//		Iterator<HundeTraining> it = trainings.iterator();
//
//		while(it.hasNext()) {
//			var t = it.next();
//			if (t.getTrainer().equals(trainer)) {
//				it.remove();
//				i++;
//			}
//		}
//		return i;
	}
	
	public int anzahlPreisGesamt(float maxPreisGesamt) throws HundeTrainingException {
		if(maxPreisGesamt <= 0)
			throw new HundeTrainingException("Gesamtpreis darf nicht negativ sein.");
		
		int gruppenTrainings = 0;
		for (HundeTraining t : trainings) {
			if(t instanceof GruppenTraining && ((GruppenTraining) t).getKursPreis() < maxPreisGesamt){
				gruppenTrainings++;
			}
		}
		return gruppenTrainings;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Hundeschule{" +
				       "name='" + name + '\'' +
				       ", trainings=" + trainings +
				       '}';
	}
}
