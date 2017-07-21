package com.jsf2leaf.model.legend;

import java.util.ArrayList;
import java.util.List;

import com.jsf2leaf.options.Position;

public class Legend {
	
	private List<Grade> grades = new ArrayList<Grade>();
	private Position position = Position.BOTTOM_RIGHT;
	
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
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

}
