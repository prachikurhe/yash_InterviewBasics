package com.interviewQue;

public class Test1 {
	public void myMethod() {
		Interview interview = new Interview();
		interview.setCompany("New Company");
		interview.setLevel(1);
		yourMethod(interview);
		System.out.println(interview.getCompany());

	}

	public void yourMethod(Interview interview) {
		//interview = new Interview();
		interview.setCompany("Old Company");
	}

	public static void main(String[] args) {
		new Test1().myMethod();
		;
	}

}

class Interview {
	String company;
	int level;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}