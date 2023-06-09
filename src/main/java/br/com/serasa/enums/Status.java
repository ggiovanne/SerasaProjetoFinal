package br.com.serasa.enums;

public enum Status {

	PENDENTE("PENDENTE"),
	EM_PROGRESSO("EM PROGRESSO"),
	CONCLUIDO("CONCLUIDO");

	private String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
