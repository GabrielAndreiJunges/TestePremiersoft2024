import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {

		porcentagemCandidatosPorVaga(CandidatoCSV.ListarCandidatoTXT());

		IdadeMediaCandidatoPorVaga(CandidatoCSV.ListarCandidatoTXT());

		CandidatoMaisVelhoPorVaga(CandidatoCSV.ListarCandidatoTXT());

		CandidatoMaisNovoPorVaga(CandidatoCSV.ListarCandidatoTXT());

		SomaIdadeCandidatosPorVaga(CandidatoCSV.ListarCandidatoTXT());

		QuantidadeEstadosDiferentesEntreCandidatos(CandidatoCSV.ListarCandidatoTXT());

		criarArquivoCSV();

		descobrirInstrutorQA(CandidatoCSV.ListarCandidatoTXT());

		descobrirInstrutorMobile(CandidatoCSV.ListarCandidatoTXT());
	}

	public static void criarArquivoCSV() {

		CandidatoCSV.ListarCandidatoTXT().forEach(t -> CandidatoCSV.adicionarCandidato(t));

		System.out.println("Um arquivo CSV ordenado por idade, referente ao arquivo TXT de candidatos foi criado.");
	}

	public static void descobrirInstrutorQA(ArrayList<Candidato> arrayList) {

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			String estado = candidato.getEstado();
			int idade = candidato.getIdade();
			String nomeCompleto = candidato.getNomeCompleto();

			if (idade == Math.pow(5, 2) && ehPalindromo(candidato.getPrimeiroNome(nomeCompleto)) && estado.equals("SC")
					&& vaga.equals("QA")) {
				System.out.println("O nome do instrutor de QA é: " + nomeCompleto);
			}
		}
	}

	public static void descobrirInstrutorMobile(ArrayList<Candidato> arrayList) {

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			String estado = candidato.getEstado();
			int idade = candidato.getIdade();
			String nomeCompleto = candidato.getNomeCompleto();
			String sobrenome = candidato.getSegundoNome(nomeCompleto);

			if (idade >= 30 && idade <= 40 && idade % 2 == 0 && sobrenome.charAt(0) == 'C' && estado.equals("PI")
					&& vaga.equals("Mobile")) {
				System.out.println("O nome do instrutor de QA é: " + nomeCompleto);
			}
		}
	}

	public static boolean ehPalindromo(String str) {

		String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int esquerda = 0;

		int direita = cleanedStr.length() - 1;

		while (esquerda < direita) {
			if (cleanedStr.charAt(esquerda) != cleanedStr.charAt(direita)) {
				return false;
			}
			esquerda++;
			direita--;
		}

		return true;
	}

	public static void porcentagemCandidatosPorVaga(ArrayList<Candidato> arrayList) {

		double mobile = 0;
		double qa = 0;
		double web = 0;
		double total = 0;

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();

			switch (vaga) {

			case "QA":
				qa++;
				break;

			case "Mobile":
				mobile++;
				break;

			case "Web":
				web++;
				break;
			}

			total++;
		}

		double porcentagemMobile = (mobile / total) * 100;
		double porcentagemQA = (qa / total) * 100;
		double porcentagemWeb = (web / total) * 100;

		System.out.println("A porcentagem Mobile é: " + porcentagemMobile);
		System.out.println("A porcentagem QA é: " + porcentagemQA);
		System.out.println("A porcentagem Web é: " + porcentagemWeb);
	}

	public static void IdadeMediaCandidatoPorVaga(ArrayList<Candidato> arrayList) {

		double mobileIdade = 0;
		int mobileCandidatosQuant = 0;

		double qaIdade = 0;
		int qaCandidatosQuant = 0;

		double webIdade = 0;
		int webCandidatosQuant = 0;

		double total = 0;

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			int idade = candidato.getIdade();

			switch (vaga) {

			case "QA":
				qaIdade = qaIdade + idade;
				qaCandidatosQuant++;
				break;

			case "Mobile":
				mobileIdade = mobileIdade + idade;
				mobileCandidatosQuant++;
				break;

			case "Web":
				webIdade = webIdade + idade;
				webCandidatosQuant++;
				break;
			}

			total = total + idade;
		}

		double mediaQA = qaIdade / qaCandidatosQuant;
		double mediaMobile = mobileIdade / mobileCandidatosQuant;
		double mediaWeb = webIdade / webCandidatosQuant;

		System.out.println("A média de idade dos candidatos de QA é: " + mediaQA);
	}

	public static void CandidatoMaisVelhoPorVaga(ArrayList<Candidato> arrayList) {
		int mobileMaisVelho = Integer.MIN_VALUE;
		int qaMaisVelho = Integer.MIN_VALUE;
		int webMaisVelho = Integer.MIN_VALUE;

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			int idade = candidato.getIdade();

			switch (vaga) {

			case "QA":
				if (idade > qaMaisVelho) {
					qaMaisVelho = idade;
				}
				break;

			case "Mobile":
				if (idade > mobileMaisVelho) {
					mobileMaisVelho = idade;
				}
				break;

			case "Web":
				if (idade > webMaisVelho) {
					webMaisVelho = idade;
				}
				break;
			}
		}

		System.out.println("A idade do candidato mais velho de Mobile é: " + mobileMaisVelho);
	}

	public static void CandidatoMaisNovoPorVaga(ArrayList<Candidato> arrayList) {
		int mobileMaisNovo = Integer.MAX_VALUE;
		int qaMaisNovo = Integer.MAX_VALUE;
		int webMaisNovo = Integer.MAX_VALUE;

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			int idade = candidato.getIdade();

			switch (vaga) {

			case "QA":
				if (idade < qaMaisNovo) {
					qaMaisNovo = idade;
				}
				break;

			case "Mobile":
				if (idade < mobileMaisNovo) {
					mobileMaisNovo = idade;
				}
				break;

			case "Web":
				if (idade < webMaisNovo) {
					webMaisNovo = idade;
				}
				break;
			}
		}

		System.out.println("A idade do candidato mais novo de Web é: " + webMaisNovo);
	}

	public static void SomaIdadeCandidatosPorVaga(ArrayList<Candidato> arrayList) {

		double mobileIdade = 0;
		double qaIdade = 0;
		double webIdade = 0;

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			String vaga = candidato.getVaga();
			int idade = candidato.getIdade();

			switch (vaga) {

			case "QA":
				qaIdade = qaIdade + idade;
				break;

			case "Mobile":
				mobileIdade = mobileIdade + idade;
				break;

			case "Web":
				webIdade = webIdade + idade;
				break;
			}
		}

		System.out.println("A soma das idades dos candidatos de QA é: " + qaIdade);
	}

	public static void QuantidadeEstadosDiferentesEntreCandidatos(ArrayList<Candidato> arrayList) {

		Set<String> estados = new HashSet<>();

		for (Candidato candidato : CandidatoCSV.ListarCandidatoTXT()) {
			estados.add(candidato.getEstado());
		}

		System.out.println("A quantidade de estados distintos presente entre os candidatos é: " + estados.size());
	}

}