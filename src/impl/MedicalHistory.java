package impl;

public enum MedicalHistory {

	HeartorCirculatorydisorder(1), EndocrineDisorders(2), BreathingDisorder(3), StomachLiverDisorder(4);
	
	int order;
	MedicalHistory(int order){
		this.order = order;
	}
	
}
