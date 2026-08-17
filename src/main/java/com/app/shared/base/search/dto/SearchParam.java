package com.app.shared.base.search.dto;

import com.app.shared.base.search.enums.SearchDataType;
import com.app.shared.base.search.enums.SearchOperation;
import lombok.Data;

@Data
public class SearchParam {
    private String field;
    private Object value;
    private SearchOperation operate;
    private SearchDataType type;
}
