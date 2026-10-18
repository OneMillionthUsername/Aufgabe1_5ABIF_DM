public class EinzelTraining extends HundeTraining {
	private float einzelPreis;
	
	public EinzelTraining(int einheiten, String hund, String trainer, float einzelPreis) throws HundeTrainingException {
		super(einheiten, hund, trainer);
		setEinzelPreis(einzelPreis);
	}
	
	public float getEinzelPreis() {
		return einzelPreis;
	}
	
	public void setEinzelPreis(float einzelPreis) throws HundeTrainingException {
		if(einzelPreis <= 0)
			throw new HundeTrainingException("Einzelpreis darf nicht kleiner 0 sein.");
		this.einzelPreis = einzelPreis;
	}
	
	@Override
	public float preisGesamt(){
		return super.getEinheiten() * getEinzelPreis();
	}
	
	@Override
	public String toString() {
		return "EinzelTraining" + super.toString() +
				       "einzelPreis= " + getEinzelPreis() + " EUR.";
	}
}
