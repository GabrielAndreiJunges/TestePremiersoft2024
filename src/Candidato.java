public class Candidato {

	private String nomeCompleto;

	private int idade;

	private String vaga;

	private String estado;

	public Candidato() {
	};

	public Candidato(String nomeCompleto, int idade, String vaga, String estado) {
		setNomeCompleto(nomeCompleto);
		setIdade(idade);
		setVaga(vaga);
		setEstado(estado);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getPrimeiroNome(String nomeCompleto) {
		String[] parte = nomeCompleto.split(" ");

		return parte.length > 0 ? parte[0] : "";
	}

	public String getSegundoNome(String nomeCompleto) {
		String[] parte = nomeCompleto.split(" ");

		return parte.length > 0 ? parte[parte.length - 1] : "";
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}