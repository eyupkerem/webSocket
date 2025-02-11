package com.malkoc.webSocketApp.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table
public class Users {
    @Id
    private String fullName;
    private String nickName;
    private Status  status;
}
