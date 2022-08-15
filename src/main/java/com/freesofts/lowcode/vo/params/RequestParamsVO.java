package com.freesofts.lowcode.vo.params;

import lombok.Data;

/**
 * @author zhouwei
 */
@Data
public class RequestParamsVO {
    private Integer apiId;
    private String path;
    private String method;
    private String key;
}
