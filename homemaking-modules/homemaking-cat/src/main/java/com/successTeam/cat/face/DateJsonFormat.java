package com.successTeam.cat.face;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * program: homemaking
 * ClassName DateJsonFormat
 * description:
 * author: xhonell
 * create: 2025年03月24日11时47分
 * Version 1.0
 **/
public interface DateJsonFormat {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date getCreated();
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date getUpdated();
}
