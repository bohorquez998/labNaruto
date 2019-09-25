package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Technique implements Serializable {
	
	private String name;
	private int damage;
	private Technique next;
	
	public Technique(String name, int damage) {
		next=null;		
		this.name = name;
		this.damage = damage;
	}
	
	public void setNext(Technique newNext) {
		this.next=newNext;
	}
	
	public Technique getNext() {
		return next;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void disconnectNext() {
		 next = next.next;
		
	}
	
	public int compareTo(Technique esperado) {
		return this.name.compareToIgnoreCase(esperado.getName());
	}

	public Technique darNextTechnique() {
		// TODO Auto-generated method stub
		return next;
	}

	

	

}

