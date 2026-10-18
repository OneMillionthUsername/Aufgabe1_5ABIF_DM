public class GruppenTraining extends HundeTraining {
	private float kursPreis;
	
	public GruppenTraining(int einheiten, String hund, String trainer, float kursPreis) throws HundeTrainingException {
		super(einheiten, hund, trainer);
		setKursPreis(kursPreis);
	}
	
	public float getKursPreis() {
		return kursPreis;
	}
	
	public void setKursPreis(float kursPreis) throws HundeTrainingException {
		if(kursPreis <= 0)
			throw new HundeTrainingException("Kurspreis muss größer als 0 sein.");
		this.kursPreis = kursPreis;
	}
	
	@Override
	public float preisGesamt(){
		return getKursPreis();
	}
	
	@Override
	public String toString() {
		return "GruppenTraining" + super.toString() + "kursPreis= " + getKursPreis() + " EUR.";
	}
}
