package cn.edu.ncu.stephenhe.recruitment.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Name;

/**
 * <p>
 * 
 * </p>
 *
 * @author StephenHe
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_logo")
    private String companyLogo;

    @Column(name = "company_tel")
    private String companyTel;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "company_state")
    private Integer companyState;

    @Column(name = "company_admin")
    private Integer companyAdmin;
}
