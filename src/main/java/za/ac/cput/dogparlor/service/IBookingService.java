/* IBookingService.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Booking;

import java.util.List;

public interface IBookingService extends IService<Booking, String> {
    List<Booking> getAll();
}
