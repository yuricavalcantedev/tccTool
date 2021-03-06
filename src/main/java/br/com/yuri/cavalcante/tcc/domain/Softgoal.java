package br.com.yuri.cavalcante.tcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Softgoal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Softgoal parent;
	
	//PRESTAR ATENÇÃO NA QUESTÃO DE UMA ENTIDADE SABER DE OUTRA, MAS A SEGUNDA NÃO SABER DA PRIMEIRA...VER O DIAGRAMA DE CLASSE DO RAPAZ.
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="catalog_id")
	private Catalog catalog;
	
	private String name;
	private String description;
	private boolean priority;
	private Integer nfrType;
	private Integer contributionType;
	private Integer contributionTypeCatalog;
	private Integer evaluationProcedure;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="Softgoal_List_children")
	private List<Softgoal> softgoalList = new ArrayList<Softgoal>();

	public Softgoal() {

	}

	public Softgoal(Softgoal parent, String name, String description, boolean priority,
			Integer nfrType, Integer contributionType, Integer contributionTypeCatalog, Integer evaluationProcedure) {
		super();
		this.parent = parent;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.nfrType = nfrType;
		this.contributionType = contributionType;
		this.contributionTypeCatalog = contributionTypeCatalog;
		this.evaluationProcedure = evaluationProcedure;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Softgoal getParent() {
		return parent;
	}

	public void setParent(Softgoal parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Integer getNfrType() {
		return nfrType;
	}

	public void setNfrType(Integer nfrType) {
		this.nfrType = nfrType;
	}

	public Integer getContributionType() {
		return contributionType;
	}

	public void setContributionType(Integer contributionType) {
		this.contributionType = contributionType;
	}

	public Integer getContributionTypeCatalog() {
		return contributionTypeCatalog;
	}

	public void setContributionTypeCatalog(Integer contributionTypeCatalog) {
		this.contributionTypeCatalog = contributionTypeCatalog;
	}

	public Integer getEvaluationProcedure() {
		return evaluationProcedure;
	}

	public void setEvaluationProcedure(Integer evaluationProcedure) {
		this.evaluationProcedure = evaluationProcedure;
	}

	public List<Softgoal> getSoftgoalList() {
		return softgoalList;
	}

	public void setSoftgoalList(List<Softgoal> softgoalList) {
		this.softgoalList = softgoalList;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}


}
