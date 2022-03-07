class JobApplicant {
	
	private String name;
	private boolean word;
	private boolean excel;
	private boolean dataBase;
	private boolean security;
	
	JobApplicant(String name, boolean word, boolean excel, boolean dataBase, boolean security){
		this.name = name;
		this.word = word;
		this.excel = excel;
		this.dataBase = dataBase;
		this.security = security;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getWord() {
		return word;
	}
	
	public void setWord(boolean word) {
		this.word = word;
	}
	
	public boolean getExcel() {
		return excel;
	}
	
	public void setExcel(boolean excel) {
		this.excel = excel;
	}
	
	public boolean getDataBase() {
		return dataBase;
	}

	public void setDataBase(boolean dataBase) {
		this.dataBase = dataBase;
	}

	public boolean getSecurity() {
		return security;
	}

	public void setSecurity(boolean security) {
		this.security = security;
	}

	
	boolean eligible() {
		
		boolean[] eligible = {word, excel, dataBase, security};
		int counter = 0;
		
		for(int i=0; i<eligible.length; i++) {
			
			if(eligible[i] == true) {
				counter++;
			}
		}
		if(counter >= 3) {
			return true;
		}return false;
	}
		
	
	void displayInfo() {
		System.out.println("Name: "+name);
		System.out.println("Skill for word processing: "+word);
		System.out.println("Skill for spreadsheets: "+excel);
		System.out.println("Skill for data base: "+dataBase);
		System.out.println("Skill for security: "+security);
		System.out.println("Eligible for interview: "+eligible());
		System.out.println("------------------------------------------------");
	}
}


public class Job_Application {

	public static void main(String[] args) {
	
		JobApplicant first = new JobApplicant("kong", false, false, false, false);
		first.displayInfo();
		
		JobApplicant second = new JobApplicant("fiora", true, true, true, false);
		second.displayInfo();
		
		JobApplicant third = new JobApplicant("jack", true, true, false, false);
		third.displayInfo();
		
		JobApplicant fourth = new JobApplicant("jet", true, false, false, false);
		fourth.displayInfo();
	}

}
