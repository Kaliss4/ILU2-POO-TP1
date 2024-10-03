package villagegaulois;

public class villageSansChefException  extends NullPointerException {
public static final long serialVersionUID = 1L;
	
	public villageSansChefException () {
		
	}
	public villageSansChefException (String message) {
		super (message);
	}
	public villageSansChefException (Throwable cause) {
		super (cause);
	}
	public villageSansChefException (String message, Throwable cause) {
		super (message,cause);
	}

}
// Je ne comprends pas comment ça marche pour créer l'exception et comment l'utiliser...