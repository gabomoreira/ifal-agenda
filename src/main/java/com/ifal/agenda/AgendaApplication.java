package com.ifal.agenda;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.ifal.agenda.dto.EventDTO;

@SpringBootApplication
@EntityScan(basePackages = "com.ifal.agenda.entities")
@EnableJpaRepositories(basePackages = "com.ifal.agenda.repositories")
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
		
		 Scanner scanner = new Scanner(System.in);
	        RestTemplate restTemplate = new RestTemplate();
	        String baseUrl = "http://localhost:8080/events";
	        
	        while (true) {
	            System.out.println("Menu Principal");
	            System.out.println("1. Adicionar Evento");
	            System.out.println("2. Listar Eventos");
	            System.out.println("3. Editar Evento");
	            System.out.println("4. Remover Evento");
	            System.out.println("5. Exibir Detalhes");
	            System.out.println("6. Sair");
	            System.out.print("Escolha uma opção: ");
	            int option = scanner.nextInt();
	            scanner.nextLine();

	            switch (option) {
	                case 1:
	                    System.out.print("Título: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Data (DD-MM-AAAA): ");
	                    String dateStr = scanner.nextLine();
	                    System.out.print("Hora (HH:MM): ");
	                    String timeStr = scanner.nextLine();
	                    System.out.print("Descrição: ");
	                    String description = scanner.nextLine();

	                    String dateTimeStr = dateStr + "T" + timeStr + ":00Z";
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ssX");
	                    Instant date = LocalDateTime.parse(dateTimeStr, formatter).atZone(ZoneId.systemDefault()).toInstant();

	                    EventDTO newEvent = new EventDTO(null, title, description, date);
	                    try {
	                        restTemplate.postForObject(baseUrl, newEvent, EventDTO.class);
	                        System.out.println("Evento adicionado com sucesso");
	                    } catch (Exception e) {
	                        System.out.println("Ocorreu um erro ao adicionar o evento: " + e.getMessage());
	                    }
	                    break;
	                case 2:
	                    // Lógica para listar eventos
	                    break;
	                case 3:
	                    // Lógica para editar evento
	                    break;
	                case 4:
	                    // Lógica para remover evento
	                    break;
	                case 5:
	                    // Lógica para exibir detalhes do evento
	                    break;
	                case 6:
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            } 
	        }
	}
	
       

}
