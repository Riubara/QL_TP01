import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.tactfactory.tp1junit.manager.Jeu;
import com.tactfactory.tp1junit.model.Joueur;
import com.tactfactory.tp1junit.model.Navire;

public class TU_02 {

	@Test
	public void testTU002() throws NoSuchMethodException, SecurityException {

		int nbJoueur = 2;
		int cordX = 10;
		int cordY = 10;

		Jeu jeu = new Jeu(nbJoueur, cordX, cordY);
		Joueur joueur = jeu.getJoueurs().get(0);

		Method bateauPlacable = Jeu.class.getDeclaredMethod("bateauPlacable", Navire.class, int.class, int.class,
				int.class, Joueur.class);
		bateauPlacable.setAccessible(true);

	}

}
