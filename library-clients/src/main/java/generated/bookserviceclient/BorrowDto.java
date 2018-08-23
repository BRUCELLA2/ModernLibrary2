package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour borrowDto complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="borrowDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.libraryws.projects.brucella.fr/}bookBorrowed">
 *       &lt;sequence>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "borrowDto", propOrder = {"login", "title"})
public class BorrowDto extends BookBorrowed {

  protected String login;
  protected String title;

  /**
   * Obtient la valeur de la propriété login.
   *
   * @return possible object is {@link String }
   */
  public String getLogin() {
    return login;
  }

  /**
   * Définit la valeur de la propriété login.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setLogin(String value) {
    this.login = value;
  }

  /**
   * Obtient la valeur de la propriété title.
   *
   * @return possible object is {@link String }
   */
  public String getTitle() {
    return title;
  }

  /**
   * Définit la valeur de la propriété title.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setTitle(String value) {
    this.title = value;
  }

}
