package com.exception.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.exception.dto.OrderItemDto;

import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {

	@Autowired
    private JavaMailSender javaMailSender;

//Method created for sending order details to respected user
    	public void sendOrderConfirmationEmail(String recipientEmail, List<OrderItemDto> orderDetails, BigDecimal totalAmount) {
            MimeMessage message = javaMailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(recipientEmail);
                helper.setSubject("Order Confirmation");

                StringBuilder emailContent = new StringBuilder();
                emailContent.append("<html><body>");
                emailContent.append("<h2>Thank you for your order!</h2>");
                emailContent.append("<table border='1'>");
                emailContent.append("<tr><th>Product Name</th><th>Product Image</th><th>Product Quantity</th><th>Product Price</th></tr>");

                for (OrderItemDto orderItem : orderDetails) {
                    emailContent.append("<tr>");
                    emailContent.append("<td>").append(orderItem.getName()).append("</td>");
                    emailContent.append("<td>").append("<img src='").append(orderItem.getImageUrl()).append("' alt='Product Image' width='100' height='100'/>").append("</td>");
                    emailContent.append("<td><center>").append(orderItem.getQuantity()).append("</center></td>");
                    emailContent.append("<td><center>").append("₹").append(orderItem.getProductprice()).append("</center></td>");
                    emailContent.append("</tr>");
                }

                emailContent.append("</table>");
                emailContent.append("<p>Total Amount: ₹").append(totalAmount).append("</p>");
                emailContent.append("</body></html>");

                helper.setText(emailContent.toString(), true);
                
                javaMailSender.send(message);
            } catch (Exception e) {
                // Handle exception
                e.printStackTrace();
            }
        }
	
}
