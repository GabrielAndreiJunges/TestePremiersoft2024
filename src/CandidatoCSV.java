import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CandidatoCSV {

	// Caminho do arquivo .txt
	private static String arquivoTXT = "./Academy_Candidates.txt";

	// Caminho do arquivo .csv
	private static String arquivoCSV = "./Sorted_Academy_Candidates.csv";

	// Métodos

	public static void adicionarCandidato(Candidato candidato) {

		try {

			// Checa a existência do arquivo
			boolean arquivoExistente = new File(arquivoCSV).exists();

			// Abre o escritor para criar o arquivo .csv e inserir os dados
			FileWriter escritor = new FileWriter(arquivoCSV, StandardCharsets.ISO_8859_1, arquivoExistente);

			// Caso o arquivo não exista previamente, insere as seguintes colunas
			if (!arquivoExistente) {
				escritor.write("Nome; Idade; Vaga; Estado\n");
			}

			// Escreve os dados no arquivo .csv
			escritor.write(candidato.getNomeCompleto() + ";" + candidato.getIdade() + " anos" + ";" + candidato.getVaga() + ";"
					+ candidato.getEstado() + "\n");

			// Limpa o escritor
			escritor.flush();

			// Fecha o escritor
			escritor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Candidato> ListarCandidatoCSV() {

		// Cria um ArrayList para armazenar os objetos da classe Candidato
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		try {

			// Abre o leitor para receber o arquivo .txt com os dados
			BufferedReader leitor = new BufferedReader(new FileReader(arquivoCSV));
			String linha;
			boolean primeiraLinha = true;

			// Enquanto ainda houver alguma linha, ele seguirá lendo e gerando objetos com o
			// construtor
			while ((linha = leitor.readLine()) != null) {

				// Como o atributo estava true anteriormente, agora ele irá entrar no if assim
				// ignorando a primeira linha
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				// Cria um vetor de partes separando as mesmas por ";"
				String[] parte = linha.split(";");

				// Partes, ou no caso, "colunas" do nosso arquivo .csv
				String nome = parte[0];
				int idade = Integer.parseInt(parte[1].trim().replace(" anos", ""));
				String vaga = parte[2];
				String estado = parte[3];

				// Adiciona os candidatos a lista
				listaCandidatos.add(new Candidato(nome, idade, vaga, estado));
			}

			leitor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaCandidatos;
	}

	public static ArrayList<Candidato> ListarCandidatoTXT() {

		// Cria um ArrayList para armazenar os objetos da classe Candidato
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		try {

			// Abre o leitor para receber o arquivo .txt com os dados
			BufferedReader leitor = new BufferedReader(new FileReader(arquivoTXT));
			String linha;
			boolean primeiraLinha = true;

			// Enquanto ainda houver alguma linha, ele seguirá lendo e gerando objetos com o
			// construtor
			while ((linha = leitor.readLine()) != null) {

				// Como o atributo estava true anteriormente, agora ele irá entrar no if assim
				// ignorando a primeira linha
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				// Cria um vetor de partes separando as mesmas por ";"
				String[] parte = linha.split(";");

				// Partes, ou no caso, "colunas" do nosso arquivo .txt
				String nome = parte[0];
				int idade = Integer.parseInt(parte[1].trim().replace(" anos", ""));
				String vaga = parte[2];
				String estado = parte[3];

				// Adiciona os candidatos a lista
				listaCandidatos.add(new Candidato(nome, idade, vaga, estado));
			}

			leitor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(listaCandidatos, Comparator.comparingInt(Candidato::getIdade));

		return listaCandidatos;
	}
}