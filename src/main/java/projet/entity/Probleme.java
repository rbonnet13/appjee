package projet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROBLEMES")
public class Probleme implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProbleme;
	private String texteProbleme;
	private Date dateProbleme;
	private int nomAuteur;
	private int prenomAuteur;

	/*
	 * @ManyToMany(mappedBy="problemes") private List<Etudiant> students;
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="id_etudiant") private Etudiant etudiant;
	 */

	public int getIdProbleme() {
		return idProbleme;
	}

	public void setIdProbleme(int idProbleme) {
		this.idProbleme = idProbleme;
	}

	public String getTexteProbleme() {
		return texteProbleme;
	}

	public void setTexteProbleme(String texteProbleme) {
		this.texteProbleme = texteProbleme;
	}

	public Date getDateProbleme() {
		return dateProbleme;
	}

	public void setDateProbleme(Date dateProbleme) {
		this.dateProbleme = dateProbleme;
	}

	public int getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(int nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public int getPrenomAuteur() {
		return prenomAuteur;
	}

	public void setPrenomAuteur(int prenomAuteur) {
		this.prenomAuteur = prenomAuteur;
	}
}
