import java.util.*;

public class Ensalamento {
	public ArrayList<Sala> salas;
	public ArrayList<Turma> turmas;
	public ArrayList<TurmaEmSala> ensalamento;

	Ensalamento() {
		this.salas = new ArrayList<Sala>();
		this.turmas = new ArrayList<Turma>();
		this.ensalamento = new ArrayList<TurmaEmSala>();

	}

	void addSala(Sala sala) {
		salas.add(sala);
	}

	void addTurma(Turma turma) {
		turmas.add(turma);
	}

	Sala getSala(Turma turma) {
		Sala acheiSala = null;
		for (int i = 0; i < ensalamento.size(); i++) {
			if (turma == ensalamento.get(i).turma) {
				acheiSala = ensalamento.get(i).sala;
			}
		}
		return acheiSala;
	}

	boolean salaDisponivel(Sala sala, int horario) {
		for (int i = 0; i < ensalamento.size(); i++) {
			Turma acheiTurma = ensalamento.get(i).turma;
			if (sala == ensalamento.get(i).sala) {
				for (int j = 0; j < acheiTurma.horarios.size(); j++) {
					if (acheiTurma.horarios.get(j) == horario) {
						return false;
					}
				}
			}
		}
		return true;
	}

	boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
		boolean temHoracio = true;
		for (int i = 0; i < horarios.size() && temHoracio == true; i++) {
			temHoracio = salaDisponivel(sala, horarios.get(i));
		}
		return temHoracio;
	}

	boolean alocar(Turma turma, Sala sala) {
		boolean vaiDar = true;
		if (sala == null) {
			return false;
		}
		if (turma.acessivel == true && sala.acessivel == false) {
			return false;
		}
		if (turma.numAlunos > sala.capacidade) {
			return false;
		}
		if (salaDisponivel(sala, turma.horarios) == false) {
			return false;
		} else {
			TurmaEmSala turmaNova = new TurmaEmSala(turma, sala);
			ensalamento.add(turmaNova);
		}
		return vaiDar;
	}

	void alocarTodas() {
		for (int i = 0; i < turmas.size(); i++) {
			boolean deuPralocar = false;
			for (int j = 0; j < salas.size() && !deuPralocar; j++) {

				deuPralocar = alocar(turmas.get(i), salas.get(j));
			}
		}
	}

	int getTotalTurmasAlocadas() {
		int todas = 0;
		for (int i = 0; i < ensalamento.size(); i++) {
			if (ensalamento.get(i).sala != null) {
				todas = todas + 1;
			}
		}
		return todas;
	}

	int getTotalEspacoLivre() {
		int livre = 0;
		for (int i = 0; i < ensalamento.size(); i++) {
			livre = livre + ensalamento.get(i).sala.capacidade - ensalamento.get(i).turma.numAlunos;
		}
		return livre;
	}

	String relatorioResumoEnsalamento() {
		String resumo = "";
		resumo = resumo + "Total de Salas: " + salas.size();
		resumo = resumo + "\nTotal de Turmas: " + turmas.size();
		resumo = resumo + "\nTurmas Alocadas: " + getTotalTurmasAlocadas();
		resumo = resumo + "\nEspaços Livres: " + getTotalEspacoLivre();
		return resumo;
	}

	String relatorioTurmasPorSala() {
		String relatorio = "";
		relatorio = relatorio + relatorioResumoEnsalamento();
		for (int i = 0; i < salas.size(); i++) {
			relatorio = relatorio + "--- " + salas.get(i).getDescricao() + "---\n";
			for (int j = 0; j < ensalamento.size(); j++) {
				if (salas.get(i).getDescricao().equals(ensalamento.get(j).sala.getDescricao())) {
					relatorio = relatorio + turmas.get(i).getDescricao();
				}
			}
		}
		return relatorio;
	}

	String relatorioSalasPorTurma() {
		String relatorio = "";
		relatorio = relatorio + relatorioResumoEnsalamento() + "\n";
		for (int i = 0; i < turmas.size(); i++) {
			relatorio = relatorio + turmas.get(i).getDescricao() + "\n";
			Sala sala = getSala(turmas.get(i));
			if (sala != null) {
				relatorio = relatorio + "Sala: " + sala.getDescricao() + "\n";
			} else {
				relatorio = relatorio + "Sala: SEM SALA\n";
			}
		}
		return relatorio;
	}

}