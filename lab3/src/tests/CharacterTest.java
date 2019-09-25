package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import model.Character;
import model.Clan;
import model.Technique;
class CharacterTest {
	
	Character character;
	
	public void stage1(){
		character=new Character("Victor", "Agresivo", "1998", 5000, "Programacion");
	}
	
	public void stage2() {
		stage1();
		try {
			character.addFirst("clones", 500);
			character.addFirst("shidori", 600);
			character.addFirst("rasengan", 800);
		}catch(Exception e){
			
		}
		}

	@Test
	void ordenarParcialName(){
		stage2();
		System.out.println(character.getTechniques().size());
		character.ordenarParcialName();
		assertEquals("clones", character.getTechniques().get(0).getName());
	}

}
