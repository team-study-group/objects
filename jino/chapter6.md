# Week 4 - chapter 6 메시지와 인터페이스

## 📌 학습 내용 요약
- 객체지향 프로그래밍에 대한 가장 흔한 오해는 애플리케이션이 클래스의 집합으로 구성 된다는 것
  - 객체를 지향, 협력 안에서 객체가 수행하는 책임에 초점을 맞춰야 한다
  - 책임은 객체가 수신할 수 있는 메시지의 기반이 된다는 것
- 메시지의 요청과 응답이 객체의 협력이 된다
- 메시지 수신자, 오퍼레이션명, 인자
  - condition.isSatisfiedBy(screening) 차례대로
  - 컴파일 시점과 실행 시점에서 어떤 수신자가 받을지 모른다는 것이 중요
  - 우리는 그저 메시지에 응답 할 수 있는 객체가 존재하고, 그 객체가 적절한 메서드를 선택해서 응답할 것이라고 믿는 것
- 좋은 인터페이스 : 최소한의 인터페이스와 추상적인 인터페이스 조건을 만족
- 물으려는 객체가 정말로 데이터인 경우도 있다. 묻는 대상이 객체인지, 자료 구조인지에 달려있다. 객체는 내부 구조를 숨겨야 하지만, 자료 구조라면 당연히 내부를 노출해야한다.
- 경우에 따라 다르다!
- 명령과 쿼리를 엄격하게 분류하면 객체의 부수효과를 제어하기 수월해진다
  - 참조 투명성: 어떤 표현식 e가 있을 대 e 의 값으로 e 가 나타나는 모든 위치를 교체하더라도 결과가 달라지지 않는 특성
  - 명령-쿼리 분리 원칙으로 예외 투성인 객체지향의 세상에 참조 투명성으로 인해 조금이나마 균열을 줄일 수 있다. 
 

## 💡 느낀 점
- 묻지말고 시켜라
  - 메시지 스타일 : 상태를 물어보고 값을 가져오는게 아니라, 너가 책임지고 하라고 시키는 것
  - 연관된 정보와 행동을 가지는 객체를 만들 수 있음
  - 메서드명은 어떻게 하는지가 아니라 무엇을 하는지를 서술해야한다
- 몇가지 원칙으로 조금더 우아한 설계가 될 수 있다는 것

## ❓ 궁금한 점
- 애플리케이션이 클래스의 집합으로 구성 되는 것이 아닌가?
- 퍼블릭 인터페이스란?
  - 객체가 외부에 제공하는 메시지(메서드)의 집합: 다른 객체들이 해당 객체에게 요청을 보낼 수 있는 통로입니다. 즉, 객체가 "무엇을 할 수 있는지"를 정의하는 부분입니다.
  - 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합
- 디미터 법칙의 위반 여부는 묻는 대상이 객체인지 자료구조인지에 따라 달려 있다고 하는데 자료 구조라면 당연히 내부를 노출해야 한다고 하는데 이게 무슨 말일까 (p.202)
- 게시물 조회 했을 때 조회수를 늘리려고 한다면 설계를 어떻게 해야 할까?
  - command query 분리의 관점에서
    - controller 를 분리? service 에서 분리? 
  - 물론 체크하는 로직에서 수정이 들어가 있는 것을 인식하지 못하고 숨겨져 있는 버그가 발생할 수 있다는 것은 이해함


## 🔗 참고 링크
-

