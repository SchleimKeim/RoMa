package ch.zhaw.roma.model.test;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class TestCompanyModel {
    @Id
    @Column(name = "AUTHOR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private TestAddressModel address;

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

    public TestAddressModel getAddress() {
        return address;
    }

    public void setAddress(TestAddressModel address) {
        this.address = address;
    }
}
