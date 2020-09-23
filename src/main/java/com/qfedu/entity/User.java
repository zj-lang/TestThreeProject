package com.qfedu.entity;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 3:34
 * description:user实体类
 */
public class User {
    public Integer id;
    public String tel;
    public String password;
    public String email;
    public String invitation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }
}
