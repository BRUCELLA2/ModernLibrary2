package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe Java pour bookBorrowsCountDto complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="bookBorrowsCountDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbBorrows" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "bookBorrowsCountDto",
    propOrder = {"bookId", "nbBorrows", "title"})
public class BookBorrowsCountDto {

  protected Integer bookId;
  protected Integer nbBorrows;
  protected String title;

  /**
   * Obtient la valeur de la propriété bookId.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getBookId() {
    return bookId;
  }

  /**
   * Définit la valeur de la propriété bookId.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setBookId(Integer value) {
    this.bookId = value;
  }

  /**
   * Obtient la valeur de la propriété nbBorrows.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getNbBorrows() {
    return nbBorrows;
  }

  /**
   * Définit la valeur de la propriété nbBorrows.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setNbBorrows(Integer value) {
    this.nbBorrows = value;
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
   * @param value allowed object is {@link String }
   */
  public void setTitle(String value) {
    this.title = value;
  }
}
