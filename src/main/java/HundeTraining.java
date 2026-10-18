public abstract class HundeTraining {
	private int einheiten;
	private String hund;
	private String trainer;
	
	public HundeTraining(int einheiten, String hund, String trainer) throws HundeTrainingException {
		setEinheiten(einheiten);
		setHund(hund);
		setTrainer(trainer);
	}
	
	public int getEinheiten() {
		return einheiten;
	}
	
	public void setEinheiten(int einheiten) throws HundeTrainingException {
		if(einheiten < 1)
			throw new HundeTrainingException("Einheiten zu klein.");
		this.einheiten = einheiten;
	}
	
	public String getHund() {
		return hund;
	}
	
	public void setHund(String hund) throws HundeTrainingException {
		if(hund == null)
			throw new HundeTrainingException("Hund darf nicht null sein.");
		
		this.hund = hund;
	}
	
	public String getTrainer() {
		return trainer;
	}
	
	public void setTrainer(String trainer) throws HundeTrainingException {
		if(trainer == null)
			throw new HundeTrainingException("Trainer darf nicht null sein.");
		
		this.trainer = trainer;
	}
	
	public abstract float preisGesamt();
	
	public double preisProEinheit(){
		return preisGesamt()/einheiten;
	}
	
	@Override
	public String toString() {
		return getEinheiten() + " Einheiten, Hund:" + getHund() +
				"\nTrainer: " + getTrainer() +
				"\nPreis: " + preisGesamt() + " EUR, Preis pro Einheit: " + preisProEinheit() + " EUR";
	}
}
