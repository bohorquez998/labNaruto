package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.CharacterExistException;
import exception.TechniqueExistException;

@SuppressWarnings("serial")
public class Character implements Serializable, Comparable<Character>{ 

	private String name;
	private String personality;
	private String createDate;
	private String technique;
	
	private int power;
	
	private Character next;
	private Character prev;
	
	private Technique head;
	
	private ArrayList<Technique> techniques;
	
	private Comparator comparator;
	
	public Character(String name, String personality, String createDate, int power, String technique) {
	
		this.name = name;
		this.personality = personality;
		this.createDate = createDate;
		this.power = power;
		this.technique = technique;
		next =null;
		prev=null;
		head=null;
		verificarInvariante();
		techniques = new ArrayList<>();
	}
	
	public void addFirst(String name, int damage) {
		Technique newElement=new Technique(name, damage);
		if(head==null) {
			head=newElement;
		}else {
			newElement.setNext(head);
			head=newElement;
		}
	}
	
	public void addLast(String name, int damage) throws TechniqueExistExcepcion {
		Technique newElement=new Technique(name, damage);
		if(head==null) {
			head=newElement;
		}else {
			Technique actual=head;
			while(actual.getNext()!=null) {
				if(actual.getName().equalsIgnoreCase(newElement.getName())) {
					throw new TechniqueExistExcepcion();
				}else {
					actual=actual.getNext();
				}
			}
			actual.setNext(newElement);
		}
	}
	
	public void eliminateCharacter( String name ) throws TechniqueExistExcepcion
    {
        if( head == null )
            throw new TechniqueExistExcepcion( "No existe una tecnica llamada " + name );

        if(name.equalsIgnoreCase(head.getName())){
            
            head = head.getNext( );
        } else{
            Technique previous = localizarAnterior( name );
            if( previous != null )
                previous.disconnectNext( );
            else
                throw new TechniqueExistExcepcion( "No existe una ciudad llamada " + name );
        }
    }
	
	
	private Technique localizarAnterior( String name )
    {
        Technique previous = head;
        Technique actual = head.getNext( );
        while( actual != null && !actual.getName( ).equalsIgnoreCase( name ) )
        {
            previous = actual;
            actual = actual.getNext( );
        }
        return actual != null ? previous : null;
    }
	
	
	
	 public ArrayList<Technique> getTechniques()
	    {
	        ArrayList<Technique> techniques = new ArrayList<>();
	        for( Technique p = head; p != null; p = p.darNextTechnique( ) )
	            techniques.add( p );
	        return techniques;
	    }
	
	public boolean exists(String name) {
		boolean yes = false;
		int start = 0;
		int end = techniques.size() - 1;
		while (start <= end && !yes) {
			int medium = (start + end) / 2;
			if (techniques.get(medium).getName().equalsIgnoreCase(name)) {
				yes = true;
			} else if (techniques.get(medium).getName().compareToIgnoreCase(name) < 0) {
				start = medium + 1;
			} else {
				end = medium - 1;
			}
		}
		return yes;
	}
	
	 public Technique searchTechnique( int damage ){
		 Technique actual = head;
		 while(actual.getNext()!=null) {
			if( actual.getDamage( ) == damage ) {
	                return actual;
	        }else {
	        	actual=actual.getNext();
	        }
		 }
		 return null;
	 }
	 
	 public Technique getHead() {
		 return head;
	 }
	 
	 public void setHead(Technique head) {
		 this.head=head;
	 }
	
	 public Character getNext() {
		 return next;
	 }
	 
	 public void setNext(Character next) {
		 this.next=next;
	 }
	 
	 public Character getPrev() {
		 return prev;
	 }
	
	 public void setPrev(Character prev) {
		 this.prev=prev;
	 }
	 
	public void ordenarNaturalDamage() {   
        int i, j, pos;
		Technique minor;
		Technique tmp;
        for (i = 0; i < techniques.size() - 1; i++) { 
        	Technique tch = techniques.get(i);
              minor = techniques.get(i); 
              pos = i; 
              for (j = i + 1; j < techniques.size(); j++){
                    if (techniques.get(j).compareTo(tch) < 0) { 
                        minor = techniques.get(j);
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = techniques.get(i);
                  techniques.set(i,minor);
                  techniques.set(pos, tmp);
              }
        }
	}

	public void ordenarParcialName() {
		int i, j, pos;
		Technique minor;
		Technique tmp;
        for (i = 0; i < techniques.size() - 1; i++) { 
        	Technique tch = techniques.get(i);
              minor = techniques.get(i); 
              pos = i; 
              for (j = i + 1; j < techniques.size(); j++){
            	  Technique tch2 = techniques.get(j);
                    if (comparator.compare(tch2, tch) > 0) { 
                        minor = techniques.get(j);
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = techniques.get(i);
                  techniques.set(i,minor);
                  techniques.set(pos, tmp);
              }
        }
	}
	
	public void changeDamage() {
		techniques.get(techniques.size()-1).setDamage(techniques.get(techniques.size()-1).getDamage()+5);
	}
	
	public int showDamage() {
		return techniques.get(techniques.size()-1).getDamage();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}
	
	@Override
	public int compareTo(Character o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	

	public void verificarInvariante( )
    {
        assert name != null && !name.equals( "" ) : "El nombre del personaje debe estar definido";
        assert personality != null && !personality.equals( "" ) : "La personalidad del personaje debe estar definida";
        assert technique != null && !technique.equals( "" ) : "La tecnica del personaje debe estar definida";
        assert createDate != null && !createDate.equals( "" ) : "La fecha de creacion del personaje debe estar definido";
        assert power > 0 : "El poder debe de ser mayor a 0";
       

        if( head != null )
        {
            Technique actual = head;
            Technique next = head.darNextTechnique( );
            while( next != null )
            {
                assert actual.getDamage( ) < next.getDamage( ) : "las tecnicas deberían estar organizados de forma ascendente";
                actual = next;
                next = next.darNextTechnique( );
            }
        }
    }

	public void disconnectNext() {
		 next = next.next;
		
	}

	public Character darNextCharacter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
	
