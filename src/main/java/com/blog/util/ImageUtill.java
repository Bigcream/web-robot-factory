package com.blog.util;

import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Component;

import com.blog.dto.NewDTO;
import com.blog.entity.NewEntity;

@Component
public class ImageUtill {

    public  String convertBlobToThumbnail(NewEntity model) throws SQLException {
        int blobLength;
        blobLength = (int) model.getThumbnail_Blob().length();
        byte[] blobAsBytes = model.getThumbnail_Blob().getBytes(1, blobLength);
		String thumbnail_String = new String(blobAsBytes, StandardCharsets.UTF_8);
		model.setThumbnail(thumbnail_String);
        return model.getThumbnail();
    }
    public  Blob convertThumbnailtoBlob(NewDTO model) throws SQLException {
        byte[] byteArrray = model.getThumbnail().getBytes();
        Blob blob = null;
		try {
            blob = new SerialBlob(byteArrray);
        } catch (SQLException ex) {
            
        }
		return blob;
    }
    public  String convertBlobToImage(Blob blob) throws SQLException {
        int blobLength;
        blobLength = (int) blob.length();
        byte[] blobAsBytes = blob.getBytes(1, blobLength);
		String thumbnail_String = new String(blobAsBytes, StandardCharsets.UTF_8);
		
        return thumbnail_String;
    }
    public  Blob convertImagetoBlob(String image) throws SQLException {
        byte[] byteArrray = image.getBytes();
        Blob blob = null;
		try {
            blob = new SerialBlob(byteArrray);
        } catch (SQLException ex) {
            
        }
		return blob;
    }
}