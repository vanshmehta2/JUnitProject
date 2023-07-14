package com.example.demo.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.example.demo.service.ContactManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactManagerTest {
	 private ContactManager contactManager;
 
    @BeforeAll
    public void setupAll() {
        System.out.println("Should Print Before All Tests");
    }
 
    @BeforeEach
    public void setup() {
        System.out.println("Instantiating Contact Manager");
        contactManager = new ContactManager();
    }
	 	@Test
	    @DisplayName("Should Create Contact")
	    public void shouldCreateContact() {
	        contactManager.addContact("John", "Doe", "0123456789");
	        assertFalse(contactManager.getAllContacts().isEmpty());
	        assertEquals(1, contactManager.getAllContacts().size());
	    }
	 	
	 	 @Test
	     @DisplayName("Should Not Create Contact When First Name is Null")
	     public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
	         Assertions.assertThrows(RuntimeException.class, () -> {
	             contactManager.addContact(null, "Doe", "0123456789");
	         });
	     }
	  
	     @Test
	     @DisplayName("Should Not Create Contact When Last Name is Null")
	     public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
	         Assertions.assertThrows(RuntimeException.class, () -> {
	             contactManager.addContact("John", null, "0123456789");
	         });
	     }
	  
	     @Test
	     @DisplayName("Should Not Create Contact When Phone Number is Null")
	     public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
	         Assertions.assertThrows(RuntimeException.class, () -> {
	             contactManager.addContact("John", "Doe", null);
	         });
	     }
	     
	     @AfterEach
	     public void tearDown() {
	         System.out.println("Should Execute After Each Test");
	     }
	  
	     @AfterAll
	     public void tearDownAll() {
	         System.out.println("Should be executed at the end of the Test");
	     }
	     
	     	@Test
		    @DisplayName("Should Create Contact")
	     	@EnabledOnOs(value = OS.MAC, disabledReason = "Should Run only on MAC")
		    public void shouldCreateContactOnlyOnMac() {
		        contactManager.addContact("John", "Doe", "0123456789");
		        assertFalse(contactManager.getAllContacts().isEmpty());
		        assertEquals(1, contactManager.getAllContacts().size());
		    }
	     	@Test
		    @DisplayName("Should Create Contact")
	     	@EnabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled on Window OS")
		    public void shouldNotCreateContactOnlyOnWindows() {
		        contactManager.addContact("John", "Doe", "0123456789");
		        assertFalse(contactManager.getAllContacts().isEmpty());
		        assertEquals(1, contactManager.getAllContacts().size());
		    }
}
