package generated.bookserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe Java pour bookDetailsDto complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="bookDetailsDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.libraryws.projects.brucella.fr/}book">
 *       &lt;sequence>
 *         &lt;element name="amountAvailable" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="authors" type="{http://services.libraryws.projects.brucella.fr/}author" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="endBorrowDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbActiveReservations" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="publisherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "bookDetailsDto",
    propOrder = {
      "amountAvailable",
      "authors",
      "endBorrowDate",
      "genreName",
      "nbActiveReservations",
      "publisherName"
    })
public class BookDetailsDto extends Book {

  protected Integer amountAvailable;

  @XmlElement(nillable = true)
  protected List<Author> authors;

  protected String endBorrowDate;
  protected String genreName;
  protected Integer nbActiveReservations;
  protected String publisherName;

  /**
   * Obtient la valeur de la propriété amountAvailable.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getAmountAvailable() {
    return amountAvailable;
  }

  /**
   * Définit la valeur de la propriété amountAvailable.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setAmountAvailable(Integer value) {
    this.amountAvailable = value;
  }

  /**
   * Gets the value of the authors property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the authors property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getAuthors().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Author }
   */
  public List<Author> getAuthors() {
    if (authors == null) {
      authors = new ArrayList<Author>();
    }
    return this.authors;
  }

  /**
   * Obtient la valeur de la propriété endBorrowDate.
   *
   * @return possible object is {@link String }
   */
  public String getEndBorrowDate() {
    return endBorrowDate;
  }

  /**
   * Définit la valeur de la propriété endBorrowDate.
   *
   * @param value allowed object is {@link String }
   */
  public void setEndBorrowDate(String value) {
    this.endBorrowDate = value;
  }

  /**
   * Obtient la valeur de la propriété genreName.
   *
   * @return possible object is {@link String }
   */
  public String getGenreName() {
    return genreName;
  }

  /**
   * Définit la valeur de la propriété genreName.
   *
   * @param value allowed object is {@link String }
   */
  public void setGenreName(String value) {
    this.genreName = value;
  }

  /**
   * Obtient la valeur de la propriété nbActiveReservations.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getNbActiveReservations() {
    return nbActiveReservations;
  }

  /**
   * Définit la valeur de la propriété nbActiveReservations.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setNbActiveReservations(Integer value) {
    this.nbActiveReservations = value;
  }

  /**
   * Obtient la valeur de la propriété publisherName.
   *
   * @return possible object is {@link String }
   */
  public String getPublisherName() {
    return publisherName;
  }

  /**
   * Définit la valeur de la propriété publisherName.
   *
   * @param value allowed object is {@link String }
   */
  public void setPublisherName(String value) {
    this.publisherName = value;
  }
}
