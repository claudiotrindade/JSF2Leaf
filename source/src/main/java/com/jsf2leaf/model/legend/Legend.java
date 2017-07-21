package com.jsf2leaf.model.legend;

import java.util.ArrayList;
import java.util.List;

public class Legend {
	
	private List<Grade> grades = new ArrayList<Grade>();
	private String position = "bottomleft";
	
	public List<Grade> getGrades() {
		return this.grades;
	}
	
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	public void addGrade(Integer value, String label, String color) {
		this.grades.add(new Grade(value, label, color));
	}
	
	public void addGrade(Integer value, String color) {
		this.addGrade(value, "", color);
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
