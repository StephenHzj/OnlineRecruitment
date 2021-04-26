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
@Table(name = "admin")
public class Admin{


    @Id
    @NotNull
    private Integer adminId;

    @Column(name = "admin_tel")
    @NotNull
    private String adminTel;

    @Column(name = "admin_name")
    @NotNull
    private String adminName;

    @Column(name = "admin_password")
    @NotNull
    private String adminPassword;


}
