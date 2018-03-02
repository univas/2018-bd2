package br.edu.univas.si5.bd2;

public class RunnerConcurrent {

	public static void main(String[] args) {
		ContaDAO dao = new ContaDAO();
		dao.transferir(1, 2, 111);
	}

}
