package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Character;
import model.Clan;

class ClanTest {

	Clan clan;
	
	public void stage1(){
		clan=new Clan("Bohorquez", "Aldea de la Hoja");
	}
	
	public void stage2() {
		stage1();
		try {
			clan.addFirst(new Character("a", "Agresivo", "1998", 1, "Prueba Academica"));
			clan.addFirst(new Character("oscar", "Pacifico", "1998", 1000, "Karate"));
			clan.addFirst(new Character("victor", "Agresivo", "1998", 5000, "Programacion"));
			clan.addFirst(new Character("brito", "Pendejo", "1998", 1, "Rendirse en Clases"));
		}catch(Exception e){
			
		}
	}
	
	@Test
	void ordenarParcialNombreTest() {
		stage2();
		System.out.println(clan.getCharacter().size());
		clan.ordenarParcialName();
		assertEquals("brito", clan.getCharacter().get(0).getName());
	}

}
