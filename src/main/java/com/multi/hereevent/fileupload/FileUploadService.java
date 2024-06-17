package com.multi.hereevent.fileupload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Service
public class FileUploadService {
    // 프로필 이미지 업로드 경로
    // Naver Cloud 서버 이용하는 경우 해 서버에 저장될 수 있도록 변경하기 !!
    @Value("C:/hereevent_upload/")
    private String filePath;

    // 프로필 이미지 경로
    public String getFilePath(String filename){
        return filePath + filename;
    }


    // 프로필 사진 저장
    public String uploadProfileImg(MultipartFile multipartFile) throws IOException {
        String storeFilename = "";

        if(!multipartFile.isEmpty()) {
            String originalFilename = multipartFile.getOriginalFilename();
            if(originalFilename != null) {
                storeFilename = createStoreFilename(originalFilename);
                multipartFile.transferTo(new File(getFilePath(storeFilename)));
            }
        }
        return storeFilename;
    }

    // 이벤트 사진 저장
    public String uploadEventImg(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);
        int position = imgUrl.lastIndexOf('/');
        String storeFilename = imgUrl.substring(position + 1) + ".png";

        BufferedImage img = ImageIO.read(url);
        try {
            ImageIO.write(img, "png", new File(getFilePath(storeFilename)));
        } catch (IllegalArgumentException ignored) {
            storeFilename = null;
        }
        return storeFilename;
    }

    // UUID 를 이용해서 파일명 변환
    private String createStoreFilename(String originalFilename) {
        int position = originalFilename.lastIndexOf('.'); // 확장자 위치 구하기
        String ext = originalFilename.substring(position); // ".확장자" 추출
        String uuid = UUID.randomUUID().toString();
        return uuid + ext;
    }
}
