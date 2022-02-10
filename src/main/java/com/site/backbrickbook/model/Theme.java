package com.site.backbrickbook.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum Theme {
    STAR_WARS, CASTLE, LEGO_MOVIE, LONE_RANGER;
}