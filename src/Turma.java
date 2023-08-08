

import java.util.ArrayList;

public class Turma {
	public String nome;
	public String professor;
	public int numAlunos;
	public boolean acessivel;
	public ArrayList<Integer> horarios;

	Turma() {
		this("", "", 0, false);
	}

	Turma(String nome, String professor, int numAlunos, boolean acessivel) {
		this.nome = nome;
		this.professor = professor;
		this.numAlunos = numAlunos;
		this.acessivel = acessivel;
		this.horarios = new ArrayList<Integer>();

	}

	void addHorario(int horario) {
		horarios.add(horario);
	}

	String getHorariosString() {
		int[] hora = { 20, 8, 10, 12, 14, 16, 18 };
		String result = "";
		for (int i = 0; i < horarios.size(); i++) {
			if (0 < horarios.get(i) && horarios.get(i) < 8) {
				result = result + ("segunda " + hora[horarios.get(i) % 7] + "hs");
			}
			if (7 < horarios.get(i) && horarios.get(i) < 15) {
				result = result + ("terça " + hora[horarios.get(i) % 7] + "hs");
			}
			if (14 < horarios.get(i) && horarios.get(i) < 22) {
				result = result + ("quarta " + hora[horarios.get(i) % 7] + "hs");
			}
			if (21 < horarios.get(i) && horarios.get(i) < 29) {
				result = result + ("quinta " + hora[horarios.get(i) % 7] + "hs");
			}
			if (28 < horarios.get(i) && horarios.get(i) < 36) {
				result = result + ("sexta " + hora[horarios.get(i) % 7] + "hs");
			}
			if (i < horarios.size() - 1) {
				result = result + ", ";
			}
		}
		return (result);
	}

	String getDescricao() {
		String buff = "";
		if (acessivel) {
			buff = "sim";
		} else {
			buff = "não";
		}
		return ("Turma: " + nome + "\nProfessor: " + professor + "\nNúmero de Alunos: " + numAlunos + "\nHorário: "
				+ getHorariosString() + "\nAcessível: " + buff);

	}

}