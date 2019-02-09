package generated.authentificationserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe Java pour addUser complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="addUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://services.libraryws.projects.brucella.fr/}fullUserDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "addUser",
    propOrder = {"arg0"})
public class AddUser {

  protected FullUserDto arg0;

  /**
   * Obtient la valeur de la propriété arg0.
   *
   * @return possible object is {@link FullUserDto }
   */
  public FullUserDto getArg0() {
    return arg0;
  }

  /**
   * Définit la valeur de la propriété arg0.
   *
   * @param value allowed object is {@link FullUserDto }
   */
  public void setArg0(FullUserDto value) {
    this.arg0 = value;
  }
}
