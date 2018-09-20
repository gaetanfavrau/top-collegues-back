package dev.top.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueSource;

public class ConvertersTest {

	@Test
	public void CollegueSourceToCollegue() {
		
		CollegueSource collegueSource = new CollegueSource();
		collegueSource.setAdresse("752 Winthrop Street, Interlochen, 9133");		
		
		Collegue collegue = Converters.COLLEGUE_SOURCE_TO_COLLEGUE.convert(collegueSource);
		//assertEquals(9133, collegue.getAdresse().getCodePostal().intValue());
		//assertEquals("Interlochen", collegue.getAdresse().getVille());
		assertThat(collegue.getAdresse().getNumero()).isEqualTo(752);
		assertThat(collegue.getAdresse().getLibelle()).isEqualTo("Winthrop Street");
		assertThat(collegue.getAdresse().getCodePostal()).isEqualTo(9133);
		assertThat(collegue.getAdresse().getVille()).isEqualTo("Interlochen");
	}
	

}
