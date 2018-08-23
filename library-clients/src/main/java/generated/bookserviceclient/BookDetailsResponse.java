package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookDetailsResponse complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="bookDetailsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://services.libraryws.projects.brucella.fr/}bookDetailsDto"
 *         minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookDetailsResponse", propOrder = {"_return"})
public class BookDetailsResponse {

  @XmlElement(name = "return")
  protected BookDetailsDto _return;

  /**
   * Obtient la valeur de la propriété return.
   *
   * @return possible object is {@link BookDetailsDto }
   */
  public BookDetailsDto getReturn() {
    return _return;
  }

  /**
   * Définit la valeur de la propriété return.
   *
   * @param value
   *     allowed object is {@link BookDetailsDto }
   */
  public void setReturn(BookDetailsDto value) {
    this._return = value;
  }

}
