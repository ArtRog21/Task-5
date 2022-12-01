package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private Long id;

   @Column (name = "username")
   private String firstName;

   @Column
   private String lastName;

   @Column
   private Byte age;

   @Column
   private String email;


   @OneToOne(optional = true, cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car car;

   public User() {
   }

   public User(String firstName, String lastName, Byte age, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public Byte getAge() {
      return age;
   }

   public void setAge(Byte age) {
      this.age = age;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public User setCar(Car car) {
      this.car = car;
      return this;
   }

   @Override
   public String toString() {
      return "\nUser{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\''+
              '}';
   }
}
