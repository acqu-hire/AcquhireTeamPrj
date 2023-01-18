package com.aqh.common.domain.dto;

import lombok.Data;

/**
 * @author Devesg
 * @since 23.01.18
 */
@Data
public class AttachFileDTO {
    
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
}
