public class GruppenTraining extends HundeTraining {
	private float kursPreis;
	
	public GruppenTraining(int einheiten, String hund, String trainer, float kursPreis) throws HundeException {
		super(einheiten, hund, trainer);
		setKursPreis(kursPreis);
	}
	
	public float getKursPreis() {
		return kursPreis;
	}
	
	public void setKursPreis(float kursPreis) throws HundeException {
		if(kursPreis <= 0)
			throw new HundeException("Kurspreis muss größer als 0 sein.");
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
