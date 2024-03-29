package com.epita.harrypotterapi.infrastructure.entities;

import com.epita.harrypotterapi.domain.models.wizard.WizardRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_WIZARDS")
public class WizardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
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

    @Override
    public String toString() {
        return "WizardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", reservations=" + reservations +
                '}';
    }
}
