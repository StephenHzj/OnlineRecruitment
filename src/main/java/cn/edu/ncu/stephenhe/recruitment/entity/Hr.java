package cn.edu.ncu.stephenhe.recruitment.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name = "hr")
public class Hr{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "hr_tel")
    private String hrTel;

    @Column(name = "hr_name")
    private String hrName;

    @Column(name = "hr_password")
    private String hrPassword;

    @Column(name = "hr_logo")
    private String hrLogo;

    @Column(name = "hr_email")
    private String hrEmail;

    @Column(name = "hr_profile")
    private String hrProfile;

    @ManyToOne(targetEntity = Company.class)
    private Company company;


}
