package exception;

public class CharacterExistException extends Exception {
	public CharacterExistException() {
		super("El personaje ya se encuentra registrado");
	}
}
