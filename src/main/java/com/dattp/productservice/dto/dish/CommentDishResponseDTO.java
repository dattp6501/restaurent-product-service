package com.dattp.productservice.dto.dish;

import java.time.LocalDateTime;
import java.util.Date;

import com.dattp.productservice.entity.CommentDish;
import com.dattp.productservice.entity.User;
import com.dattp.productservice.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class CommentDishResponseDTO {
    private Long id;
    private int star;
    private String comment;
    private User user;

    @JsonFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    private LocalDateTime date;
    public CommentDishResponseDTO() {
    }

    public CommentDishResponseDTO(CommentDish cd) {
        copyProperties(cd);
    }

    public void copyProperties(CommentDish cd){
        BeanUtils.copyProperties(cd, this);
        this.date = DateUtils.convertToLocalDateTime(cd.getDate());
    }
}
