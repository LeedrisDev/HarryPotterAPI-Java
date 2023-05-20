package com.epita.harrypotterapi.domain.models.wizard;

public class Wizard {
    private String name;
    private String username;
    private String email;
    private WizardRole role;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public WizardRole getRole() {
        return role;
    }

    private Wizard() { }

    public static class Builder {
        private String name;
        private String username;
        private String email;
        private WizardRole role;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            this.email = username + "@hogwarts.com";
            return this;
        }

        public Builder role(WizardRole role) {
            this.role = role;
            return this;
        }

        public Wizard build() {
            Wizard wizard = new Wizard();
            wizard.name = this.name;
            wizard.username = this.username;
            wizard.email = this.email;
            wizard.role = this.role;
            return wizard;
        }
    }
}