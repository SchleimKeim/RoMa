package ch.zhaw.roma.model;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class CompanyModel {
    @Id
    @Column(name = "AUTHOR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AddressModel address;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
