package buscas;

import java.util.Stack;

import nos.No;

public class BuscaEmProfundidade extends Busca{

	private Stack<No> pilhaNos;

	public BuscaEmProfundidade(int valorBusca) {
		this.pilhaNos = new Stack<>();
		this.setValorBusca(valorBusca);
	}

	public boolean buscarResultado(No no) {
		this.pilhaNos.add(no);
		if (isResultadoBusca(no)) {
			//obterResultadoPaternal(no);
			obterResultadoViaPilha();
			return true;
		} else {
			if (no.getNoEsquerda() != null && this.buscarResultado(no.getNoEsquerda())) {
				return true;
			}
			if (no.getNoDireita() != null && buscarResultado(no.getNoDireita())) {
				return true;
			}
		}
		this.pilhaNos.pop();
		return false;
	}
	
	public void obterResultadoViaPilha() {
		String retorno = "";
		while (this.pilhaNos.size()>0) {			
			retorno = this.pilhaNos.pop().getValor() + " " + retorno;
		}
		this.setTextoResposta(retorno);
	}

}
