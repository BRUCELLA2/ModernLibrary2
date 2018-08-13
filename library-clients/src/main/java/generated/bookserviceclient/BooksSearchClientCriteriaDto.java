
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour booksSearchClientCriteriaDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="booksSearchClientCriteriaDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authorLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ean13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publisherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "booksSearchClientCriteriaDto", propOrder = {
    "authorLastName",
    "bookAvailable",
    "ean13",
    "genreName",
    "publisherName",
    "title"
})
public class BooksSearchClientCriteriaDto {

    protected String authorLastName;
    protected Boolean bookAvailable;
    protected String ean13;
    protected String genreName;
    protected String publisherName;
    protected String title;

    /**
     * Obtient la valeur de la propriété authorLastName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * Définit la valeur de la propriété authorLastName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorLastName(String value) {
        this.authorLastName = value;
    }

    /**
     * Obtient la valeur de la propriété bookAvailable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBookAvailable() {
        return bookAvailable;
    }

    /**
     * Définit la valeur de la propriété bookAvailable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBookAvailable(Boolean value) {
        this.bookAvailable = value;
    }

    /**
     * Obtient la valeur de la propriété ean13.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEan13() {
        return ean13;
    }

    /**
     * Définit la valeur de la propriété ean13.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEan13(String value) {
        this.ean13 = value;
    }

    /**
     * Obtient la valeur de la propriété genreName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * Définit la valeur de la propriété genreName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenreName(String value) {
        this.genreName = value;
    }

    /**
     * Obtient la valeur de la propriété publisherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Définit la valeur de la propriété publisherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisherName(String value) {
        this.publisherName = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
