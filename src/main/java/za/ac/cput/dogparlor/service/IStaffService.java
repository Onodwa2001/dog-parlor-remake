/* IStaffService.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Staff;

import java.util.List;

public interface IStaffService extends IService<Staff, String> {
    List<Staff> getAll();
}
