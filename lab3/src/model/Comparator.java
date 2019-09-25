package model;

public class Comparator {
	
	public int compare(Character ch2, Character ch) {
		return ch.getName().compareToIgnoreCase(ch2.getName());
	}

	public int compare(Technique tch2, Technique tch) {
		return tch.getName().compareToIgnoreCase(tch2.getName());
	}
}