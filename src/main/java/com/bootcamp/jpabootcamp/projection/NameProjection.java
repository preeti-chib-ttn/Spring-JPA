package com.bootcamp.jpabootcamp.projection;


// Projection to get name of Employee or anyone in read only form
public interface NameProjection {
   String getFirstName();
   String getLastName();
}
