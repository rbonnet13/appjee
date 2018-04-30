package projet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECTEUR")
public class Directeur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_directeur")
	private int idDirecteur;
	@Column(name = "nom_directeur")
	private String nomDirecteur;
	@Column(name = "type_directeur")
	private String typeDirecteur;
	@Column(name = "etudiants_rattaches")
	private String etudiantsRattaches;

	public int getIdDirecteur() {
		return idDirecteur;
	}

	public void setIdDirecteur(int idDirecteur) {
		this.idDirecteur = idDirecteur;
	}

	public String getNomDirecteur() {
		return nomDirecteur;
	}

	public void setNomDirecteur(String nomDirecteur) {
		this.nomDirecteur = nomDirecteur;
	}

	public String getTypeDirecteur() {
		return typeDirecteur;
	}

	public void setTypeDirecteur(String typeDirecteur) {
		this.typeDirecteur = typeDirecteur;
	}

	public String getEtudiantsRattaches() {
		return etudiantsRattaches;
	}

	public void setEtudiantsRattaches(String etudiantsRattaches) {
		this.etudiantsRattaches = etudiantsRattaches;
	}

}
