package site.metacoding.red.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespDto<T> {
	private Integer code; // 1 정상, -1 실패
	private String msg; // 통신에 대한 결과 메시지 담기
	private T body; //리턴타입이 항상 다르니까 제네릭을 써야한다.
}
