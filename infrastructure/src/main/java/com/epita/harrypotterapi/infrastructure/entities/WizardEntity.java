package com.epita.harrypotterapi.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class WizardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    @Enumerated(EnumType.STRING)
    private WizardRole role;

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<ReservationEntity> reservations;

    public WizardEntity() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WizardRole getRole() {
        return role;
    }

    public void setRole(WizardRole role) {
        this.role = role;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
