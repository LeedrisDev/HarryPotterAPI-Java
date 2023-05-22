package com.epita.harrypotterapi.infrastructure.mappers;

import com.epita.harrypotterapi.domain.models.wizard.Wizard;
import com.epita.harrypotterapi.infrastructure.entities.WizardEntity;
import org.springframework.stereotype.Component;

@Component
public class WizardsMapper {
    public WizardEntity mapToEntity(Wizard wizard) {
        var wizardEntity = new WizardEntity();
        wizardEntity.setId(wizard.getId());
        wizardEntity.setName(wizard.getName());
        wizardEntity.setUsername(wizard.getUsername());
        wizardEntity.setEmail(wizard.getEmail());
        wizardEntity.setRole(wizard.getRole());

        return wizardEntity;
    }

    public Wizard mapToDomain(WizardEntity wizardEntity) {
        var wizard = new Wizard.Builder()
                .id(wizardEntity.getId())
                .name(wizardEntity.getName())
                .username(wizardEntity.getUsername())
                .role(wizardEntity.getRole());

        return wizard.build();
    }
}
