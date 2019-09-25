package model;

import java.util.ArrayList;

public class Clan {
	
	private String name;
	private String ubication;
	
	private Character head;
	
	private ArrayList<Character> characters;
	private Comparator comparator;
	
	public Clan(String name, String ubication) {
		this.name = name;
		this.ubication = ubication;
		head=null;
		characters = new ArrayList<>();
		comparator = new Comparator();
	}
	
	public Character getHead() {
		return head;
	}

	public void setHead(Character head) {
		this.head = head;
	}

	public void addLast(Character newElement) {
		if(head==null) {
			setHead(newElement);
		}else {
			Character actual=head;
			while(actual.getNext()!=null) {
				actual=actual.getNext();
			}
			actual.setNext(newElement);
			newElement.setPrev(actual);
		}
	}
	
	public void addFirst(Character newElement) {
		if(head==null) {
			setHead(newElement);
		}else {
			newElement.setNext(head);
			head.setPrev(newElement);
			setHead(newElement);
		}
	}
	
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	public Character getCharacter( String nameCharacter ) {
        Character actual=head;
        while(actual!=null) {
            if(actual.getName().equalsIgnoreCase(nameCharacter)) {
            	return actual;
            }else {
            	actual=actual.getNext();
            }
        }
        return null;
    }
	

	
	public boolean exists(String name) {
		boolean yes = false;
		int start = 0;
		int end = characters.size() - 1;
		while (start <= end && !yes) {
			int medium = (start + end) / 2;
			if (characters.get(medium).getName().equalsIgnoreCase(name)) {
				yes = true;
			} else if (characters.get(medium).getName().compareToIgnoreCase(name) < 0) {
				start = medium + 1;
			} else {
				end = medium - 1;
			}
		}
		return yes;
	}
	
	public void eliminateCharacter( String name ) throws CharacterExistExcepcion
    {
        if( head == null )
            throw new CharacterExistExcepcion( "No existe un personaje llamado " + name );

        if(name.equalsIgnoreCase(head.getName())){
            
            head = head.getNext( );
        } else{
            Character previous = localizarAnterior( name );
            if( previous != null )
                previous.disconnectNext( );
            else
                throw new CharacterExistExcepcion( "No existe una ciudad llamada " + name );
        }
    }
	
	
	private Character localizarAnterior( String name )
    {
        Character previous = head;
        Character actual = head.getNext( );
        while( actual != null && !actual.getName( ).equalsIgnoreCase( name ) )
        {
            previous = actual;
            actual = actual.getNext( );
        }
        return actual != null ? previous : null;
    }
	
	public ArrayList<Character> getCharacter( )
    {
        ArrayList<Character> characters = new ArrayList<>();

        for( Character p = head; p != null; p = p.getNext( ) )
            characters.add( p );

        return characters;
    }
	
	 public Character searchCharacter( int power ){
		 Character actual = head;
		 while(actual.getNext()!=null) {
			if( actual.getPower( ) == power ) {
	                return actual;
	        }else {
	        	actual=actual.getNext();
	        }
		 }
		 return null;
	 }
	
	public void ordenarNaturalPower() {   
        int i, j, pos;
		Character minor;
		Character tmp;
        for (i = 0; i < characters.size() - 1; i++) { 
        	Character ch = characters.get(i);
              minor = characters.get(i); 
              pos = i; 
              for (j = i + 1; j < characters.size(); j++){
                    if (characters.get(j).compareTo(ch) < 0) { 
                        minor = characters.get(j);
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = characters.get(i);
                  characters.set(i,minor);
                  characters.set(pos, tmp);
              }
        }
	}
	
	public void ordenarParcialName() {
		int i, j, pos;
		Character minor;
		Character tmp;
        for (i = 0; i < characters.size() - 1; i++) { 
        	Character ch = characters.get(i);
              minor = characters.get(i); 
              pos = i; 
              for (j = i + 1; j < characters.size(); j++){
            	  Character ch2 = characters.get(j);
                    if (comparator.compare(ch2, ch) > 0) { 
                        minor = characters.get(j);
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = characters.get(i);
                  characters.set(i,minor);
                  characters.set(pos, tmp);
              }
        }
	}
	
	public int countName( String name ) {
        int acum = 0;
        for( Character p = head; p != null; p = p.getNext( ) ) {
            if( p.getName().equalsIgnoreCase( name ) )
                acum++;
        }
        return acum;
    }

	
	public void changePower() {
		characters.get(characters.size()-1).setPower(characters.get(characters.size()-1).getPower()+5);
	}
	
	public int showPower() {
		return characters.get(characters.size()-1).getPower();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUbication() {
		return ubication;
	}

	public void setUbication(String ubication) {
		this.ubication = ubication;
	}
	
	

}
