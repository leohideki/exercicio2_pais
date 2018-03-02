package exercicio_02_para_entregar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class Teste2 {
	
	Pais pais,copia;
	static int id = 1;
	
	@BeforeEach
	public void setUp() throws Exception {
	System.out.println("setup");
	pais = new Pais(id, "Pais1", 82670000, 357376.00 );
	copia = new Pais(id, "Pais1",82670000 , 357376.00 );
	System.out.println(pais);
	}
	
	@Test
	public void test00Carregar() {
	System.out.println("carregar");
	Pais fixture = new Pais(1, "Brasil", 207000000,8516000.00);
	Pais novo = new Pais(1, null,0, 0.00);
	novo.carregar();
	assertEquals("testa inclusao", novo.getId(), fixture.getId());
	}
	
	@Test
	public void test01Criar() {
	System.out.println("criar");
	pais.criar();
	id = pais.getId();
	copia.setId(id);
	assertEquals("testa criacao", pais.getId(), copia.getId());
	}
	
	@Test
	public void test02Atualizar() {
	System.out.println("atualizar");
	pais.setNome("Pais2");
	copia.setNome("Pais2");
	pais.atualizar();
	pais.carregar();
	assertEquals("testa atualizacao", pais.getId(), copia.getId());
	}
	
	@Test
	public void test03Excluir() {
	System.out.println("excluir");
	copia.setId(-1);
	copia.setNome(null);
	copia.setPopulacao(0);
	copia.setArea(0);
	pais.excluir();
	pais.carregar();
	assertEquals("testa exclusao",pais.getId(), copia.getId());
	}
	
	@Test
	public void test04MaiorPopulacao() {
		System.out.println("maior populacao");
		pais.maiorPopulacao();
		long populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		assertEquals("testa maior populacao",pais.getPopulacao(),copia.getPopulacao());
	}
	
    @Test
	public void test05MenorArea() {
		System.out.println("menor area");
		pais.menorArea();
		double area = pais.getArea();
		copia.setArea(area);
		assertEquals(pais.getArea(),copia.getArea(),"testa menor area");
	}
    
	@Test
	public void test06VetorTresPaises() {
		System.out.println("vetor de 3 paises");
		String[] vetorTresPais = pais.vetorTresPaises();
		assertEquals(vetorTresPais.length,3,"Testando Vetor de paises");
	}
}
