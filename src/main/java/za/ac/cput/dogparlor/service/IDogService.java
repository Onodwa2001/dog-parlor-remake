/* IDogService.java
  Entity for the Dog
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Dog;

import java.util.List;

public interface IDogService extends IService<Dog, String> {
    List<Dog> getAll();
}
