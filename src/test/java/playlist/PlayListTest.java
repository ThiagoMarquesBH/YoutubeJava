package playlist;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import base.BaseTests;

public class PlayListTest extends BaseTests{
	
	@Test
	public void testTocarMusica() {
		carregarPaginaInicial();
		homePage.escolherMusica("BLUESMAN (Filme Oficial)");
		assertThat(homePage.a(), is(8));
	}
}
