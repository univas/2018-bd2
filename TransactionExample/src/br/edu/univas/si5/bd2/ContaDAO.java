package br.edu.univas.si5.bd2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

	private String sentenca = "UPDATE ACCOUNT SET AMOUNT = ? WHERE ACCOUNT_NUMBER = ?";
	
	public void transferir(int origem, int destino, int valorDaOperacao) {
		
		Connection conn = null;
		try {
			conn = DBUtil.openConnection(); //inicia a transação
			conn.setAutoCommit(false);
			
			int saldoOrigem = consultarSaldo(origem);
			
			if(saldoOrigem == -1) {// não achou a conta
				//provoca erro para fazer o rollback
				throw new SQLException("Conta de origem não encontrada");
			}
			int novoValor = saldoOrigem - valorDaOperacao;
			
			//update para sacar
			PreparedStatement stmSacar = conn.prepareStatement(sentenca);
			stmSacar.setInt(1, novoValor);
			stmSacar.setInt(2, origem);
			stmSacar.execute();
			
			int saldoDestino = consultarSaldo(destino);
			if(saldoDestino == -1) {// não achou a conta
				//provoca erro para fazer o rollback
				throw new SQLException("Conta de destino não encontrada");
			}
			novoValor = saldoDestino + valorDaOperacao;
			
			//update para depositar
			PreparedStatement stmDepositar = conn.prepareStatement(sentenca);
			stmDepositar.setInt(1, novoValor);
			stmDepositar.setInt(2, destino);
			stmDepositar.execute();
			
			//no final
			conn.commit();//efetiva a transação
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//desfaz a transação
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public int consultarSaldo(int numeroDaConta) {
		String sql = "SELECT AMOUNT FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.openConnection();
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, numeroDaConta);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			} else {
				//não achou nenhuma conta
				return -1;//flag
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return -1;
	}
}
