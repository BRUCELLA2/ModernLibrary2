
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reservationDetailsDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservationDetailsDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.libraryws.projects.brucella.fr/}bookReservation">
 *       &lt;sequence>
 *         &lt;element name="firstEndBorrowDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservationDetailsDto", propOrder = {
    "firstEndBorrowDate",
    "title"
})
public class ReservationDetailsDto
    extends BookReservation
{

    protected String firstEndBorrowDate;
    protected String title;

    /**
     * Obtient la valeur de la propriété firstEndBorrowDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstEndBorrowDate() {
        return firstEndBorrowDate;
    }

    /**
     * Définit la valeur de la propriété firstEndBorrowDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstEndBorrowDate(String value) {
        this.firstEndBorrowDate = value;
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
