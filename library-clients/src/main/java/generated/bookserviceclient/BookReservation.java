
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activeReservation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bookReservationId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dateReservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateReservationEmailSend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookReservation", propOrder = {
    "activeReservation",
    "bookId",
    "bookReservationId",
    "dateReservation",
    "dateReservationEmailSend",
    "userId"
})
@XmlSeeAlso({
    ReservationDetailsDto.class
})
public class BookReservation {

    protected Boolean activeReservation;
    protected Integer bookId;
    protected Integer bookReservationId;
    protected String dateReservation;
    protected String dateReservationEmailSend;
    protected Integer userId;

    /**
     * Obtient la valeur de la propriété activeReservation.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActiveReservation() {
        return activeReservation;
    }

    /**
     * Définit la valeur de la propriété activeReservation.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActiveReservation(Boolean value) {
        this.activeReservation = value;
    }

    /**
     * Obtient la valeur de la propriété bookId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * Définit la valeur de la propriété bookId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookId(Integer value) {
        this.bookId = value;
    }

    /**
     * Obtient la valeur de la propriété bookReservationId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookReservationId() {
        return bookReservationId;
    }

    /**
     * Définit la valeur de la propriété bookReservationId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookReservationId(Integer value) {
        this.bookReservationId = value;
    }

    /**
     * Obtient la valeur de la propriété dateReservation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateReservation() {
        return dateReservation;
    }

    /**
     * Définit la valeur de la propriété dateReservation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReservation(String value) {
        this.dateReservation = value;
    }

    /**
     * Obtient la valeur de la propriété dateReservationEmailSend.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateReservationEmailSend() {
        return dateReservationEmailSend;
    }

    /**
     * Définit la valeur de la propriété dateReservationEmailSend.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReservationEmailSend(String value) {
        this.dateReservationEmailSend = value;
    }

    /**
     * Obtient la valeur de la propriété userId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }

}
