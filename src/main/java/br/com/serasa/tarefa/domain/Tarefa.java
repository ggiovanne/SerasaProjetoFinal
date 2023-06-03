package br.com.serasa.tarefa.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.serasa.tarefa.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tarefa {
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column (length = 100, nullable = false)
	private String titulo;
	
	@Column (length = 200, nullable = false)
	private String decricao;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	private LocalDateTime dataConclusao;

}
