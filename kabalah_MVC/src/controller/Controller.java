package controller;

import java.util.LinkedList;
import java.util.List;

import model.Model;

public class Controller {

	Model mod = new Model();

	public Controller(Model model) {
		this.mod = model;
	}

	public String permuta(String text) {

		return mod.permuta(text).toString();
	}
	
	public StringBuilder permutaSb(String text) {

		return mod.permuta(text);
	}

	public void addConjuntoString(String text) {
		Model.conjunto.add(text);

	}

	public void clearSb() {
		mod.clearSb();

	}
	
	public List<String> getConjunto(){
		return mod.getConjunto();
	}

}
