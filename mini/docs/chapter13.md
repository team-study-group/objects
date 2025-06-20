# Chapter13 > 서브클래싱과 서브타이핑

📌 학습 내용 요약   

상속은 2가지 용도로 사용 된다.
1. 타입 계층에 따라: 인터페이스 상속
2. 코드의 재사용에 따라: 서브클래싱, 구현 상속, 클래스 상속  

상속의 1차 목표는 타입 계층에 따라 구성하는 것.

### 1. 타입
- 관점에 따라 타입을 알아보자
    - 개념 관점: 인간이 인지하는 세상의 사물의 종류, 공통의 특징을 공유하는 대상의 분류
        - 심볼(이름), 내연(공통의 속성, 행동), 외연(타입에 속하는 집합)
    - 프로그래밍 언어 관점: 동일한 오퍼레이션을 적용할 수 있는 인스턴스들의 집합
      - 타입에 수행될 수 있는 유효한 오퍼레이션의 집합 정의:   
      객체의 타입에 따라 적용 가능한 연산자의 종류를 제한함으로써 프로그래머의 실수를 막는다.
      - 타입에 수행되는 오퍼레이션에 대해 미리 약속된 문맥 제공한다.
    - 객체지향 패러다임관점: 객체의 퍼블릭 인터페이스가 객체의 타입을 결정한다. 동일한 퍼블릭 인터페이스를 제공하는 객체들은 동일한 타입으로 분류된다.

**객체의 타입을 결정하는 것은 내부의 속성이 아니라, 객체가 외부에 제공하는 행동이다.**

## 2. 타입계층

- 슈퍼타입: 슈퍼셋, 일반화, 상대적인 범용성, 넓은 의미
- 서브타입: 서브셋, 특수화, 상대적인 구체성, 좁은 의미

둘을 구분짓는 기준: 퍼블릭 인터페이스

## 3. 서브 클래싱 vs 서브 타이핑

- 언제 상속을 써야하는가?
    1. 상속관계가 is-a 관계를 모델링하는가?
    2. 클라이언트 입장에서 부모클래스의 타입으로 자식클래스를 사용해도 무방한가? (행동호환성)
- 예시: 새 - 펭귄
- **중요한건 is-a 보다는 행동호환성, 클라이언트 입장이 중요하다.
  이름 사이에 개념적으로 연관성이 있더라도, 행동에 연관성이 없다면 Is-a관계를 사용하지 말아야 한다.**
- 두 타입 사이에 행동이 호환될 경우에만 타입계층으로 묶어야 한다.
- 단순히 동일한 메서드를 구현하면 행동이 호환되는게 아니라, 클라이언트 입장에서 두 타입이 동일하게 행동할것이라고 기대할때 두 타입을 타입계층으로 묶을 수 있다.
- 서브 클래싱과 서브 타이핑을 나누는 기준은 상속을 사용하는 목적이다.
    - **서브 클래싱**: 자식클래스가 부모클래스의 코드를 재사용하는 목적
    - **서브 타이핑:**  부모클래스의 인스턴스 대신, 자식 클래스를 사용할 목적

## 4. LSP

- 서브타입은 그것의 기반타입에 대해 대체 가능해야한다.
- 차이점을 인식하지 못한 채 기반 클래스의 인터페이스를 통해 서브 클래스를 사용할 수 있어야한다.
- 행동호환성을 설계 원칙으로 정리.
- 상속관계는 클라이언트 관점에서 자식 클래스가 부모클래스를 대체할 수 있을 때만 올바르다.
- 행동을 고려하지 않은 두 타입의 이름이 단순히 is-a 로 연결가능하다 해서 상속관계로 연결하지 마라.
  이름이 아니라 행동이 먼저다.
- 구현 방법과 무관하게 클라이언트의 관점에서 슈퍼타입에 대해 기대하는 모든 것이 서브타입에게도 적용돼야한다.

## 5. 계약에 의한 설계와 서브 타이핑

- 계약에 의한 설계 (Design By Contract, DBC)
    - 클라이언트 - 서버 사이의 협력을 의무와 이익으로 구성된 계약의 관점에서 표현하는 것.
    - 3가지 구성
        - 사전조건: 클라이언트가 정상적으로 메서드를 실행하기 위해 만족시켜야하는 조건
        - 사후조건: 메서드가 실행된 후에 서버가 클라이언트에게 보장해야하는 조건
        - 클래스 불변식: 메서드 실행 전후에 인스턴스가 만족시켜야하는 것
- LSP 와 DBC 사이의 관계: 서브타입이 LSP를 만족시키기 위해서는 클라이언트와 슈퍼타입 간에 체결된 ‘계약’을 준수해야한다.
- 자식클래스가 부모클래스의 서브타입이 되기위해서는 다음 조건을 만족시켜야한다.
    - 서브타입에 더 강력한 사전조건을 정의할 수 없다.
    - 서브타입에 같거나 더 약한 사전조건을 정의할 수 있다.
    - 서브타입에 슈퍼타입과 같거나 더 강한 사후조건을 정의할 수 있다.
    - 서브타입에 더 약한 사후조건을 정의할 수 없다.

## 💡 느낀 점
-  행동을 고려하지 않은 두 타입의 이름이 단순히 is-a 로 연결 가능하다 해서 상속관계로 연결하면 안된다. 이름이 아니라 행동이 먼저다.
- 코드 재사용을 위해서가 아니라 행동 호환성, 대체가능성을 만족할때 상속을 사용하도록 해야겠다.

## ❓ 궁금한 점


## 🔗 참고 링크
