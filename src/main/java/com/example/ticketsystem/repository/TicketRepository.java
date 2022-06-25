package com.example.ticketsystem.repository;

import com.example.ticketsystem.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select t from Ticket t order by id")
    List<Ticket> findAll();
    @Query("select t from Ticket t where t.id = :id")
    List<Ticket> findById(String id);
    @Query(value = "select t from Ticket t order by deadlineAt")
    List<Ticket> sortByDeadline();
    @Query(value = "select t from Ticket t order by priority")
    List<Ticket> sortByPriority();
}
