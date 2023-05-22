package com.epita.harrypotterapi.domain.models.wizard;

public class Wizard {
    private long id;
    private String name;
    private String username;
    private String email;
    private WizardRole role;

    public long getId() {
        return id;
    }

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
        private long id = 0;
        private String name = "";
        private String username;
        private String email;
        private WizardRole role = null;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

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
            wizard.id = this.id;
            wizard.name = this.name;
            wizard.username = this.username;
            wizard.email = this.email;
            wizard.role = this.role;
            return wizard;
        }
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
