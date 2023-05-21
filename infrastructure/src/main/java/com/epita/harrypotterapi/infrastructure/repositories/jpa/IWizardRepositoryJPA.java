package com.epita.harrypotterapi.infrastructure.repositories.jpa;

import com.epita.harrypotterapi.infrastructure.entities.WizardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWizardRepositoryJPA extends JpaRepository<WizardEntity, Long> {
    WizardEntity getWizardEntityByUsername(String username);
}
