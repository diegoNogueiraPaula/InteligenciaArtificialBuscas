package buscas;

import nos.No;

public abstract class Busca {
	
	private int valorBusca;

	private String textoResposta;
	
	
	public boolean isResultadoBusca(No no) {
		return no.getValor() == valorBusca;
	}
	
	protected void obterResultadoPaternal(No no) {
		String retorno = "";
		No noValor = no;
		retorno += no.getValor();

		while (noValor.getNoPai() != null) {
			noValor = noValor.getNoPai();
			retorno = noValor.getValor() + " " + retorno;
		}
		this.textoResposta = retorno;
	}
	
	public void exibirTextoResultador() {
		if (textoResposta != null) {
			System.out.println("O caminho percorrido será: " + this.textoResposta);
		} else {
			System.out.println("O valor " + this.valorBusca + "não foi encontrado.");
		}
	}

	public String getTextoResposta() {
		return textoResposta;
	}

	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}

	public int getValorBusca() {
		return valorBusca;
	}

	public void setValorBusca(int valorBusca) {
		this.valorBusca = valorBusca;
	}
}
