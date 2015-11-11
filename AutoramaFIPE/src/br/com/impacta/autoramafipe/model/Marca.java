package br.com.impacta.autoramafipe.model;

public class Marca {

	private String name;
	private String fipe_name;
	private Integer order;
	private String key;
	private Integer id;

	public Marca() {

	}

	public Marca(String name, String fipe_name, Integer order, String key,
			Integer id) {
		this.name = name;
		this.fipe_name = fipe_name;
		this.order = order;
		this.key = key;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getName();
	}
}
