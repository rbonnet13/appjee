package projet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(name="INFORMATION")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_information")
	private int idInformation;
	@Column(name = "promotion_destinataire")
	private String promotionDestinataire;
	@Column(name = "auteur_info")
	private String auteurInfo;
	@Column(name = "texte_info")
	private String texteInfo;

	public int getIdInformation() {
		return idInformation;
	}

	public void setIdInformation(int idInformation) {
		this.idInformation = idInformation;
	}

	public String getPromotionDestinataire() {
		return promotionDestinataire;
	}

	public void setPromotionDestinataire(String promotionDestinataire) {
		this.promotionDestinataire = promotionDestinataire;
	}

	public String getAuteurInfo() {
		return auteurInfo;
	}

	public void setAuterInfo(String auteurInfo) {
		this.auteurInfo = auteurInfo;
	}

	public String getTexteInfo() {
		return texteInfo;
	}

	public void setTexteInfo(String texteInfo) {
		this.texteInfo = texteInfo;
	}
}