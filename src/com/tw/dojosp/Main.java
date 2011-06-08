package com.tw.dojosp;

import java.sql.Connection;
import java.util.Map;

import com.tw.dojosp.service.ReportService;

public class Main {
	public static void main(String[] args) {
		// conexão com o banco de dados
		Connection connection = new InMemoryDatabase().getConnection();
		
		// serviço para gerar reports
		ReportService service = new ReportService();
		
		service.setConnection(connection);
		
		// encontrar todos os usuários
		Map<Integer, String> user = service.findUsers("a");
		if(user != null) {
			
			 for(Integer userId : user.keySet()) {
				 
				 System.out.println("Nome: " + user.get(userId));
				 
				 for(String device : service.findDevices(userId)) {
					 System.out.println("device: " + device);
				 }
				 
			 }
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
}
