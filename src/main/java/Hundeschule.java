import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Hundeschule extends HundeTraining {
	private String name;
	private ArrayList<HundeTraining> trainings = null;
	
	public Hundeschule(int einheiten, String hund, String trainer, String name, ArrayList<HundeTraining> trainings) throws HundeException {
		super(einheiten, hund, trainer);
		setName(name);
		setTrainings(trainings);
	}
	
	public Hundeschule(int einheiten, String hund, String trainer, String name) throws HundeException {
		super(einheiten, hund, trainer);
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<HundeTraining> getTrainings() {
		return trainings;
	}
	
	public void setTrainings(ArrayList<HundeTraining> trainings) {
		this.trainings = trainings;
	}
	
	@Override
	public float preisGesamt() {
		return 0;
	}
	
	public HundeTraining getTraining(int index) {
		if (index < 0 || index >= trainings.size()) {
			return null;
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
		if(trainings.contains(training))
			return false;
		if(training == null)
			return false;
		if(trainings.size() > 15)
			return false;
		trainings.add(training);
		return true;
	}
	
	public boolean entfernen(HundeTraining training) {
		if(trainings.contains(training)) {
			trainings.remove(training);
			return true;
		}
		return false;
	}
	
	public int entfernen(String trainer) {
		if(trainer == null)
			return -99;
		
		int vorher = trainings.size();
		trainings.removeIf(t -> t.getTrainer().equals(trainer));
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
	
	
	public int anzahlPreisGesamt(float maxPreisGesamt) {
//		Iterator<HundeTraining> it = trainings.iterator();
//		int gruppenTrainings = 0;
//		while(it.hasNext()) {
//			var t = it.next();
//			if(t.ge)
//		}
		return 0;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Hundeschule{" +
				       "name='" + name + '\'' +
				       ", trainings=" + trainings +
				       '}';
	}
}
