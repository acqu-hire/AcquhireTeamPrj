package com.aqh.common.domain;

import lombok.Data;

/**
 * @author Devesg
 * @since 23.01.18
 */
@Data
public class AttachFileDTO {
    
    private String fileName;
    private String uuid;
    private String uploadPath;
    private boolean image;
}
