public abstract class HundeTraining {
	private int einheiten;
	private String hund;
	private String trainer;
	
	public HundeTraining(int einheiten, String hund, String trainer) throws HundeException {
		setEinheiten(einheiten);
		setHund(hund);
		setTrainer(trainer);
	}
	
	public int getEinheiten() {
		return einheiten;
	}
	
	public void setEinheiten(int einheiten) throws HundeException {
		if(einheiten < 1)
			throw new HundeException("Einheiten zu klein.");
		this.einheiten = einheiten;
	}
	
	public String getHund() {
		return hund;
	}
	
	public void setHund(String hund) throws HundeException {
		if(hund == null)
			throw new HundeException("Hund darf nicht null sein.");
		
		this.hund = hund;
	}
	
	public String getTrainer() {
		return trainer;
	}
	
	public void setTrainer(String trainer) throws HundeException {
		if(trainer == null)
			throw new HundeException("Trainer darf nicht null sein.");
		
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
