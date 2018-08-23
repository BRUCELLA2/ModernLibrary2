package generated.authentificationserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour fullUserDto complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="fullUserDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.libraryws.projects.brucella.fr/}user">
 *       &lt;sequence>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="line1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="line2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="line3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" type="{http://services.libraryws.projects.brucella.fr/}role" maxOccurs="unbounded
 *         " minOccurs="0"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fullUserDto", propOrder = {"city", "line1", "line2", "line3", "roles", "zipCode"})
public class FullUserDto extends User {

  protected String city;
  protected String line1;
  protected String line2;
  protected String line3;
  @XmlElement(nillable = true)
  protected List<Role> roles;
  protected String zipCode;

  /**
   * Obtient la valeur de la propriété city.
   *
   * @return possible object is {@link String }
   */
  public String getCity() {
    return city;
  }

  /**
   * Définit la valeur de la propriété city.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setCity(String value) {
    this.city = value;
  }

  /**
   * Obtient la valeur de la propriété line1.
   *
   * @return possible object is {@link String }
   */
  public String getLine1() {
    return line1;
  }

  /**
   * Définit la valeur de la propriété line1.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setLine1(String value) {
    this.line1 = value;
  }

  /**
   * Obtient la valeur de la propriété line2.
   *
   * @return possible object is {@link String }
   */
  public String getLine2() {
    return line2;
  }

  /**
   * Définit la valeur de la propriété line2.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setLine2(String value) {
    this.line2 = value;
  }

  /**
   * Obtient la valeur de la propriété line3.
   *
   * @return possible object is {@link String }
   */
  public String getLine3() {
    return line3;
  }

  /**
   * Définit la valeur de la propriété line3.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setLine3(String value) {
    this.line3 = value;
  }

  /**
   * Gets the value of the roles property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
   * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
   * the roles property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getRoles().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link Role }
   */
  public List<Role> getRoles() {
    if (roles == null) {
      roles = new ArrayList<Role>();
    }
    return this.roles;
  }

  /**
   * Obtient la valeur de la propriété zipCode.
   *
   * @return possible object is {@link String }
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Définit la valeur de la propriété zipCode.
   *
   * @param value
   *     allowed object is {@link String }
   */
  public void setZipCode(String value) {
    this.zipCode = value;
  }

}
