package com.metro.ticketing.metro_ticket_booking.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeGeneratorService {
	
	 public String generateQRCode(String data, int width, int height) throws WriterException, IOException {
		 
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
	        
	        return Base64.getEncoder().encodeToString(outputStream.toByteArray()); // Return Base64 String
	    }
}
