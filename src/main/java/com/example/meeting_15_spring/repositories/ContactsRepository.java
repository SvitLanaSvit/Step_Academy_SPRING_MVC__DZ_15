package com.example.meeting_15_spring.repositories;

import com.example.meeting_15_spring.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<Contact, Long> {
}
