package x3.benjamin.playground.apiserver.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import x3.benjamin.playground.apiserver.model.ErrorMessageDto;

//TODO - 1 ApplicationContext 에 등록하려면 어떤 annotation 을 사용해야 하나요?
//TODO - 1 ApplicationContextに登録するには、いくつかのannotationを使用か？
public class CommonControllerAdvice {

    // API 에러 처리.
    // TODO - 2, NumberFormatException 에 대해서 에러 처리하기 위한 적절한 annotation 을 입력하세요
    // TODO - 2、NumberFormatExceptionに対してエラーを処理するための適切なannotationを入力してください
    @ResponseBody
    public ResponseEntity<Object> handleApiFailedException(NumberFormatException ex) {


        //Body
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage(), ex);

        //TODO - 3, 응답에 transaction-id 헤더를 포함하고 싶습니다.
        // TODO - 3、応答にtransaction-idヘッダが含まれてと思います。
        //spec 을 보고 적당하게 프로그래밍 해주세요. HttpHeaders 라는 클래스를 사용하면 편합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("header-name", "header-value");


        return new ResponseEntity(errorMessageDto, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
