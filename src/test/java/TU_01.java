import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.tactfactory.tp1junit.manager.Jeu;
import com.tactfactory.tp1junit.model.*;

public class TU_01 {

	@Test
	public void testTU001() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Jeu jeu = new Jeu(2, 10, 10);
		Joueur joueur = jeu.getJoueurs().get(0);
		/**
		 * bateauPlacable
		 *
		 * @param navire
		 * 
		 * @param x
		 * 
		 * @param y
		 * 
		 * @param direction : 0 | 1
		 * 
		 * @param joueur
		 * 
		 * @return boolean
		 */
		
		Method bateauPlacable = Jeu.class.getDeclaredMethod("bateauPlacable", Navire.class, int.class, int.class,
				int.class, Joueur.class);
		bateauPlacable.setAccessible(true);

		/**
		 * placeBateau
		 *
		 * @param navire
		 * @param x
		 * @param y
		 * @param direction
		 */
		Method method = Jeu.class.getDeclaredMethod("placeBateau", Navire.class, int.class, int.class, int.class);
		method.setAccessible(true);

		// Test Placement du premier bateau en 0 0 avec orientation 0
		boolean result = (boolean) bateauPlacable.invoke(jeu, joueur.getMap().get(0), 0, 0, 0, joueur);
		assertTrue(result);

		// Placement du premier bateau en 0 0 avec orientation 0
		method.invoke(jeu, joueur.getMap().get(0), 0, 0, 0);

		// Test Placement du second bateau en 0 0 avec orientation 0
		result = (boolean) bateauPlacable.invoke(jeu, joueur.getMap().get(1), 0, 0, 0, joueur);
		assertFalse(result);
	}

}
