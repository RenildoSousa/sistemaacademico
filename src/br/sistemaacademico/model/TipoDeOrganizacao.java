package br.sistemaacademico.model;

public enum TipoDeOrganizacao {
	FACULDADE(1, "Faculdade"),
	UNIVERCIDADE(1, "Universidade");

	private int value;
	private String label;
	
	TipoDeOrganizacao(int value, String label) {
		this.value = value;
		this.label = label;		
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	// retorna um tipoDeOrganizacao a partir de um valor inteiro
	public static TipoDeOrganizacao valueOf(int value) {
		for (TipoDeOrganizacao tipoDeOrganizacao : TipoDeOrganizacao.values()) {
			if (tipoDeOrganizacao.getValue() == value) {
				return tipoDeOrganizacao;
			}
		}
		return null;
	}
	
}