package exercicio_02_para_entregar;

public class Teste {
	public static void main(String[] args) {
		Pais pais = new Pais();
		Pais pais2 = new Pais();
		pais.setNome("PaisTeste");
		pais.setPopulacao(87654321);
		pais.setArea(123456.00);
		pais.criar();
		pais.setNome("PaisTes2");
		pais2.setPopulacao(21122112);
		pais2.setArea(252525.00);
		pais2.criar();
		System.out.println(pais);
		System.out.println(pais2);
	}
}
