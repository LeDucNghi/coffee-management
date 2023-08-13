package com.example.COFFEE.Jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //khi chạy chương trình nó sẽ nạp con container
@Slf4j //ghi log của lombock
public class JwtTokenProvider {
    @Value("${ra.jwt.secret}")
    private String JWT_SECRET; //là chuỗi để làm key cho mã hóa
    @Value("${ra.jwt.expiration}")
    private String JWT_EXPIRATION;
    // tạo jwt từ thông tin user


}
