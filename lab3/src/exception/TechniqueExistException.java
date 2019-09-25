package exception;

public class TechniqueExistException extends Exception {
	public TechniqueExistException() {
		super("la tecnica ya se encuentra registrada");
	}
}
