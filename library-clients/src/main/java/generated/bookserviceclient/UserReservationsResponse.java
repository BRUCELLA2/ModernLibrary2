package generated.bookserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe Java pour userReservationsResponse complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="userReservationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://services.libraryws.projects.brucella.fr/}reservationDetailsDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "userReservationsResponse",
    propOrder = {"_return"})
public class UserReservationsResponse {

  @XmlElement(name = "return")
  protected List<ReservationDetailsDto> _return;

  /**
   * Gets the value of the return property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the return property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getReturn().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link ReservationDetailsDto }
   */
  public List<ReservationDetailsDto> getReturn() {
    if (_return == null) {
      _return = new ArrayList<ReservationDetailsDto>();
    }
    return this._return;
  }
}
