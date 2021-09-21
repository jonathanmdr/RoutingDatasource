package br.com.multidatasources.multidatasources.model.factory;

import br.com.multidatasources.multidatasources.model.Billionaire;

public class BillionaireBuilder {

    private Billionaire billionaire;

    public BillionaireBuilder() {
        this.billionaire = new Billionaire();
    }

    public BillionaireBuilder id(Long id) {
        this.billionaire.setId(id);
        return this;
    }

    public BillionaireBuilder firstName(String firstName) {
        this.billionaire.setFirstName(firstName);
        return this;
    }

    public BillionaireBuilder lastName(String lastName) {
        this.billionaire.setLastName(lastName);
        return this;
    }

    public BillionaireBuilder career(String career) {
        this.billionaire.setCareer(career);
        return this;
    }

    public Billionaire build() {
        return this.billionaire;
    }

}
