package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OuvinteEstacaoMeteorologicaTest {

    @Test
    void deveNotificarUmOuvinte() {
        EstacaoMeteorologica estacaoMeteorologica = new EstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinte1 = new OuvinteEstacaoMeteorologica();
        estacaoMeteorologica.adicionarOuvinte(ouvinte1);
        estacaoMeteorologica.setAtualizacaoClima("Chuvas fortes em Vassouras.");
        assertEquals("Atualização do Clima: Chuvas fortes em Vassouras.", ouvinte1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarOuvintes() {
        EstacaoMeteorologica estacaoMeteorologica = new EstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinte1 = new OuvinteEstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinte2 = new OuvinteEstacaoMeteorologica();
        estacaoMeteorologica.adicionarOuvinte(ouvinte1);
        estacaoMeteorologica.adicionarOuvinte(ouvinte2);
        estacaoMeteorologica.setAtualizacaoClima("Tempo nublado em Miguel Pereira.");
        assertEquals("Atualização do Clima: Tempo nublado em Miguel Pereira.", ouvinte1.getUltimaNotificacao());
        assertEquals("Atualização do Clima: Tempo nublado em Miguel Pereira.", ouvinte2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarOuvinte() {
        EstacaoMeteorologica estacaoMeteorologica = new EstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinte = new OuvinteEstacaoMeteorologica();
        estacaoMeteorologica.adicionarOuvinte(ouvinte);
        estacaoMeteorologica.removerOuvinte(ouvinte);
        estacaoMeteorologica.setAtualizacaoClima("Alerta Amarelo, Chuvas Intensas em Brasília");
        assertNull(ouvinte.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarOuvinteRemovido() {
        EstacaoMeteorologica estacaoMeteorologica = new EstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinte1 = new OuvinteEstacaoMeteorologica();
        estacaoMeteorologica.setAtualizacaoClima("Chuvas fortes em Vassouras.");
        assertNull(ouvinte1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarOuvinteEstacaoA() {
        EstacaoMeteorologica estacaoMeteorologicaA = new EstacaoMeteorologica();
        EstacaoMeteorologica estacaoMeteorologicaB = new EstacaoMeteorologica();

        OuvinteEstacaoMeteorologica ouvinteA = new OuvinteEstacaoMeteorologica();
        OuvinteEstacaoMeteorologica ouvinteB = new OuvinteEstacaoMeteorologica();

        estacaoMeteorologicaA.adicionarOuvinte(ouvinteA);
        estacaoMeteorologicaB.adicionarOuvinte(ouvinteB);

        estacaoMeteorologicaA.setAtualizacaoClima("Inundação em Barra do Piraí.");

        assertEquals("Atualização do Clima: Inundação em Barra do Piraí.", ouvinteA.getUltimaNotificacao());
        assertNull(ouvinteB.getUltimaNotificacao());
    }


}