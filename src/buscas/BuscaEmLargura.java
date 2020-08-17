package buscas;

import java.util.LinkedList;
import java.util.Queue;

import nos.No;

public class BuscaEmLargura extends Busca{

	private Queue<No> filaNos;

	public BuscaEmLargura(int valorBusca) {
		this.filaNos = new LinkedList<No>();
		this.setValorBusca(valorBusca);
	}

	public boolean buscarResultado(No no) {
		if (isResultadoBusca(no)) {
			obterResultadoPaternal(no);
			return true;
		} else {
			if (no.getNoEsquerda() != null) {
				this.filaNos.add(no.getNoEsquerda());

			}
			if (no.getNoDireita() != null) {
				this.filaNos.add(no.getNoDireita());
			}
			No noPonta = this.filaNos.poll();
			if (noPonta != null && buscarResultado(noPonta)) {
				return true;
			}
		}
		return false;
	}
}