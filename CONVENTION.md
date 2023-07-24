# CONVENTION

## 1. 인코딩
UTF-8 로 통일

## 2 패키지 이름 소문자로 구성
```
package com.momo.customer.control
```
## 3. 클래스/인터페이스 이름에 대문자 카멜 표기법 적용
```
public class ProductService
```
## 4. 한 줄에 한 문장
```
int number = 0;
String password;
```
## 5. 중괄호 앞뒤에 공백 삽입
```
public class ProductService {
	try {
		System.out.println("트라이");
	} catch(Exception e) {
		System.out.println("캐치");
	} finally {
		if(session != null) {
		    session.close();
		}
	}
}
```
## 6. 대괄호 뒤에 공백 삽입
```
int[] masks = new int[] {0, 1, 1};
```
## 7. 줄바꿈 후 추가 들여쓰기
```
List<Product> list = 
				repository.selectAll(startRow, endRow);
```
## 8. 제어문 키워드와 여는 소괄호 사이에 공백 삽입
```
if (maxLine > LIMTED) {
	return false;
}
```
## 9. 타입 캐스팅에 쓰이는 소괄호 내부 공백 미삽입
```
String message = (String)rawLine;
```
## 10. 콤마/구분자 세미콜론의 뒤에만 공백 삽입
```
for (int i = 0; i < length; i++) {
	display(i, z);
}
```
